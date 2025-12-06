package categoryclient

import (
	"context"
	"time"

	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"

	"api-gateway/pkg/pb"
)

type CategoryClient struct {
	conn   *grpc.ClientConn
	client pb.AdvertisementsStorageClient
}

func NewCategoryClient(addr string) (*CategoryClient, error) {
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

	return &CategoryClient{
		conn:   conn,
		client: pb.NewAdvertisementsStorageClient(conn),
	}, nil
}

func (cl *CategoryClient) Close() {
	if cl.conn != nil {
		cl.conn.Close()
	}
}

func (cl *CategoryClient) CreateCategory(ctx context.Context, name, alias string) (int64, error) {
	resp, err := cl.client.CreateCategory(ctx, &pb.CreateCategoryRequest{
		Name:  name,
		Alias: alias,
	})
	if err != nil {
		return 0, err
	}

	return resp.GetId(), nil
}

func (cl *CategoryClient) GetCategoryById(ctx context.Context, id int64) (*pb.Category, error) {
	resp, err := cl.client.GetCategoryById(ctx, &pb.GetCategoryByIdRequest{Id: id})
	if err != nil {
		return nil, err
	}

	return resp.GetCategory(), nil
}

func (cl *CategoryClient) GetCategoryByAlias(ctx context.Context, alias string) (*pb.Category, error) {
	resp, err := cl.client.GetCategoryByAlias(ctx, &pb.GetCategoryByAliasRequest{Alias: alias})
	if err != nil {
		return nil, err
	}

	return resp.GetCategory(), nil
}

func (cl *CategoryClient) GetAllCategories(ctx context.Context) ([]*pb.Category, error) {
	resp, err := cl.client.GetAllCategories(ctx, &pb.GetAllCategoriesRequest{})
	if err != nil {
		return nil, err
	}

	return resp.GetCategories(), nil
}

func (cl *CategoryClient) UpdateCategoryById(ctx context.Context, id int64, name, alias string) (*pb.Category, error) {
	resp, err := cl.client.UpdateCategoryById(ctx, &pb.UpdateCategoryByIdRequest{
		Id:    id,
		Name:  name,
		Alias: alias,
	})
	if err != nil {
		return nil, err
	}

	return resp.GetCategory(), nil
}

func (cl *CategoryClient) DeleteCategoryById(ctx context.Context, id int64) (*pb.DeleteCategoryByIDResponse, error) {
	resp, err := cl.client.DeleteCategoryById(ctx, &pb.DeleteCategoryByIDRequest{
		Id: id,
	})
	if err != nil {
		return nil, err
	}

	return resp, nil
}
