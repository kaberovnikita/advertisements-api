### 1. Создайте .env файл

В корне `advertisements-storage` создайте файл `.env`, добавьте:

```
DB_URL=postgres://postgres:1234@localhost:5432/ads?sslmode=disable
JWT_SECRET=SuperSecretKeyForJWT@2024!WithSecureRandomBytes12345
```

### Сборка и запуск

```bash
# Сборка сервиса
make build

# Запуск сервиса
make run

# Очистка bin
make clean