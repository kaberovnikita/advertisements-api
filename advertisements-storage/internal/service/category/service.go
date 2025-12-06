package categoryservice

import (
	"context"
	"strings"

	types "advertisement-storage/pkg"
	pb "advertisement-storage/pkg/pb"
)

type categoryService struct {
	repo types.CategoryRepository
}

func NewCategoryService(repo types.CategoryRepository) *categoryService {
	return &categoryService{
		repo: repo,
	}
}

func (s *categoryService) CreateCategory(ctx context.Context, req *pb.CreateCategoryRequest) (*pb.CreateCategoryResponse, error) {
	req.Name = strings.TrimSpace(req.Name)
	req.Alias = strings.TrimSpace(req.Alias)

	existing, err := s.repo.GetByAlias(ctx, &pb.GetCategoryByAliasRequest{Alias: req.Alias})
	if err == nil && existing != nil {
		return nil, err
	}

	return s.repo.Create(ctx, req)
}

func (s *categoryService) GetCategoryById(ctx context.Context, req *pb.GetCategoryByIdRequest) (*pb.GetCategoryByIdResponse, error) {
	return s.repo.GetByID(ctx, req)
}

func (s *categoryService) GetCategoryByAlias(ctx context.Context, req *pb.GetCategoryByAliasRequest) (*pb.GetCategoryByAliasResponse, error) {
	req.Alias = strings.ToLower(strings.TrimSpace(req.Alias))

	return s.repo.GetByAlias(ctx, req)
}

func (s *categoryService) GetAllCategory(ctx context.Context, req *pb.GetAllCategoriesRequest) (*pb.GetAllCategoriesResponse, error) {
	return s.repo.GetAll(ctx, req)
}

func (s *categoryService) UpdateCategoryById(ctx context.Context, req *pb.UpdateCategoryByIdRequest) (*pb.UpdateCategoryByIdResponse, error) {
	req.Alias = strings.ToLower(strings.TrimSpace(req.Alias))

	existing, err := s.repo.GetByAlias(ctx, &pb.GetCategoryByAliasRequest{Alias: req.Alias})
	if err == nil && existing != nil && existing.Category.Id != req.Id {
		return nil, err
	}

	req.Name = strings.TrimSpace(req.Name)

	return s.repo.Update(ctx, req)
}

func (s *categoryService) DeleteCategoryById(ctx context.Context, req *pb.DeleteCategoryByIDRequest) (*pb.DeleteCategoryByIDResponse, error) {
	return s.repo.Delete(ctx, req)
}
