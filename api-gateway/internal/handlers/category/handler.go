package categoryhandler

import (
	"context"
	"net/http"
	"strconv"
	"time"

	categoryclient "api-gateway/internal/clients/category"
	dtocategory "api-gateway/internal/handlers/category/dto"
	"api-gateway/pkg/req"
	"api-gateway/pkg/res"
)

type categoryHandler struct {
	categoryClient *categoryclient.CategoryClient
}

func NewCategoryHandler(router *http.ServeMux, categoryClient *categoryclient.CategoryClient) {
	handler := &categoryHandler{
		categoryClient: categoryClient,
	}

	router.HandleFunc("POST /api/v1/categories", handler.CreateCategory)
	router.HandleFunc("GET /api/v1/categories/{id}", handler.GetCategoryByID)
	router.HandleFunc("GET /api/v1/categories/alias/{alias}", handler.GetCategoryByAlias)
	router.HandleFunc("PATCH /api/v1/categories/{id}", handler.UpdateCategoryByID)
	router.HandleFunc("DELETE /api/v1/categories/{id}", handler.DeleteCategoryByID)

}

func (h *categoryHandler) CreateCategory(w http.ResponseWriter, r *http.Request) {
	ctx, cancel := context.WithTimeout(r.Context(), 5*time.Second)
	defer cancel()

	body, err := req.DecodedAndValidatedBody[dtocategory.CategoryDto](r.Body)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusBadRequest)
		return
	}

	id, err := h.categoryClient.CreateCategory(ctx, body.Name, body.Alias)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}

	data := &dtocategory.CreateCategoryResponse{
		Id: id,
	}

	res.ResJson(w, data, http.StatusCreated)
}

func (h *categoryHandler) GetCategoryByID(w http.ResponseWriter, r *http.Request) {
	ctx, cancel := context.WithTimeout(r.Context(), 5*time.Second)
	defer cancel()

	param := r.PathValue("id")

	id, err := strconv.Atoi(param)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}

	category, err := h.categoryClient.GetCategoryById(ctx, int64(id))
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}

	res.ResJson(w, category, http.StatusOK)
}

func (h *categoryHandler) GetCategoryByAlias(w http.ResponseWriter, r *http.Request) {
	ctx, cancel := context.WithTimeout(r.Context(), 5*time.Second)
	defer cancel()

	alias := r.PathValue("alias")

	category, err := h.categoryClient.GetCategoryByAlias(ctx, alias)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}

	res.ResJson(w, category, http.StatusOK)
}

func (h *categoryHandler) GetAllCategories(w http.ResponseWriter, r *http.Request) {
	ctx, cancel := context.WithTimeout(r.Context(), 5*time.Second)
	defer cancel()

	categories, err := h.categoryClient.GetAllCategories(ctx)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}

	res.ResJson(w, categories, http.StatusOK)
}

func (h *categoryHandler) UpdateCategoryByID(w http.ResponseWriter, r *http.Request) {
	ctx, cancel := context.WithTimeout(r.Context(), 5*time.Second)
	defer cancel()

	param := r.PathValue("id")

	id, err := strconv.Atoi(param)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}

	body, err := req.DecodedAndValidatedBody[dtocategory.UpdateCategoryDto](r.Body)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusBadRequest)
		return
	}

	category, err := h.categoryClient.UpdateCategoryById(ctx, int64(id), body.Name, body.Alias)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}

	res.ResJson(w, category, http.StatusOK)
}

func (h *categoryHandler) DeleteCategoryByID(w http.ResponseWriter, r *http.Request) {
	ctx, cancel := context.WithTimeout(r.Context(), 5*time.Second)
	defer cancel()

	param := r.PathValue("id")

	id, err := strconv.Atoi(param)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}

	_, err = h.categoryClient.DeleteCategoryById(ctx, int64(id))
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}
}
