package app

import (
	"log"
	"net"
	"os"
	"os/signal"
	"syscall"

	"google.golang.org/grpc"

	storageclient "users-service/internal"
	"users-service/pkg/pb"
)

func Init() error {
	storageAddr := os.Getenv("STORAGE_ADDR")
	if storageAddr == "" {
		storageAddr = "localhost:8000"
	}

	storageClient, err := storageclient.NewStorageClient(storageAddr)
	if err != nil {
		log.Fatalf("Failed to connect to storage: %s", err.Error())
		return err
	}

	defer storageClient.Close()

	grpcServer := grpc.NewServer()

	usersServer := NewUsersServer(storageClient)

	pb.RegisterAdvertisementsStorageServer(grpcServer, usersServer)

	lis, err := net.Listen("tcp", ":8003")
	if err != nil {
		log.Fatalf("Failed listen 8003 port: %s", err)
		return err
	}

	log.Printf("users-service started on %d port", 8003)

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
