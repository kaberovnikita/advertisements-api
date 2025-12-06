package req

import (
	"encoding/json"
	"errors"
	"io"

	"github.com/go-playground/validator/v10"
)

func DecodedAndValidatedBody[T any](body io.ReadCloser) (T, error) {
	var payload T

	err := json.NewDecoder(body).Decode(&payload)
	if err != nil {
		return payload, errors.New("invalid JSON body: " + err.Error())
	}

	validate := validator.New()

	err = validate.Struct(payload)
	if err != nil {
		return payload, errors.New("validation failed: " + err.Error())
	}

	return payload, nil
}
