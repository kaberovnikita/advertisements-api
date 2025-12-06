package usersclient

import (
	"context"
	"time"

	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"

	"api-gateway/pkg/pb"
)

type UserClient struct {
	conn   *grpc.ClientConn
	client pb.AdvertisementsStorageClient
}

func NewUserClient(addr string) (*UserClient, error) {
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

	return &UserClient{
		conn:   conn,
		client: client,
	}, nil
}

func (cl *UserClient) Close() {
	if cl.conn != nil {
		cl.conn.Close()
	}
}

func (c *UserClient) RegisterUser(ctx context.Context, email, password, firstName, lastName string, role *pb.UserRole) (int64, error) {
	resp, err := c.client.RegisterUser(ctx, &pb.RegisterUserRequest{
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

func (c *UserClient) LoginUser(ctx context.Context, email, password string) (string, error) {
	resp, err := c.client.LoginUser(ctx, &pb.LoginUserRequest{
		Email:    email,
		Password: password,
	})
	if err != nil {
		return "", err
	}

	return resp.GetAccessToken(), nil
}

func (c *UserClient) GetAllUsers(ctx context.Context) ([]*pb.User, error) {
	resp, err := c.client.GetAllUsers(ctx, &pb.GetAllUsersRequest{})
	if err != nil {
		return nil, err
	}

	return resp.GetUsers(), nil
}

func (c *UserClient) GetUserByID(ctx context.Context, id int64) (*pb.User, error) {
	resp, err := c.client.GetUserByID(ctx, &pb.GetUserByIDRequest{
		Id: id,
	})
	if err != nil {
		return nil, err
	}

	return resp.GetUser(), nil
}

func (c *UserClient) GetUserByEmail(ctx context.Context, email string) (*pb.User, error) {
	resp, err := c.client.GetUserByEmail(ctx, &pb.GetUserByEmailRequest{
		Email: email,
	})
	if err != nil {
		return nil, err
	}

	return resp.GetUser(), nil
}

func (c *UserClient) UpdateUserById(ctx context.Context, id int64, email, firstName, lastName string, role *pb.UserRole) (*pb.User, error) {
	resp, err := c.client.UpdateUserById(ctx, &pb.UpdateUserByIdRequest{
		Id:        id,
		Email:     email,
		FirstName: firstName,
		LastName:  lastName,
		Role:      role,
	})
	if err != nil {
		return nil, err
	}

	return resp.User, nil
}

func (c *UserClient) DeleteUserById(ctx context.Context, id int64) (*pb.DeleteUserByIdResponse, error) {
	resp, err := c.client.DeleteUserById(ctx, &pb.DeleteUserByIdRequest{
		Id: id,
	})
	if err != nil {
		return nil, err
	}

	return resp, nil
}
