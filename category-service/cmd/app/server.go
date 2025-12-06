package app

import (
	"context"

	storageclient "category-service/internal"
	"category-service/pkg/pb"
)

type categoryServer struct {
	pb.UnimplementedAdvertisementsStorageServer
	storageClient *storageclient.StorageClient
}

func NewCategoryServer(storageClient *storageclient.StorageClient) *categoryServer {
	return &categoryServer{
		storageClient: storageClient,
	}
}

func (serv *categoryServer) CreateCategory(ctx context.Context, req *pb.CreateCategoryRequest) (*pb.CreateCategoryResponse, error) {
	id, err := serv.storageClient.CreateCategory(ctx, req.Name, req.Alias)
	if err != nil {
		return nil, err
	}

	return &pb.CreateCategoryResponse{
		Id: id,
	}, nil
}

func (serv *categoryServer) GetCategoryById(ctx context.Context, req *pb.GetCategoryByIdRequest) (*pb.GetCategoryByIdResponse, error) {
	category, err := serv.storageClient.GetCategoryById(ctx, req.Id)
	if err != nil {
		return nil, err
	}

	return &pb.GetCategoryByIdResponse{
		Category: category,
	}, nil
}

func (serv *categoryServer) GetCategoryByAlias(ctx context.Context, req *pb.GetCategoryByAliasRequest) (*pb.GetCategoryByAliasResponse, error) {
	category, err := serv.storageClient.GetCategoryByAlias(ctx, req.Alias)
	if err != nil {
		return nil, err
	}

	return &pb.GetCategoryByAliasResponse{
		Category: category,
	}, nil
}

func (serv *categoryServer) GetAllCategories(ctx context.Context, req *pb.GetAllCategoriesRequest) (*pb.GetAllCategoriesResponse, error) {
	categories, err := serv.storageClient.GetAllCategories(ctx)
	if err != nil {
		return nil, err
	}

	return &pb.GetAllCategoriesResponse{
		Categories: categories,
	}, nil
}

func (serv *categoryServer) UpdateCategoryById(ctx context.Context, req *pb.UpdateCategoryByIdRequest) (*pb.UpdateCategoryByIdResponse, error) {
	category, err := serv.storageClient.UpdateCategory(ctx, req.Id, req.Name, req.Alias)
	if err != nil {
		return nil, err
	}

	return &pb.UpdateCategoryByIdResponse{
		Category: category,
	}, nil
}

func (serv *categoryServer) DeleteCategoryById(ctx context.Context, req *pb.DeleteCategoryByIDRequest) (*pb.DeleteCategoryByIDResponse, error) {
	resp, err := serv.storageClient.DeleteCategory(ctx, req.Id)
	if err != nil {
		return nil, err
	}

	return resp, nil
}
