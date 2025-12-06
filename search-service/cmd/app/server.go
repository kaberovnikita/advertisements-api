package app

import (
	"context"

	storageclient "search-service/internal"
	"search-service/pkg/pb"
)

type searchServer struct {
	pb.UnimplementedAdvertisementsStorageServer
	storageClient *storageclient.StorageClient
}

func NewSearchServer(storage *storageclient.StorageClient) *searchServer {
	return &searchServer{
		storageClient: storage,
	}
}

func (serv *searchServer) SearchAdvertisementByTitle(ctx context.Context, req *pb.SearchAdvertisementByTitleRequest) (*pb.SearchAdvertisementByTitleResponse, error) {
	advertisements, err := serv.storageClient.SearchByTitle(ctx, req.Title)
	if err != nil {
		return nil, err
	}

	return &pb.SearchAdvertisementByTitleResponse{
		Advertisement: advertisements,
	}, nil
}
