import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  scenarios: {
    smoke: {
      executor: 'constant-vus',
      vus: 2,
      duration: '30s',
      exec: 'smokeCategories',
    },
    categories_flow: {
      executor: 'constant-vus',
      vus: 10,
      duration: '1m',
      exec: 'categoriesFlow',
      startTime: '30s',
    },
    categories_stress: {
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
    http_req_failed: ['rate<0.05'],
    http_req_duration: ['p(95)<200'],
    checks: ['rate>0.99'],
  },
};

const BASE_URL = 'http://host.docker.internal:8004';

// смоук: простые чтения
export function smokeCategories() {
  const byId = http.get(`${BASE_URL}/api/v1/categories/1`);
  check(byId, { 'GET /categories/1 200': (r) => r.status === 200 });

  const byAlias = http.get(`${BASE_URL}/api/v1/categories/alias/cat-1`);
  check(byAlias, {
    'GET /categories/alias/... 200': (r) => r.status === 200,
  });

  const all = http.get(`${BASE_URL}/api/v1/categories`);
  check(all, { 'GET /categories 200': (r) => r.status === 200 });

  sleep(1);
}

// полный поток: покрытие всех методов хендлера
export function categoriesFlow() {
  const createRes = http.post(
    `${BASE_URL}/api/v1/categories`,
    JSON.stringify({
      name: `Perf category ${__VU}-${__ITER}`,
      alias: `perf-cat-${__VU}-${__ITER}`,
    }),
    { headers: { 'Content-Type': 'application/json' } },
  );

  check(createRes, {
    'CreateCategory 201': (r) => r.status === 201,
  });

  let id;
  try {
    id = createRes.json('id');
  } catch (_) {
    sleep(1);
    return;
  }

  const getById = http.get(`${BASE_URL}/api/v1/categories/${id}`);
  check(getById, {
    'GetCategoryByID 200': (r) => r.status === 200,
  });

  const alias = `perf-cat-${__VU}-${__ITER}`;
  const getByAlias = http.get(
    `${BASE_URL}/api/v1/categories/alias/${encodeURIComponent(alias)}`,
  );
  check(getByAlias, {
    'GetCategoryByAlias 200': (r) => r.status === 200,
  });

  const all = http.get(`${BASE_URL}/api/v1/categories`);
  check(all, {
    'GetAllCategories 200': (r) => r.status === 200,
  });

  const updateRes = http.patch(
    `${BASE_URL}/api/v1/categories/${id}`,
    JSON.stringify({
      name: `Perf category updated ${__VU}-${__ITER}`,
      alias: `perf-cat-upd-${__VU}-${__ITER}`,
    }),
    { headers: { 'Content-Type': 'application/json' } },
  );

  check(updateRes, {
    'UpdateCategoryByID 200': (r) => r.status === 200,
  });

  const deleteRes = http.del(`${BASE_URL}/api/v1/categories/${id}`);
  check(deleteRes, {
    'DeleteCategoryByID 200/204': (r) =>
      r.status === 200 || r.status === 204,
  });

  sleep(1);
}

// стресс по чтениям
export function readHeavy() {
  const id = (__ITER % 100) + 1;

  const byId = http.get(`${BASE_URL}/api/v1/categories/${id}`);
  check(byId, {
    'Stress GET by id 200/404': (r) => r.status === 200 || r.status === 404,
  });

  const all = http.get(`${BASE_URL}/api/v1/categories`);
  check(all, { 'Stress GET all 200': (r) => r.status === 200 });

  sleep(0.2);
}
