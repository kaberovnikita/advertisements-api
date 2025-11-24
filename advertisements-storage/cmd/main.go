package main

import (
	"advertisement-storage/cmd/app"
	"log"
)

func main() {
	err := app.Init()
	if err != nil {
		log.Fatalf("advertisements-storage not started: %s", err.Error())
	}
}
