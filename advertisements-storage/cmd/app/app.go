package app

import (
	"advertisement-storage/config"
	"advertisement-storage/pkg/db"
	"log"
)

func Init() error {
	cfg, err := config.NewConfig()
	if err != nil {
		return err
	}

	log.Println("config successful download")

	db, err := db.NewDatabase(cfg.Dsn)
	if err != nil {
		return err
	}
	defer db.Close()

	log.Println("database successful started")

	return nil
}
