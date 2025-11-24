package db

import (
	"database/sql"
	"log"

	_ "github.com/lib/pq"
)

type database struct {
	*sql.DB
}

func NewDatabase(dsn string) (*database, error) {
	db, err := sql.Open("postgres", dsn)
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
