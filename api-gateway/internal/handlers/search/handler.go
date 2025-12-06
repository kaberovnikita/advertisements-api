package searchhandler

import (
	"context"
	"net/http"
	"time"

	searchclient "api-gateway/internal/clients/search"
	"api-gateway/pkg/res"
)

type SearchHandler struct {
	searchClient *searchclient.SearchClient
}

func NewSearchHandler(router *http.ServeMux, searchClient *searchclient.SearchClient) {
	handler := &SearchHandler{
		searchClient: searchClient,
	}

	router.HandleFunc("GET /api/v1/search", handler.SeatchAdvertisementsByTitle)
}

func (h *SearchHandler) SeatchAdvertisementsByTitle(w http.ResponseWriter, r *http.Request) {
	ctx, cancel := context.WithTimeout(r.Context(), 5*time.Second)
	defer cancel()

	title := r.URL.Query().Get("title")
	if len(title) == 0 {
		res.ErrResJson(w, "title query is required", http.StatusBadRequest)
		return
	}

	ads, err := h.searchClient.SearchByTitle(ctx, title)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}

	res.ResJson(w, ads, http.StatusCreated)
}
