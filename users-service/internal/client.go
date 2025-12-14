package storageclient

import (
	"context"
	"time"

	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"

	"users-service/pkg/pb"
)

type StorageClient struct {
	conn   *grpc.ClientConn
	client pb.AdvertisementsStorageClient
}

func NewStorageClient(addr string) (*StorageClient, error) {
	ctx, cancel := context.WithTimeout(context.Background(), 1*time.Minute)
	defer cancel()

	conn, err := grpc.DialContext(
		ctx,
		addr,
		grpc.WithTransportCredentials(insecure.NewCredentials()),
		grpc.WithBlock(),
	)
	if err != nil {
		return nil, err
	}

	client := pb.NewAdvertisementsStorageClient(conn)

	return &StorageClient{
		conn:   conn,
		client: client,
	}, nil
}

func (cl *StorageClient) Close() {
	if cl.conn != nil {
		cl.conn.Close()
	}
}

func (cl *StorageClient) RegisterUser(ctx context.Context, email, password, firstName, lastName string, role *pb.UserRole) (int64, error) {
	resp, err := cl.client.RegisterUser(ctx, &pb.RegisterUserRequest{
		Email:     email,
		Password:  password,
		FirstName: firstName,
		LastName:  lastName,
		Role:      role,
	})
	if err != nil {
		return 0, err
	}

	return resp.GetId(), nil
}

func (cl *StorageClient) LoginUser(ctx context.Context, email, password string) (string, error) {
	resp, err := cl.client.LoginUser(ctx, &pb.LoginUserRequest{
		Email:    email,
		Password: password,
	})
	if err != nil {
		return "", err
	}

	return resp.GetAccessToken(), nil
}

func (cl *StorageClient) GetUserById(ctx context.Context, id int64) (*pb.User, error) {
	resp, err := cl.client.GetUserByID(ctx, &pb.GetUserByIDRequest{
		Id: id,
	})
	if err != nil {
		return nil, err
	}

	return resp.GetUser(), nil
}

func (cl *StorageClient) GetAllUsers(ctx context.Context) ([]*pb.User, error) {
	resp, err := cl.client.GetAllUsers(ctx, &pb.GetAllUsersRequest{})
	if err != nil {
		return nil, err
	}

	return resp.GetUsers(), nil
}

func (cl *StorageClient) UpdateUserById(ctx context.Context, id int64, email, password, firstName, lastName string, role *pb.UserRole) (*pb.User, error) {
	resp, err := cl.client.UpdateUserById(ctx, &pb.UpdateUserByIdRequest{
		Id:           id,
		Email:        email,
		PasswordHash: password,
		FirstName:    firstName,
		LastName:     lastName,
		Role:         role,
	})
	if err != nil {
		return nil, err
	}

	return resp.GetUser(), nil
}

func (cl *StorageClient) DeleteUserById(ctx context.Context, id int64) (*pb.DeleteUserByIdResponse, error) {
	resp, err := cl.client.DeleteUserById(ctx, &pb.DeleteUserByIdRequest{
		Id: id,
	})
	if err != nil {
		return nil, err
	}

	return resp, nil
}
