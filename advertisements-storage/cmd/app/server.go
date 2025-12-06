package app

import (
	"context"

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
	return serv.advertisementsService.CreateAdvertisement(ctx, req)
}

func (serv *AdvertisementsStorageServer) GetAdvertisementById(ctx context.Context, req *pb.GetAdvertisementByIdRequest) (*pb.GetAdvertisementByIdResponse, error) {
	return serv.advertisementsService.GetAdvertisementById(ctx, req)
}

func (serv *AdvertisementsStorageServer) GetAllAdvertisements(ctx context.Context, req *pb.GetAllAdvertisementsRequest) (*pb.GetAllAdvertisementsResponse, error) {
	return serv.advertisementsService.GetAllAdvertisements(ctx, req)
}

func (serv *AdvertisementsStorageServer) UpdateAdvertisementById(ctx context.Context, req *pb.UpdateAdvertisementByIdRequest) (*pb.UpdateAdvertisementByIdResponse, error) {
	return serv.advertisementsService.UpdateAdvertisementById(ctx, req)
}

func (serv *AdvertisementsStorageServer) DeleteAdvertisementByID(ctx context.Context, req *pb.DeleteAdvertisementByIDRequest) (*pb.DeleteAdvertisementByIDResponse, error) {
	return serv.advertisementsService.DeleteAdvertisementByID(ctx, req)
}

func (serv *AdvertisementsStorageServer) CreateCategory(ctx context.Context, req *pb.CreateCategoryRequest) (*pb.CreateCategoryResponse, error) {
	return serv.categoryService.CreateCategory(ctx, req)
}

func (serv *AdvertisementsStorageServer) GetCategoryById(ctx context.Context, req *pb.GetCategoryByIdRequest) (*pb.GetCategoryByIdResponse, error) {
	return serv.categoryService.GetCategoryById(ctx, req)
}

func (serv *AdvertisementsStorageServer) GetCategoryByAlias(ctx context.Context, req *pb.GetCategoryByAliasRequest) (*pb.GetCategoryByAliasResponse, error) {
	return serv.categoryService.GetCategoryByAlias(ctx, req)
}

func (serv *AdvertisementsStorageServer) GetAllCategories(ctx context.Context, req *pb.GetAllCategoriesRequest) (*pb.GetAllCategoriesResponse, error) {
	return serv.categoryService.GetAllCategory(ctx, req)
}

func (serv *AdvertisementsStorageServer) UpdateCategoryById(ctx context.Context, req *pb.UpdateCategoryByIdRequest) (*pb.UpdateCategoryByIdResponse, error) {
	return serv.categoryService.UpdateCategoryById(ctx, req)
}

func (serv *AdvertisementsStorageServer) DeleteCategoryById(ctx context.Context, req *pb.DeleteCategoryByIDRequest) (*pb.DeleteCategoryByIDResponse, error) {
	return serv.categoryService.DeleteCategoryById(ctx, req)
}

func (serv *AdvertisementsStorageServer) RegisterUser(ctx context.Context, req *pb.RegisterUserRequest) (*pb.RegisterUserResponse, error) {
	return serv.usersService.RegisterUser(ctx, req)
}

func (serv *AdvertisementsStorageServer) LoginUser(ctx context.Context, req *pb.LoginUserRequest) (*pb.LoginUserResponse, error) {
	return serv.usersService.LoginUser(ctx, req)
}

func (serv *AdvertisementsStorageServer) GetAllUsers(ctx context.Context, req *pb.GetAllUsersRequest) (*pb.GetAllUsersResponse, error) {
	return serv.usersService.GetAllUsers(ctx, req)
}

func (serv *AdvertisementsStorageServer) GetUserByID(ctx context.Context, req *pb.GetUserByIDRequest) (*pb.GetUserByIdResponse, error) {
	return serv.usersService.GetUserByID(ctx, req)
}

func (serv *AdvertisementsStorageServer) GetUserByEmail(ctx context.Context, req *pb.GetUserByEmailRequest) (*pb.GetUserByEmailResponse, error) {
	return serv.usersService.GetUserByEmail(ctx, req)
}

func (serv *AdvertisementsStorageServer) UpdateUserById(ctx context.Context, req *pb.UpdateUserByIdRequest) (*pb.UpdateUserByIdResponse, error) {
	return serv.usersService.UpdateUserById(ctx, req)
}

func (serv *AdvertisementsStorageServer) DeleteUserById(ctx context.Context, req *pb.DeleteUserByIdRequest) (*pb.DeleteUserByIdResponse, error) {
	return serv.usersService.DeleteUserById(ctx, req)
}

func (serv *AdvertisementsStorageServer) SearchAdvertisementByTitle(ctx context.Context, req *pb.SearchAdvertisementByTitleRequest) (*pb.SearchAdvertisementByTitleResponse, error) {
	return serv.searchService.SearchAdvertisementByTitle(ctx, req)
}
