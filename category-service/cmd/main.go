package main

import (
	"log"

	"category-service/cmd/app"
)

func main() {
	err := app.Init()
	if err != nil {
		log.Fatalf("category-service not started: %s", err.Error())
	}
}
