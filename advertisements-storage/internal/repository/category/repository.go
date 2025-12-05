package categoryrepository

import (
	"context"
	"database/sql"
	"errors"
	"fmt"
	"time"

	sq "github.com/Masterminds/squirrel"
	"google.golang.org/protobuf/types/known/timestamppb"

	types "advertisement-storage/pkg"
	pb "advertisement-storage/pkg/pb"
)

type categoryRepository struct {
	db types.Database
}

func NewCategoryRepository(db types.Database) *categoryRepository {
	return &categoryRepository{
		db: db,
	}
}

func (r *categoryRepository) Create(ctx context.Context, req *pb.CreateCategoryRequest) (*pb.CreateCategoryResponse, error) {
	query, args, err := sq.
		Insert("categories").
		Columns("name", "alias").
		Values(req.Name, req.Alias).
		Suffix("RETURNING id").
		PlaceholderFormat(sq.Dollar).
		ToSql()
	if err != nil {
		return nil, fmt.Errorf("failed build query: %s", err.Error())
	}

	var id int64

	err = r.db.QueryRowContext(ctx, query, args...).Scan(&id)
	if err != nil {
		return nil, fmt.Errorf("failed to create category: %s", err.Error())
	}

	return &pb.CreateCategoryResponse{
		Id: id,
	}, nil
}

func (r *categoryRepository) GetByID(ctx context.Context, req *pb.GetCategoryByIdRequest) (*pb.GetCategoryByIdResponse, error) {
	query, args, err := sq.
		Select("id", "name", "alias", "created_at", "updated_at").
		From("categories").
		Where(sq.Eq{"id": req.Id}).
		PlaceholderFormat(sq.Dollar).
		ToSql()
	if err != nil {
		return nil, fmt.Errorf("failed build query: %s", err.Error())
	}

	var (
		id        int64
		name      string
		alias     string
		createdAt time.Time
		updatedAt time.Time
	)

	err = r.db.QueryRowContext(ctx, query, args...).Scan(
		&id,
		&name,
		&alias,
		&createdAt,
		&updatedAt,
	)
	if err != nil {
		if err == sql.ErrNoRows {
			return nil, errors.New("category not found")
		}
		return nil, fmt.Errorf("failed to get category: %s", err.Error())
	}

	return &pb.GetCategoryByIdResponse{
		Category: &pb.Category{
			Id:        id,
			Name:      name,
			Alias:     alias,
			CreatedAt: timestamppb.New(createdAt),
			UpdatedAt: timestamppb.New(updatedAt),
		},
	}, nil
}

func (r *categoryRepository) GetByAlias(ctx context.Context, req *pb.GetCategoryByAliasRequest) (*pb.GetCategoryByAliasResponse, error) {
	query, args, err := sq.
		Select("id", "name", "alias", "created_at", "updated_at").
		From("categories").
		Where(sq.Eq{"alias": req.Alias}).
		PlaceholderFormat(sq.Dollar).
		ToSql()
	if err != nil {
		return nil, fmt.Errorf("failed build query: %s", err.Error())
	}

	var (
		id        int64
		name      string
		alias     string
		createdAt time.Time
		updatedAt time.Time
	)

	err = r.db.QueryRowContext(ctx, query, args...).Scan(
		&id,
		&name,
		&alias,
		&createdAt,
		&updatedAt,
	)
	if err != nil {
		if err == sql.ErrNoRows {
			return nil, errors.New("category not found")
		}
		return nil, fmt.Errorf("failed to get category by alias: %s", err.Error())
	}

	return &pb.GetCategoryByAliasResponse{
		Category: &pb.Category{
			Id:        id,
			Name:      name,
			Alias:     alias,
			CreatedAt: timestamppb.New(createdAt),
			UpdatedAt: timestamppb.New(updatedAt),
		},
	}, nil
}

