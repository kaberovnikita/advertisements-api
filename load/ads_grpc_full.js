import grpc from 'k6/net/grpc';
import { check, sleep } from 'k6';

const client = new grpc.Client();
client.load(['/home/k6/proto'], 'proto/advertisements_storage.proto');

export const options = {
  scenarios: {
    smoke: {
      executor: 'constant-vus',
      vus: 2,
      duration: '30s',
      exec: 'smokeScenario',
    },
    full_flow: {
      executor: 'constant-vus',
      vus: 10,
      duration: '1m',
      exec: 'fullFlow',
      startTime: '30s',
    },
    stress_read: {
      executor: 'ramping-vus',
      startVUs: 0,
      stages: [
        { duration: '10s', target: 50 },
        { duration: '20s', target: 50 },
        { duration: '10s', target: 0 },
      ],
      exec: 'readHeavy',
      startTime: '1m30s',
    },
  },
  thresholds: {
    grpc_req_failed: ['rate<0.05'],
    grpc_req_duration: ['p(95)<200'],
    checks: ['rate>0.99'],
  },
};

const TARGET = __ENV.GRPC_TARGET || 'localhost:8005';

export function setup() {
  client.connect(TARGET, { plaintext: true });
}

export function teardown() {
  client.close();
}

// helpers

function createCategory(name, alias) {
  const res = client.invoke(
    'advertisements_storage.AdvertisementsStorage/CreateCategory',
    { name, alias },
  );
  check(res, {
    'CreateCategory OK': (r) =>
      r && r.status === grpc.StatusOK && r.message && r.message.id,
  });
  return res.message ? String(res.message.id) : null;
}

function createUser(email) {
  const res = client.invoke(
    'advertisements_storage.AdvertisementsStorage/RegisterUser',
    {
      email,
      password: 'Password123!',
      first_name: 'Perf',
      last_name: 'User',
      role: 'USER_ROLE_USER',
    },
  );
  check(res, {
    'RegisterUser OK': (r) =>
      r && r.status === grpc.StatusOK && r.message && r.message.id,
  });
  return res.message ? String(res.message.id) : null;
}

function loginUser(email) {
  const res = client.invoke(
    'advertisements_storage.AdvertisementsStorage/LoginUser',
    {
      email,
      password: 'Password123!',
    },
  );
  check(res, {
    'LoginUser OK': (r) =>
      r && r.status === grpc.StatusOK && r.message && r.message.access_token,
  });
  return res.message ? res.message.access_token : null;
}

function createAd(title, categoryId, userId) {
  const res = client.invoke(
    'advertisements_storage.AdvertisementsStorage/CreateAdvertisement',
    {
      title,
      description: 'Perf ad',
      price: 1000,
      currency: 'RUB',
      category_id: Number(categoryId),
      user_id: Number(userId),
    },
  );
  check(res, {
    'CreateAdvertisement OK': (r) =>
      r && r.status === grpc.StatusOK && r.message && r.message.id,
  });
  return res.message ? String(res.message.id) : null;
}

// сценарии

export function smokeScenario() {
  client.invoke(
    'advertisements_storage.AdvertisementsStorage/GetAllCategories',
    {},
  );
  client.invoke(
    'advertisements_storage.AdvertisementsStorage/GetAllAdvertisements',
    {},
  );
  client.invoke(
    'advertisements_storage.AdvertisementsStorage/GetAllUsers',
    {},
  );
  const res = client.invoke(
    'advertisements_storage.AdvertisementsStorage/SearchAdvertisementByTitle',
    { title: 'test' },
  );
  check(res, {
    'SearchAdvertisementByTitle OK': (r) => r && r.status === grpc.StatusOK,
  });
  sleep(1);
}

export function fullFlow() {
  const email = `perf-${__VU}-${__ITER}@example.com`;

  const categoryId = createCategory(
    `Category ${__VU}-${__ITER}`,
    `cat-${__VU}-${__ITER}`,
  );
  if (!categoryId) {
    sleep(1);
    return;
  }

  const userId = createUser(email);
  if (!userId) {
    sleep(1);
    return;
  }

  loginUser(email);

  const adId = createAd(
    `Perf ad ${__VU}-${__ITER}`,
    categoryId,
    userId,
  );
  if (!adId) {
    sleep(1);
    return;
  }

  const getAdRes = client.invoke(
    'advertisements_storage.AdvertisementsStorage/GetAdvertisementById',
    { id: Number(adId) },
  );
  check(getAdRes, {
    'GetAdvertisementById OK': (r) => r && r.status === grpc.StatusOK,
  });

  client.invoke(
    'advertisements_storage.AdvertisementsStorage/GetAllAdvertisements',
    {},
  );

  client.invoke(
    'advertisements_storage.AdvertisementsStorage/UpdateAdvertisementById',
    {
      id: Number(adId),
      title: `Perf ad updated ${__VU}-${__ITER}`,
      description: 'Updated',
      price: 1500,
      currency: 'RUB',
      category_id: Number(categoryId),
    },
  );

  client.invoke(
    'advertisements_storage.AdvertisementsStorage/SearchAdvertisementByTitle',
    { title: 'Perf ad' },
  );

  client.invoke(
    'advertisements_storage.AdvertisementsStorage/DeleteAdvertisementByID',
    { id: Number(adId) },
  );

  client.invoke(
    'advertisements_storage.AdvertisementsStorage/GetCategoryById',
    { id: Number(categoryId) },
  );
  client.invoke(
    'advertisements_storage.AdvertisementsStorage/GetCategoryByAlias',
    { alias: `cat-${__VU}-${__ITER}` },
  );
  client.invoke(
    'advertisements_storage.AdvertisementsStorage/GetAllCategories',
    {},
  );
  client.invoke(
    'advertisements_storage.AdvertisementsStorage/UpdateCategoryById',
    {
      id: Number(categoryId),
      name: `Category updated ${__VU}-${__ITER}`,
      alias: `cat-upd-${__VU}-${__ITER}`,
    },
  );
  client.invoke(
    'advertisements_storage.AdvertisementsStorage/DeleteCategoryById',
    { id: Number(categoryId) },
  );

  client.invoke(
    'advertisements_storage.AdvertisementsStorage/GetAllUsers',
    {},
  );
  client.invoke(
    'advertisements_storage.AdvertisementsStorage/GetUserByID',
    { id: Number(userId) },
  );
  client.invoke(
    'advertisements_storage.AdvertisementsStorage/GetUserByEmail',
    { email },
  );
  client.invoke(
    'advertisements_storage.AdvertisementsStorage/UpdateUserById',
    {
      id: Number(userId),
      email,
      password_hash: 'new-hash',
      first_name: 'PerfUpd',
      last_name: 'UserUpd',
      role: 'USER_ROLE_USER',
    },
  );
  client.invoke(
    'advertisements_storage.AdvertisementsStorage/DeleteUserById',
    { id: Number(userId) },
  );

  sleep(1);
}

export function readHeavy() {
  const id = (__ITER % 100) + 1;

  client.invoke(
    'advertisements_storage.AdvertisementsStorage/GetAdvertisementById',
    { id },
  );
  client.invoke(
    'advertisements_storage.AdvertisementsStorage/GetCategoryById',
    { id },
  );
  client.invoke(
    'advertisements_storage.AdvertisementsStorage/GetUserByID',
    { id },
  );
  client.invoke(
    'advertisements_storage.AdvertisementsStorage/SearchAdvertisementByTitle',
    { title: 'Perf' },
  );

  sleep(0.2);
}
