package adshandler

import (
	adsclient "api-gateway/internal/clients/ads"
	dtoads "api-gateway/internal/handlers/ads/dto"
	"api-gateway/pkg/req"
	"api-gateway/pkg/res"
	"context"
	"net/http"
	"strconv"
	"time"
)

type adsHandler struct {
	adsClient *adsclient.AdsClient
}

func NewAdsHandler(router *http.ServeMux, adsClient *adsclient.AdsClient) {
	handler := &adsHandler{
		adsClient: adsClient,
	}

	router.HandleFunc("POST /api/v1/advertisements", handler.CreateAdvertisement)
	router.HandleFunc("GET /api/v1/advertisements/{id}", handler.GetAdvertisementByID)
	router.HandleFunc("GET /api/v1/advertisements", handler.GetAllAdvertisements)
	router.HandleFunc("PATCH /api/v1/advertisements/{id}", handler.UpdateAdvertisementByID)
	router.HandleFunc("DELETE /api/v1/advertisements/{id}", handler.DeleteAdvertisementByID)

}

func (h *adsHandler) CreateAdvertisement(w http.ResponseWriter, r *http.Request) {
	ctx, cancel := context.WithTimeout(r.Context(), 5*time.Second)
	defer cancel()

	body, err := req.DecodedAndValidatedBody[dtoads.AdsDto](r.Body)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusBadRequest)
		return
	}

	id, err := h.adsClient.CreateAdvertisement(
		ctx,
		body.Title,
		body.Description,
		body.Price,
		body.Currency,
		body.CategoryID,
		body.UserID,
	)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}

	data := &dtoads.CreateAdsResponse{
		Id: id,
	}

	res.ResJson(w, data, http.StatusCreated)
}

func (h *adsHandler) GetAdvertisementByID(w http.ResponseWriter, r *http.Request) {
	ctx, cancel := context.WithTimeout(r.Context(), 5*time.Second)
	defer cancel()

	param := r.PathValue("id")

	id, err := strconv.Atoi(param)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}

	ads, err := h.adsClient.GetAdvertisement(ctx, int64(id))
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}

	res.ResJson(w, ads, http.StatusOK)
}

func (h *adsHandler) GetAllAdvertisements(w http.ResponseWriter, r *http.Request) {
	ctx, cancel := context.WithTimeout(r.Context(), 5*time.Second)
	defer cancel()

	ads, err := h.adsClient.GetAllAdvertisement(ctx)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}

	res.ResJson(w, ads, http.StatusOK)
}

func (h *adsHandler) UpdateAdvertisementByID(w http.ResponseWriter, r *http.Request) {
	ctx, cancel := context.WithTimeout(r.Context(), 5*time.Second)
	defer cancel()

	param := r.PathValue("id")

	id, err := strconv.Atoi(param)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}

	body, err := req.DecodedAndValidatedBody[dtoads.UpdateAdsDto](r.Body)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusBadRequest)
		return
	}

	ads, err := h.adsClient.UpdateAdvertisement(
		ctx,
		int64(id),
		body.Title,
		body.Description,
		body.Price,
		body.Currency,
		body.CategoryID,
	)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}

	res.ResJson(w, ads, http.StatusOK)
}

func (h *adsHandler) DeleteAdvertisementByID(w http.ResponseWriter, r *http.Request) {
	ctx, cancel := context.WithTimeout(r.Context(), 5*time.Second)
	defer cancel()

	param := r.PathValue("id")

	id, err := strconv.Atoi(param)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}

	_, err = h.adsClient.DeleteAdvertisement(ctx, int64(id))
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}
}
