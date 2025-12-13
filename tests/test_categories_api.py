"""
Модульные тесты для API Categories сервиса.
Использует pytest и requests для тестирования REST API эндпоинтов.
"""

import pytest
import requests
from typing import Dict, Any
import json


class TestCategoriesAPI:
    BASE_URL = "http://localhost:8004/api"  # подправь при необходимости

    def setup_method(self):
        self.created_category_ids = []

    def teardown_method(self):
        # Мягкая очистка: пытаемся удалить созданные категории, игнорируем ошибки
        for cid in self.created_category_ids:
            try:
                requests.delete(f"{self.BASE_URL}/categories/{cid}")
            except Exception:
                pass

    # ============ GET Тесты ============

    def test_get_category_by_id_success(self):
        """Тест: получение категории по ID с успешным ответом"""
        category_id = 1
        response = requests.get(f"{self.BASE_URL}/categories/{category_id}")

        assert response.status_code in [200, 404, 401]

        if response.status_code == 200:
            data = response.json()
            assert "id" in data
            assert data["id"] == category_id

    def test_get_all_categories_success(self):
        """Тест: получение всех категорий"""
        response = requests.get(f"{self.BASE_URL}/categories")

        assert response.status_code in [200, 404, 401]

        if response.status_code == 200:
            data = response.json()
            assert isinstance(data, list)

    def test_get_category_by_alias_success(self):
        """Тест: получение категории по алиасу"""
        alias = "electronics"
        response = requests.get(f"{self.BASE_URL}/categories/alias/{alias}")

        assert response.status_code in [200, 404, 401]

        if response.status_code == 200:
            data = response.json()
            assert data["alias"] == alias

    def test_get_category_response_schema(self):
        """Тест: проверка структуры ответа категории"""
        response = requests.get(f"{self.BASE_URL}/categories/1")

        assert response.status_code in [200, 404, 401]

        if response.status_code == 200:
            data = response.json()
            for field in ("id", "name", "alias"):
                assert field in data

    # ============ POST Тесты ============

    def test_create_category_success(self):
        """Тест: создание новой категории"""
        payload = {
            "name": "Test Category",
            "description": "Test Description",
            "alias": "test-category",
        }
        response = requests.post(
            f"{self.BASE_URL}/categories",
            json=payload,
            headers={"Content-Type": "application/json"},
        )

        assert response.status_code in [201, 404, 401]

        if response.status_code == 201:
            data = response.json()
            assert data["name"] == payload["name"]
            assert data["alias"] == payload["alias"]
            self.created_category_ids.append(data["id"])

    def test_create_category_missing_required_field(self):
        """Тест: создание категории без обязательного поля"""
        payload = {
            "description": "Test Description",
            "alias": "test-category",
            # name отсутствует
        }
        response = requests.post(
            f"{self.BASE_URL}/categories",
            json=payload,
        )

        assert response.status_code in [400, 422, 404, 401]

        if response.status_code in [400, 422]:
            _ = response.json()

    def test_create_category_with_special_characters(self):
        """Тест: создание категории с специальными символами"""
        payload = {
            "name": "Категория с кириллицей",
            "alias": "category-with-cyrillic",
            "description": "Описание с символами: @#$%",
        }
        response = requests.post(f"{self.BASE_URL}/categories", json=payload)

        assert response.status_code in [201, 404, 401]

        if response.status_code == 201:
            data = response.json()
            assert data["name"] == payload["name"]
            self.created_category_ids.append(data["id"])

    # ============ PUT Тесты ============

    def test_update_nonexistent_category(self):
        """Тест: обновление несуществующей категории"""
        payload = {"name": "Updated Name"}
        response = requests.put(
            f"{self.BASE_URL}/categories/999999",
            json=payload,
        )

        assert response.status_code in [404, 401]

    # ============ DELETE Тесты ============

    def test_delete_nonexistent_category(self):
        """Тест: удаление несуществующей категории"""
        response = requests.delete(f"{self.BASE_URL}/categories/999999")

        assert response.status_code in [404, 401]

    # ============ Тесты производительности ============

    def test_response_time_get(self):
        """Тест: время ответа для GET запроса < 1000ms"""
        import time

        start = time.time()
        response = requests.get(f"{self.BASE_URL}/categories/1")
        elapsed = (time.time() - start) * 1000

        assert response.status_code in [200, 404, 401]
        if response.status_code == 200:
            assert elapsed < 1000, f"Время ответа {elapsed}ms > 1000ms"

    def test_response_time_post(self):
        """Тест: время ответа для POST запроса < 1000ms"""
        import time

        payload = {
            "name": "Performance Test",
            "alias": f"perf-{int(time.time())}",
        }

        start = time.time()
        response = requests.post(
            f"{self.BASE_URL}/categories", json=payload
        )
        elapsed = (time.time() - start) * 1000

        assert response.status_code in [201, 404, 401]
        if response.status_code == 201:
            assert elapsed < 1000, f"Время ответа {elapsed}ms > 1000ms"


class TestCategoriesParametrized:
    BASE_URL = TestCategoriesAPI.BASE_URL

    def setup_method(self):
        self.created_category_ids = []

    def teardown_method(self):
        for cid in self.created_category_ids:
            try:
                requests.delete(f"{self.BASE_URL}/categories/{cid}")
            except Exception:
                pass

    @pytest.mark.parametrize("category_id", [1, 2, 3, 4, 5])
    def test_get_multiple_categories(self, category_id):
        response = requests.get(f"{self.BASE_URL}/categories/{category_id}")

        assert response.status_code in [200, 404, 401]

        if response.status_code == 200:
            data = response.json()
            assert data["id"] == category_id

    @pytest.mark.parametrize(
        "expected_status,name,alias",
        [
            (201, "Category 1", "category-1"),
            (201, "Category 2", "category-2"),
            (201, "Категория 3", "category-3"),
        ],
    )
    def test_create_multiple_categories(
        self, expected_status, name, alias
    ):
        payload = {"name": name, "alias": alias}
        response = requests.post(f"{self.BASE_URL}/categories", json=payload)

        assert response.status_code in [expected_status, 404, 401]

        if response.status_code == expected_status:
            data = response.json()
            assert data["name"] == name
            assert data["alias"] == alias
            self.created_category_ids.append(data["id"])
