import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  scenarios: {
    smoke_ads: {
      executor: 'constant-vus',
      vus: 2,
      duration: '30s',
      exec: 'getSingleAd',
    },
    ads_crud: {
      executor: 'constant-vus',
      vus: 10,
      duration: '1m',
      exec: 'adCrudFlow',
      startTime: '30s',
    },
    ads_stress_read: {
      executor: 'ramping-vus',
      startVUs: 0,
      stages: [
        { duration: '10s', target: 50 },
        { duration: '20s', target: 50 },
        { duration: '10s', target: 0 },
      ],
      exec: 'getSingleAd',
      startTime: '1m30s',
    },
  },
  thresholds: {
    http_req_failed: ['rate<0.05'],
    http_req_duration: ['p(95)<250'],
  },
};

const BASE_URL = 'http://host.docker.internal:8004';

export function getSingleAd() {
  const res = http.get(`${BASE_URL}/api/v1/ads/1`);
  check(res, { 'GET ad 200': (r) => r.status === 200 });
  sleep(1);
}

export function adCrudFlow() {
  const createRes = http.post(
    `${BASE_URL}/api/v1/ads`,
    JSON.stringify({
      title: `Perf ad ${__VU}-${__ITER}`,
      description: 'Load test ad',
      price: 1000,
      currency: 'RUB',
      category_id: 1,
      user_id: 1,
    }),
    { headers: { 'Content-Type': 'application/json' } },
  );

  check(createRes, {
    'create ad 201': (r) => r.status === 201,
  });

  let id;
  try {
    id = createRes.json('id');
  } catch (_) {
    sleep(1);
    return;
  }

  const getRes = http.get(`${BASE_URL}/api/v1/ads/${id}`);
  check(getRes, { 'get ad 200': (r) => r.status === 200 });

  const updateRes = http.put(
    `${BASE_URL}/api/v1/ads/${id}`,
    JSON.stringify({
      title: `Perf ad updated ${__VU}-${__ITER}`,
      price: 1500,
    }),
    { headers: { 'Content-Type': 'application/json' } },
  );
  check(updateRes, { 'update ad 200': (r) => r.status === 200 });

  const searchRes = http.get(
    `${BASE_URL}/api/v1/ads?query=Perf&page=1&size=10`,
  );
  check(searchRes, { 'search ads 200': (r) => r.status === 200 });

  const deleteRes = http.del(`${BASE_URL}/api/v1/ads/${id}`);
  check(deleteRes, {
    'delete ad 200/204': (r) => r.status === 200 || r.status === 204,
  });

  sleep(1);
}
