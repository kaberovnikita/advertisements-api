package searchservice

import (
	"context"

	types "advertisement-storage/pkg"
	pb "advertisement-storage/pkg/pb"
)

type searchService struct {
	repo types.SearchRepository
}

func NewSearchService(repo types.SearchRepository) *searchService {
	return &searchService{
		repo: repo,
	}
}

func (s *searchService) SearchAdvertisementByTitle(ctx context.Context, req *pb.SearchAdvertisementByTitleRequest) (*pb.SearchAdvertisementByTitleResponse, error) {
	return s.repo.Search(ctx, &pb.SearchAdvertisementByTitleRequest{
		Title: req.Title,
	})
}
