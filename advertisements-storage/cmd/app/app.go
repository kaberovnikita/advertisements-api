package app

import (
	"log"
	"net"
	"os"
	"os/signal"
	"syscall"

	"google.golang.org/grpc"

	advertisementsrepository "advertisement-storage/internal/repository/advertisements"
	categoryrepository "advertisement-storage/internal/repository/category"
	searchrepository "advertisement-storage/internal/repository/search"
	usersrepository "advertisement-storage/internal/repository/users"
	advertisementsservice "advertisement-storage/internal/service/advertisements"
	categoryservice "advertisement-storage/internal/service/category"
	searchservice "advertisement-storage/internal/service/search"
	usersservice "advertisement-storage/internal/service/users"
	"advertisement-storage/pkg/db"
	pb "advertisement-storage/pkg/pb"
)

func Init() error {
	db, err := db.NewDatabase()
	if err != nil {
		return err
	}
	defer db.Close()

	log.Println("database successful started")

	advertisementsRepository := advertisementsrepository.NewAdvertisementsRepository(db)
	categoryRepository := categoryrepository.NewCategoryRepository(db)
	searchRepository := searchrepository.NewSearchRepository(db)
	usersRepository := usersrepository.NewUsersRepository(db)

	advertisementsService := advertisementsservice.NewAdvertisementsService(
		advertisementsRepository,
		categoryRepository,
		usersRepository,
	)
	categoryService := categoryservice.NewCategoryService(categoryRepository)
	searchService := searchservice.NewSearchService(searchRepository)
	usersService := usersservice.NewUsersService(usersRepository)

	grpcServer := grpc.NewServer()
	advertisementsStorageServer := NewAdvertisementsStorageServer(
		advertisementsService,
		categoryService,
		searchService,
		usersService,
	)

	pb.RegisterAdvertisementsStorageServer(grpcServer, advertisementsStorageServer)

	lis, err := net.Listen("tcp", ":8000")
	if err != nil {
		return err
	}

	log.Printf("advertisements-storage started on %d port", 8000)

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
