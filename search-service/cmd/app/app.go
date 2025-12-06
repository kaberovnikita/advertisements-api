package app

import (
	"log"
	"net"
	"os"
	"os/signal"
	storageclient "search-service/internal"
	"search-service/pkg/pb"
	"syscall"

	"google.golang.org/grpc"
)

func Init() error {
	storageAddr := os.Getenv("STORAGE_ADDR")

	storageClient, err := storageclient.NewStorageClient(storageAddr)
	if err != nil {
		log.Fatalf("Failed to connect to storage: %s", err.Error())
		return err
	}

	defer storageClient.Close()

	grpcServer := grpc.NewServer()

	searchServer := NewSearchServer(storageClient)

	pb.RegisterAdvertisementsStorageServer(grpcServer, searchServer)

	lis, err := net.Listen("tcp", ":8002")
	if err != nil {
		log.Fatalf("Failed listen 8002 port: %s", err)
		return err
	}

	log.Printf("category-service started on %d port", 8002)

	go func() {
		err := grpcServer.Serve(lis)
		if err != nil {
			log.Fatalf("Failed to serve: %v", err)
		}
	}()

	stop := make(chan os.Signal, 1)
	signal.Notify(stop, syscall.SIGINT, syscall.SIGTERM)
	<-stop

	log.Println("Shutting down server...")

	grpcServer.GracefulStop()

	log.Println("Server stopped")

	return nil
}
