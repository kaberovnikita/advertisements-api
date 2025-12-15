# advertisements-api

 ![Go](https://img.shields.io/badge/go-%2300ADD8.svg?style=for-the-badge&logo=go&logoColor=white)
 ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
 ![Python](https://img.shields.io/badge/python-3670A0?style=for-the-badge&logo=python&logoColor=ffdd54)

## Описание

`advertisements-api` — это API-сервис для работы с объявлениями.

## Настройка переменных окружения

Перед запуском необходимо создать файл `.env` в корне проекта.

### 1. Создайте в корне проекта файл`.env` и заполните его

```
DB_USER=postgres
DB_PASSWORD=1234
DB_NAME=ads
JWT_SECRET=SuperSecretKeyForJWT@2024!WithSecureRandomBytes12345
```

### Запуск через Docker Compose(первый раз)

```bash
docker compose up -d --build
```

### Обычный запуск (после первого раза)

```bash
docker compose up -d
```

### Остановка приложения

```bash
docker compose down
```

### Перезапуск без пересборки

```bash
docker compose restart
```

### Проверка статуса контейнеров

```bash
docker compose ps
```

### Просмотр логов

```bash
docker compose logs -f
```

### Команда проекта

```
Каберов Никита
Бубеков Даниль
Макарова Ксения
Пасашков Юрий
Чурпанова Айсура
```

### Лицензия
MIT

