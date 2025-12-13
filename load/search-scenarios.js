import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  scenarios: {
    search_light: {
      executor: 'constant-vus',
      vus: 10,
      duration: '1m',
      exec: 'simpleSearch',
    },
    search_stress: {
      executor: 'ramping-vus',
      startVUs: 0,
      stages: [
        { duration: '10s', target: 30 },
        { duration: '30s', target: 30 },
        { duration: '10s', target: 0 },
      ],
      exec: 'simpleSearch',
      startTime: '1m10s',
    },
  },
  thresholds: {
    http_req_failed: ['rate<0.05'],
    http_req_duration: ['p(95)<150'],
  },
};

const BASE_URL = 'http://host.docker.internal:8004';

export function simpleSearch() {
  const q = ['car', 'bike', 'phone'][__ITER % 3];

  const res = http.get(
    `${BASE_URL}/api/v1/search?query=${encodeURIComponent(q)}&page=1&size=10`,
  );

  check(res, { 'search 200': (r) => r.status === 200 });

  sleep(0.5);
}