func (r *categoryRepository) GetAll(ctx context.Context, req *pb.GetAllCategoriesRequest) (*pb.GetAllCategoriesResponse, error) {
	query, args, err := sq.
		Select("id", "name", "alias", "created_at", "updated_at").
		From("categories").
		OrderBy("name DESC").
		PlaceholderFormat(sq.Dollar).
		ToSql()
	if err != nil {
		return nil, fmt.Errorf("failed build query: %s", err.Error())
	}

	rows, err := r.db.QueryContext(ctx, query, args...)
	if err != nil {
		return nil, fmt.Errorf("failed to get categories: %s", err.Error())
	}
	defer rows.Close()

	var categories []*pb.Category
	for rows.Next() {
		var (
			id        int64
			name      string
			alias     string
			createdAt time.Time
			updatedAt time.Time
		)

		err := rows.Scan(
			&id,
			&name,
			&alias,
			&createdAt,
			&updatedAt,
		)
		if err != nil {
			return nil, fmt.Errorf("failed to scan category: %s", err.Error())
		}

		categories = append(categories, &pb.Category{
			Id:        id,
			Name:      name,
			Alias:     alias,
			CreatedAt: timestamppb.New(createdAt),
			UpdatedAt: timestamppb.New(updatedAt),
		})

	}

	err = rows.Err()
	if err != nil {
		return nil, fmt.Errorf("rows error: %s", err.Error())
	}

	return &pb.GetAllCategoriesResponse{
		Categories: categories,
	}, nil
}

func (r *categoryRepository) Update(ctx context.Context, req *pb.UpdateCategoryByIdRequest) (*pb.UpdateCategoryByIdResponse, error) {
	updateBuilder := sq.
		Update("categories").
		Where(sq.Eq{"id": req.Id}).
		Set("updated_at", time.Now())

	if len(req.Name) != 0 {
		updateBuilder = updateBuilder.Set("name", req.Name)
	}

	if len(req.Alias) != 0 {
		updateBuilder = updateBuilder.Set("alias", req.Alias)
	}

	query, args, err := updateBuilder.
		PlaceholderFormat(sq.Dollar).
		Suffix("RETURNING id, name, alias, created_at, updated_at").
		ToSql()
	if err != nil {
		return nil, fmt.Errorf("failed build query: %s", err.Error())
	}

	var (
		id        int64
		name      string
		alias     string
		createdAt time.Time
		updatedAt time.Time
	)

	err = r.db.QueryRowContext(ctx, query, args...).
		Scan(
			&id,
			&name,
			&alias,
			&createdAt,
			&updatedAt,
		)
	if err != nil {
		if err == sql.ErrNoRows {
			return nil, errors.New("category not found")
		}
		return nil, fmt.Errorf("failed to update category: %w", err)
	}

	return &pb.UpdateCategoryByIdResponse{
		Category: &pb.Category{
			Id:        id,
			Name:      name,
			Alias:     alias,
			CreatedAt: timestamppb.New(createdAt),
			UpdatedAt: timestamppb.New(updatedAt),
		},
	}, nil
}

func (r *categoryRepository) Delete(ctx context.Context, req *pb.DeleteCategoryByIDRequest) (*pb.DeleteCategoryByIDResponse, error) {
	query, args, err := sq.
		Delete("categories").
		Where(sq.Eq{"id": req.Id}).
		PlaceholderFormat(sq.Dollar).
		ToSql()
	if err != nil {
		return nil, fmt.Errorf("failed build query: %s", err.Error())
	}

	result, err := r.db.ExecContext(ctx, query, args...)
	if err != nil {
		return nil, fmt.Errorf("failed to delete category: %w", err)
	}

	rowsAffected, err := result.RowsAffected()
	if err != nil {
		return nil, fmt.Errorf("failed to get rows affected: %w", err)
	}

	if rowsAffected == 0 {
		return nil, errors.New("category not found")
	}

	return &pb.DeleteCategoryByIDResponse{}, nil
}
