#!/usr/bin/env bash
set -e

cd "$(dirname "$0")"

COMMON_ARGS=(
  --rm -i
  --network=host
  -e K6_OUT=influxdb=http://localhost:8086/k6
  -v "$PWD/load:/scripts"
)

echo "== Categories =="
docker run "${COMMON_ARGS[@]}" grafana/k6 run /scripts/categories-http-full.js

echo "== Ads =="
docker run "${COMMON_ARGS[@]}" grafana/k6 run /scripts/ads-scenarios.js

echo "== Users =="
docker run "${COMMON_ARGS[@]}" grafana/k6 run /scripts/users-scenarios.js

echo "== Search =="
docker run "${COMMON_ARGS[@]}" grafana/k6 run /scripts/search-scenarios.js
