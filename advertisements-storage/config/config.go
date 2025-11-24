package config

import (
	"log"
	"os"
	"path/filepath"

	"github.com/joho/godotenv"
)

type config struct {
	Dsn string
}

func NewConfig() (*config, error) {
	userHomeDir, _ := os.UserHomeDir()
	path := filepath.Join(userHomeDir, "advertisements-api", "advertisements-storage", ".env")

	err := godotenv.Load(path)
	if err != nil {
		log.Fatalf("Error loading .env: %s", err.Error())
		return nil, err
	}

	return &config{
		Dsn: os.Getenv("DSN"),
	}, nil
}
