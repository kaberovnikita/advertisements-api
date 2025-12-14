package app

import (
	"context"

	storageclient "users-service/internal"
	"users-service/pkg/pb"
)

type usersServer struct {
	pb.UnimplementedAdvertisementsStorageServer
	storageClient *storageclient.StorageClient
}

func NewUsersServer(storageClient *storageclient.StorageClient) *usersServer {
	return &usersServer{
		storageClient: storageClient,
	}
}

func (serv *usersServer) RegisterUser(ctx context.Context, req *pb.RegisterUserRequest) (*pb.RegisterUserResponse, error) {
	id, err := serv.storageClient.RegisterUser(ctx, req.Email, req.Password, req.FirstName, req.FirstName, req.Role)
	if err != nil {
		return nil, err
	}

	return &pb.RegisterUserResponse{
		Id: id,
	}, nil
}

func (serv *usersServer) LoginUser(ctx context.Context, req *pb.LoginUserRequest) (*pb.LoginUserResponse, error) {
	token, err := serv.storageClient.LoginUser(ctx, req.Email, req.Password)
	if err != nil {
		return nil, err
	}

	return &pb.LoginUserResponse{
		AccessToken: token,
	}, nil
}

func (serv *usersServer) GetAllUsers(ctx context.Context, req *pb.GetAllUsersRequest) (*pb.GetAllUsersResponse, error) {
	users, err := serv.storageClient.GetAllUsers(ctx)
	if err != nil {
		return nil, err
	}

	return &pb.GetAllUsersResponse{
		Users: users,
	}, nil
}

func (serv *usersServer) GetUserByID(ctx context.Context, req *pb.GetUserByIDRequest) (*pb.GetUserByIdResponse, error) {
	user, err := serv.storageClient.GetUserById(ctx, req.Id)
	if err != nil {
		return nil, err
	}

	return &pb.GetUserByIdResponse{
		User: user,
	}, nil
}

func (serv *usersServer) UpdateUserById(ctx context.Context, req *pb.UpdateUserByIdRequest) (*pb.UpdateUserByIdResponse, error) {
	user, err := serv.storageClient.UpdateUserById(ctx, req.Id, req.Email, req.PasswordHash, req.FirstName, req.LastName, req.Role)
	if err != nil {
		return nil, err
	}

	return &pb.UpdateUserByIdResponse{
		User: user,
	}, nil
}

func (serv *usersServer) DeleteUserById(ctx context.Context, req *pb.DeleteUserByIdRequest) (*pb.DeleteUserByIdResponse, error) {
	resp, err := serv.storageClient.DeleteUserById(ctx, req.Id)
	if err != nil {
		return nil, err
	}

	return resp, nil
}
