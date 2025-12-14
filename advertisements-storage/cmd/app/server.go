package app

import (
	"context"
	"time"

	types "advertisement-storage/pkg"
	pb "advertisement-storage/pkg/pb"
)

type AdvertisementsStorageServer struct {
	pb.UnimplementedAdvertisementsStorageServer
	advertisementsService types.AdvertisementsService
	categoryService       types.CategoryService
	searchService         types.SearchService
	usersService          types.UsersService
}

func NewAdvertisementsStorageServer(
	advertisementsService types.AdvertisementsService,
	categoryService types.CategoryService,
	searchService types.SearchService,
	usersService types.UsersService) *AdvertisementsStorageServer {
	return &AdvertisementsStorageServer{
		advertisementsService: advertisementsService,
		categoryService:       categoryService,
		searchService:         searchService,
		usersService:          usersService,
	}
}

func (serv *AdvertisementsStorageServer) CreateAdvertisement(ctx context.Context, req *pb.CreateAdvertisementRequest) (*pb.CreateAdvertisementResponse, error) {
	cancelCtx, cancel := context.WithTimeout(ctx, 5*time.Second)
	defer cancel()

	return serv.advertisementsService.CreateAdvertisement(cancelCtx, req)
}

func (serv *AdvertisementsStorageServer) GetAdvertisementById(ctx context.Context, req *pb.GetAdvertisementByIdRequest) (*pb.GetAdvertisementByIdResponse, error) {
	cancelCtx, cancel := context.WithTimeout(ctx, 5*time.Second)
	defer cancel()

	return serv.advertisementsService.GetAdvertisementById(cancelCtx, req)
}

func (serv *AdvertisementsStorageServer) GetAllAdvertisements(ctx context.Context, req *pb.GetAllAdvertisementsRequest) (*pb.GetAllAdvertisementsResponse, error) {
	cancelCtx, cancel := context.WithTimeout(ctx, 5*time.Second)
	defer cancel()

	return serv.advertisementsService.GetAllAdvertisements(cancelCtx, req)
}

func (serv *AdvertisementsStorageServer) UpdateAdvertisementById(ctx context.Context, req *pb.UpdateAdvertisementByIdRequest) (*pb.UpdateAdvertisementByIdResponse, error) {
	cancelCtx, cancel := context.WithTimeout(ctx, 5*time.Second)
	defer cancel()

	return serv.advertisementsService.UpdateAdvertisementById(cancelCtx, req)
}

func (serv *AdvertisementsStorageServer) DeleteAdvertisementByID(ctx context.Context, req *pb.DeleteAdvertisementByIDRequest) (*pb.DeleteAdvertisementByIDResponse, error) {
	cancelCtx, cancel := context.WithTimeout(ctx, 5*time.Second)
	defer cancel()

	return serv.advertisementsService.DeleteAdvertisementByID(cancelCtx, req)
}

func (serv *AdvertisementsStorageServer) CreateCategory(ctx context.Context, req *pb.CreateCategoryRequest) (*pb.CreateCategoryResponse, error) {
	cancelCtx, cancel := context.WithTimeout(ctx, 5*time.Second)
	defer cancel()

	return serv.categoryService.CreateCategory(cancelCtx, req)
}

func (serv *AdvertisementsStorageServer) GetCategoryById(ctx context.Context, req *pb.GetCategoryByIdRequest) (*pb.GetCategoryByIdResponse, error) {
	cancelCtx, cancel := context.WithTimeout(ctx, 5*time.Second)
	defer cancel()

	return serv.categoryService.GetCategoryById(cancelCtx, req)
}

func (serv *AdvertisementsStorageServer) GetCategoryByAlias(ctx context.Context, req *pb.GetCategoryByAliasRequest) (*pb.GetCategoryByAliasResponse, error) {
	cancelCtx, cancel := context.WithTimeout(ctx, 5*time.Second)
	defer cancel()

	return serv.categoryService.GetCategoryByAlias(cancelCtx, req)
}

func (serv *AdvertisementsStorageServer) GetAllCategories(ctx context.Context, req *pb.GetAllCategoriesRequest) (*pb.GetAllCategoriesResponse, error) {
	cancelCtx, cancel := context.WithTimeout(ctx, 5*time.Second)
	defer cancel()

	return serv.categoryService.GetAllCategory(cancelCtx, req)
}

func (serv *AdvertisementsStorageServer) UpdateCategoryById(ctx context.Context, req *pb.UpdateCategoryByIdRequest) (*pb.UpdateCategoryByIdResponse, error) {
	cancelCtx, cancel := context.WithTimeout(ctx, 5*time.Second)
	defer cancel()

	return serv.categoryService.UpdateCategoryById(cancelCtx, req)
}

func (serv *AdvertisementsStorageServer) DeleteCategoryById(ctx context.Context, req *pb.DeleteCategoryByIDRequest) (*pb.DeleteCategoryByIDResponse, error) {
	cancelCtx, cancel := context.WithTimeout(ctx, 5*time.Second)
	defer cancel()

	return serv.categoryService.DeleteCategoryById(cancelCtx, req)
}

func (serv *AdvertisementsStorageServer) RegisterUser(ctx context.Context, req *pb.RegisterUserRequest) (*pb.RegisterUserResponse, error) {
	cancelCtx, cancel := context.WithTimeout(ctx, 5*time.Second)
	defer cancel()

	return serv.usersService.RegisterUser(cancelCtx, req)
}

func (serv *AdvertisementsStorageServer) LoginUser(ctx context.Context, req *pb.LoginUserRequest) (*pb.LoginUserResponse, error) {
	cancelCtx, cancel := context.WithTimeout(ctx, 5*time.Second)
	defer cancel()

	return serv.usersService.LoginUser(cancelCtx, req)
}

func (serv *AdvertisementsStorageServer) GetAllUsers(ctx context.Context, req *pb.GetAllUsersRequest) (*pb.GetAllUsersResponse, error) {
	cancelCtx, cancel := context.WithTimeout(ctx, 5*time.Second)
	defer cancel()

	return serv.usersService.GetAllUsers(cancelCtx, req)
}

func (serv *AdvertisementsStorageServer) GetUserByID(ctx context.Context, req *pb.GetUserByIDRequest) (*pb.GetUserByIdResponse, error) {
	cancelCtx, cancel := context.WithTimeout(ctx, 5*time.Second)
	defer cancel()

	return serv.usersService.GetUserByID(cancelCtx, req)
}

func (serv *AdvertisementsStorageServer) UpdateUserById(ctx context.Context, req *pb.UpdateUserByIdRequest) (*pb.UpdateUserByIdResponse, error) {
	cancelCtx, cancel := context.WithTimeout(ctx, 5*time.Second)
	defer cancel()

	return serv.usersService.UpdateUserById(cancelCtx, req)
}

func (serv *AdvertisementsStorageServer) DeleteUserById(ctx context.Context, req *pb.DeleteUserByIdRequest) (*pb.DeleteUserByIdResponse, error) {
	cancelCtx, cancel := context.WithTimeout(ctx, 5*time.Second)
	defer cancel()

	return serv.usersService.DeleteUserById(cancelCtx, req)
}

func (serv *AdvertisementsStorageServer) SearchAdvertisementByTitle(ctx context.Context, req *pb.SearchAdvertisementByTitleRequest) (*pb.SearchAdvertisementByTitleResponse, error) {
	cancelCtx, cancel := context.WithTimeout(ctx, 5*time.Second)
	defer cancel()

	return serv.searchService.SearchAdvertisementByTitle(cancelCtx, req)
}
