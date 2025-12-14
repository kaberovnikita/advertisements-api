package main

import (
	"context"
	"log"
	"net/http"
	"os"
	"os/signal"
	"syscall"

	adsclient "api-gateway/internal/clients/ads"
	categoryclient "api-gateway/internal/clients/category"
	searchclient "api-gateway/internal/clients/search"
	usersclient "api-gateway/internal/clients/users"
	adshandler "api-gateway/internal/handlers/ads"
	categoryhandler "api-gateway/internal/handlers/category"
	searchhandler "api-gateway/internal/handlers/search"
	usershandler "api-gateway/internal/handlers/users"
)

func main() {
	categoryAddr := os.Getenv("CATEGORY_SERVICE_ADDR")
	userAddr := os.Getenv("USER_SERVICE_ADDR")
	searchAddr := os.Getenv("SEARCH_SERVICE_ADDR")
	adsAddr := os.Getenv("ADS_SERVICE_ADDR")

	categoryClient, err := categoryclient.NewCategoryClient(categoryAddr)
	if err != nil {
		log.Fatalf("Failed to connect to category service: %s", err.Error())
	}
	defer categoryClient.Close()

	usersClient, err := usersclient.NewUserClient(userAddr)
	if err != nil {
		log.Fatalf("Failed to connect to users service: %s", err.Error())
	}
	defer usersClient.Close()

	searchClient, err := searchclient.NewSearchClient(searchAddr)
	if err != nil {
		log.Fatalf("Failed to connect to search service: %s", err.Error())
	}
	defer searchClient.Close()

	adsClient, err := adsclient.NewAdsClient(adsAddr)
	if err != nil {
		log.Fatalf("Failed to connect to ads service: %s", err.Error())
	}
	defer adsClient.Close()

	router := http.NewServeMux()

	categoryhandler.NewCategoryHandler(router, categoryClient)
	usershandler.NewUsersHandler(router, usersClient)
	searchhandler.NewSearchHandler(router, searchClient)
	adshandler.NewAdsHandler(router, adsClient)

	server := http.Server{
		Addr:    ":8004",
		Handler: router,
	}

	log.Printf("api-gateway started on %d port", 8004)

	go func() {
		err := server.ListenAndServe()
		if err != nil {
			log.Fatalf("Failed to serve: %v", err)
		}
	}()

	stop := make(chan os.Signal, 1)
	signal.Notify(stop, syscall.SIGINT, syscall.SIGTERM)
	<-stop

	log.Println("Shutting down server...")

	err = server.Shutdown(context.Background())
	if err != nil {
		log.Fatalf("Error during shutdown: %s", err.Error())
	}

	log.Println("Server stopped")
}
