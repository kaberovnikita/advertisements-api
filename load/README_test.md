# Нагрузочное тестирование с k6, InfluxDB и Grafana

## Описание

В проекте настроено нагрузочное тестирование с помощью Grafana k6, InfluxDB v1 и Grafana.  
Скрипт `run-load-tests.sh` запускает полный набор тестов для четырёх доменов: категории, объявления, пользователи и поиск.

## Предварительные условия

- Установлен Docker и доступен из командной строки.  
- Подняты контейнеры InfluxDB (порт 8086) и Grafana (порт 3000), в InfluxDB создана БД `k6`.

## Структура скрипта

Общие параметры запуска k6 в Docker:

```bash
COMMON_ARGS=(
  --rm -i
  --network=host
  -e K6_OUT=influxdb=http://localhost:8086/k6
  -v "$PWD/load:/scripts"
)
```

Запуск четырёх наборов сценариев:

```bash
echo "== Categories =="
docker run "${COMMON_ARGS[@]}" grafana/k6 run /scripts/categories-http-full.js

echo "== Ads =="
docker run "${COMMON_ARGS[@]}" grafana/k6 run /scripts/ads-scenarios.js

echo "== Users =="
docker run "${COMMON_ARGS[@]}" grafana/k6 run /scripts/users-scenarios.js

echo "== Search =="
docker run "${COMMON_ARGS[@]}" grafana/k6 run /scripts/search-scenarios.js
```

Все запуски используют единый output `K6_OUT=influxdb=http://localhost:8086/k6`, поэтому метрики попадают в одну БД `k6` и далее анализируются в Grafana.

## Как запустить все сценарии

Предусловие: поднять докер 
```bash 
docker compose -f docker-compose.k6.yml up -d
```

1. Перейти в каталог с `run-load-tests.sh`.  
2. Однократно сделать скрипт исполняемым:

```bash
chmod +x run-load-tests.sh
```

3. Запустить полный набор нагрузочных тестов:

```bash
./run-load-tests.sh
```

В результате последовательно выполняются:

- **Categories** – `categories-http-full.js` со сценариями `smoke`, `categories_flow`, `categories_stress`.  
- **Ads** – `ads-scenarios.js` с нагрузочными сценариями для API объявлений.  
- **Users** – `users-scenarios.js` для операций с пользователями (создание, авторизация, чтение и обновление данных).  
- **Search** – `search-scenarios.js` для проверки поисковых запросов под нагрузкой.

k6 в консоль выводит статистику по каждому запуску: количество виртуальных пользователей, итераций, значения метрик `http_req_duration`, `http_req_failed`, `checks` и информацию о выполнении порогов (thresholds).

## Метрики и пороги

Все сценарии используют встроенные метрики k6:

- HTTP: `http_reqs`, `http_req_duration`, `http_req_failed`, `data_received`, `data_sent` и др.  
- Checks: `checks`, `checks_total`, `checks_succeeded`, `checks_failed`.

Пример настройки SLA‑порогов:

```js
export const options = {
  thresholds: {
    checks: ['rate>0.99'],         // не менее 99% успешных проверок
    http_req_failed: ['rate<0.05'] // не более 5% неуспешных запросов
  },
};
```

При нарушении порога k6 помечает тест как несоответствующий требованиям и выводит сообщение о пересечении threshold'ов по соответствующим метрикам.

## Анализ результатов в InfluxDB и Grafana

- Все сценарии пишут результаты в InfluxDB v1, БД `k6`, в измерения `http_reqs`, `http_req_duration`, `http_req_failed`, `checks`, `data_received`, `data_sent`, `vus`, `iterations` и другие.  
- В Grafana настроен data source типа **InfluxDB** с URL `http://localhost:8086` и базой `k6`; на его основе используется импортированный k6‑дашборд или собственные панели с графиками по доменам Categories, Ads, Users и Search (нагрузка, латентность p95/p99, процент ошибок, успешность checks).