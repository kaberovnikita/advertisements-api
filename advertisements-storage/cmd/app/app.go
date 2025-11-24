package app

import (
	"advertisement-storage/pkg/db"
	"log"
	"net/http"
)

func Init() error {
	router := http.NewServeMux()

	db, err := db.NewDatabase()
	if err != nil {
		return err
	}
	defer db.Close()

	log.Println("database successful started")

	server := http.Server{
		Addr:    ":8000",
		Handler: router,
	}

	log.Printf("advertisements-storage started on %d port", 8000)

	err = server.ListenAndServe()
	if err != nil {
		return err
	}

	return nil
}
