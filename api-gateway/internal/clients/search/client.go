package searchclient

import (
	"context"
	"time"

	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"

	"api-gateway/pkg/pb"
)

type SearchClient struct {
	conn   *grpc.ClientConn
	client pb.AdvertisementsStorageClient
}

func NewSearchClient(addr string) (*SearchClient, error) {
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

	return &SearchClient{
		conn:   conn,
		client: client,
	}, nil
}

func (cl *SearchClient) Close() {
	if cl.conn != nil {
		cl.conn.Close()
	}
}

func (cl *SearchClient) SearchByTitle(ctx context.Context, title string) ([]*pb.Advertisement, error) {
	resp, err := cl.client.SearchAdvertisementByTitle(ctx, &pb.SearchAdvertisementByTitleRequest{
		Title: title,
	})
	if err != nil {
		return nil, err
	}

	return resp.GetAdvertisement(), nil
}
