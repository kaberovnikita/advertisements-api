import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  scenarios: {
    users_auth_flow: {
      executor: 'constant-vus',
      vus: 10,
      duration: '1m',
      exec: 'authFlow',
    },
  },
  thresholds: {
    http_req_failed: ['rate<0.05'],
    http_req_duration: ['p(95)<200'],
  },
};

const BASE_URL = 'http://host.docker.internal:8004';

export function authFlow() {
  const email = `perf-${__VU}-${__ITER}@example.com`;
  const password = 'Password123!';

  const regRes = http.post(
    `${BASE_URL}/api/v1/users/register`,
    JSON.stringify({ email, password }),
    { headers: { 'Content-Type': 'application/json' } },
  );
  check(regRes, {
    'register 201/200': (r) => r.status === 201 || r.status === 200,
  });

  const loginRes = http.post(
    `${BASE_URL}/api/v1/users/login`,
    JSON.stringify({ email, password }),
    { headers: { 'Content-Type': 'application/json' } },
  );
  check(loginRes, { 'login 200': (r) => r.status === 200 });

  sleep(1);
}


