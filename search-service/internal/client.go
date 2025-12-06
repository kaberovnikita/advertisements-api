package storageclient

import (
	"context"
	"time"

	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"

	"search-service/pkg/pb"
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

func (cl *StorageClient) SearchByTitle(ctx context.Context, title string) ([]*pb.Advertisement, error) {
	resp, err := cl.client.SearchAdvertisementByTitle(ctx, &pb.SearchAdvertisementByTitleRequest{
		Title: title,
	})
	if err != nil {
		return nil, err
	}

	return resp.GetAdvertisement(), nil
}
