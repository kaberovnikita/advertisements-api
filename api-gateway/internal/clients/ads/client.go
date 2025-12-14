package adsclient

import (
	"api-gateway/pkg/pb"
	"context"
	"time"

	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"
)

type AdsClient struct {
	conn   *grpc.ClientConn
	client pb.AdvertisementsStorageClient
}

func NewAdsClient(addr string) (*AdsClient, error) {
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

	return &AdsClient{
		conn:   conn,
		client: pb.NewAdvertisementsStorageClient(conn),
	}, nil
}

func (cl *AdsClient) Close() {
	if cl.conn != nil {
		cl.conn.Close()
	}
}

func (cl *AdsClient) CreateAdvertisement(
	ctx context.Context,
	title,
	description string,
	price float64,
	currency string,
	categoryID int64,
	userID int64) (int64, error) {
	resp, err := cl.client.CreateAdvertisement(ctx, &pb.CreateAdvertisementRequest{
		Title:       title,
		Description: description,
		Price:       price,
		Currency:    currency,
		CategoryId:  categoryID,
		UserId:      userID,
	})
	if err != nil {
		return 0, err
	}

	return resp.GetId(), nil
}

func (cl *AdsClient) GetAdvertisement(ctx context.Context, id int64) (*pb.Advertisement, error) {
	resp, err := cl.client.GetAdvertisementById(ctx, &pb.GetAdvertisementByIdRequest{
		Id: id,
	})
	if err != nil {
		return nil, err
	}

	return resp.GetAdvertisement(), nil
}

func (cl *AdsClient) GetAllAdvertisement(ctx context.Context) ([]*pb.Advertisement, error) {
	resp, err := cl.client.GetAllAdvertisements(ctx, &pb.GetAllAdvertisementsRequest{})
	if err != nil {
		return nil, err
	}

	return resp.GetAdvertisements(), nil
}

func (cl *AdsClient) UpdateAdvertisement(
	ctx context.Context,
	id int64,
	title,
	description string,
	price float64,
	currency string,
	categoryID int64) (*pb.Advertisement, error) {
	resp, err := cl.client.UpdateAdvertisementById(ctx, &pb.UpdateAdvertisementByIdRequest{
		Id:          id,
		Title:       title,
		Description: description,
		Price:       price,
		Currency:    currency,
		CategoryId:  categoryID,
	})
	if err != nil {
		return nil, err
	}

	return resp.GetAdvertisement(), nil
}

func (cl *AdsClient) DeleteAdvertisement(ctx context.Context, id int64) (*pb.DeleteAdvertisementByIDResponse, error) {
	resp, err := cl.client.DeleteAdvertisementByID(ctx, &pb.DeleteAdvertisementByIDRequest{
		Id: id,
	})
	if err != nil {
		return nil, err
	}

	return resp, nil
}
