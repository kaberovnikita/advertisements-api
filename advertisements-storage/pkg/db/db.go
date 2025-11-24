package db

import (
	"database/sql"
	"log"
	"os"

	_ "github.com/lib/pq"
)

type database struct {
	*sql.DB
}

func NewDatabase() (*database, error) {
	url := os.Getenv("DB_URL")

	db, err := sql.Open("postgres", url)
	if err != nil {
		log.Fatalf("Error connect to database: %s", err.Error())
		return nil, err
	}

	err = db.Ping()
	if err != nil {
		log.Fatalf("Error ping db: %s", err.Error())
		return nil, err
	}

	return &database{db}, nil
}
