package main

import (
	"log"

	"search-service/cmd/app"
)

func main() {
	err := app.Init()
	if err != nil {
		log.Fatalf("search-service not started: %s", err.Error())
	}
}
