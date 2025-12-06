package usershandler

import (
	"context"
	"net/http"
	"strconv"
	"time"

	usersclient "api-gateway/internal/clients/users"
	usersdto "api-gateway/internal/handlers/users/dto"
	"api-gateway/pkg/req"
	"api-gateway/pkg/res"
)

type usersHandler struct {
	userClient *usersclient.UserClient
}

func NewUsersHandler(router *http.ServeMux, userClient *usersclient.UserClient) {
	handler := &usersHandler{
		userClient: userClient,
	}

	router.HandleFunc("POST /api/v1/users/register", handler.Register)
	router.HandleFunc("POST /api/v1/users/login", handler.Login)
	router.HandleFunc("GET /api/v1/users/email", handler.GetUserByEmail)
	router.HandleFunc("GET /api/v1/users", handler.GetAllUsers)
	router.HandleFunc("GET /api/v1/users/{id}", handler.GetUserById)
	router.HandleFunc("PATCH /api/v1/users/{id}", handler.UpdateUserByID)
	router.HandleFunc("DELETE /api/v1/users/{id}", handler.DeleteUserByID)
}

func (h *usersHandler) Register(w http.ResponseWriter, r *http.Request) {
	ctx, cancel := context.WithTimeout(r.Context(), 5*time.Second)
	defer cancel()

	body, err := req.DecodedAndValidatedBody[usersdto.RegisterDto](r.Body)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusBadRequest)
		return
	}

	role := body.ConvertRoleToPB()

	id, err := h.userClient.RegisterUser(ctx, body.Email, body.Password, body.FirstName, body.LastName, role)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}

	res.ResJson(w, id, http.StatusCreated)
}

func (h *usersHandler) Login(w http.ResponseWriter, r *http.Request) {
	ctx, cancel := context.WithTimeout(r.Context(), 5*time.Second)
	defer cancel()

	body, err := req.DecodedAndValidatedBody[usersdto.LoginDto](r.Body)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusBadRequest)
		return
	}

	accessToken, err := h.userClient.LoginUser(ctx, body.Email, body.Password)
	if err != nil {
		res.ErrResJson(w, "Invalid credentials", http.StatusUnauthorized)
		return
	}

	res.ResJson(w, accessToken, http.StatusOK)
}

func (h *usersHandler) GetUserByEmail(w http.ResponseWriter, r *http.Request) {
	ctx, cancel := context.WithTimeout(r.Context(), 5*time.Second)
	defer cancel()

	email := r.URL.Query().Get("email")
	if len(email) == 0 {
		res.ErrResJson(w, "title email is required", http.StatusBadRequest)
		return
	}

	user, err := h.userClient.GetUserByEmail(ctx, email)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}

	res.ResJson(w, user, http.StatusOK)
}

func (h *usersHandler) GetUserById(w http.ResponseWriter, r *http.Request) {
	ctx, cancel := context.WithTimeout(r.Context(), 5*time.Second)
	defer cancel()

	param := r.PathValue("id")

	id, err := strconv.Atoi(param)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}

	user, err := h.userClient.GetUserByID(ctx, int64(id))
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}

	res.ResJson(w, user, http.StatusOK)
}

func (h *usersHandler) GetAllUsers(w http.ResponseWriter, r *http.Request) {
	ctx, cancel := context.WithTimeout(r.Context(), 5*time.Second)
	defer cancel()

	users, err := h.userClient.GetAllUsers(ctx)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}

	res.ResJson(w, users, http.StatusOK)
}

func (h *usersHandler) UpdateUserByID(w http.ResponseWriter, r *http.Request) {
	ctx, cancel := context.WithTimeout(r.Context(), 5*time.Second)
	defer cancel()

	param := r.PathValue("id")
	id, err := strconv.Atoi(param)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusBadRequest)
		return
	}

	body, err := req.DecodedAndValidatedBody[usersdto.UpdateUserDto](r.Body)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusBadRequest)
		return
	}

	role := body.ConvertRoleToPB()

	user, err := h.userClient.UpdateUserById(ctx, int64(id), body.Email, body.FirstName, body.LastName, role)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}

	res.ResJson(w, user, http.StatusOK)
}

func (h *usersHandler) DeleteUserByID(w http.ResponseWriter, r *http.Request) {
	ctx, cancel := context.WithTimeout(r.Context(), 5*time.Second)
	defer cancel()

	param := r.PathValue("id")
	id, err := strconv.Atoi(param)
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusBadRequest)
		return
	}

	_, err = h.userClient.DeleteUserById(ctx, int64(id))
	if err != nil {
		res.ErrResJson(w, err.Error(), http.StatusInternalServerError)
		return
	}
}
