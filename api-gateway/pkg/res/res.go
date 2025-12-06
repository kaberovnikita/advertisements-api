package res

import (
	"encoding/json"
	"net/http"
)

type Message struct {
	Message any `json:"message"`
}

func ResJson(w http.ResponseWriter, data any, statusCode int) {
	w.Header().Set("Content-Type", "application/json")
	w.WriteHeader(statusCode)
	json.NewEncoder(w).Encode(data)
}

func ErrResJson(w http.ResponseWriter, data any, statusCode int) {
	w.Header().Set("Content-Type", "application/json")
	w.WriteHeader(statusCode)
	json.NewEncoder(w).Encode(&Message{
		Message: data,
	})
}
