package advertisementsrepository

import (
	"context"
	"database/sql"
	"errors"
	"fmt"
	"strings"
	"time"

	sq "github.com/Masterminds/squirrel"
	"google.golang.org/protobuf/types/known/timestamppb"

	types "advertisement-storage/pkg"
	pb "advertisement-storage/pkg/pb"
)

type advertisementsRepository struct {
	db types.Database
}

func NewAdvertisementsRepository(db types.Database) *advertisementsRepository {
	return &advertisementsRepository{
		db: db,
	}
}

func (r *advertisementsRepository) Create(ctx context.Context, req *pb.CreateAdvertisementRequest) (*pb.CreateAdvertisementResponse, error) {
	query, args, err := sq.
		Insert("advertisements").
		Columns("title", "description", "price", "currency", "published_at", "category_id", "user_id").
		Values(req.Title, req.Description, req.Price, strings.ToUpper(req.Currency), req.CategoryId, req.UserId).
		Suffix("RETURNING id").
		PlaceholderFormat(sq.Dollar).
		ToSql()
	if err != nil {
		return nil, fmt.Errorf("failed to build query: %s", err.Error())
	}

	var id int64

	err = r.db.QueryRowContext(ctx, query, args...).Scan(&id)
	if err != nil {
		return nil, fmt.Errorf("failed to create advertisement: %s", err.Error())
	}

	return &pb.CreateAdvertisementResponse{
		Id: id,
	}, nil
}

func (r *advertisementsRepository) GetByID(ctx context.Context, req *pb.GetAdvertisementByIdRequest) (*pb.GetAdvertisementByIdResponse, error) {
	query, args, err := sq.
		Select(
			"id",
			"title",
			"description",
			"price",
			"currency",
			"category_id",
			"user_id",
			"created_at",
			"updated_at",
		).
		From("advertisements").
		Where(sq.Eq{"id": req.Id}).
		PlaceholderFormat(sq.Dollar).
		ToSql()
	if err != nil {
		return nil, fmt.Errorf("failed to build query: %s", err.Error())
	}

	var (
		id          int64
		title       string
		description string
		price       float64
		currency    string
		categoryID  int64
		userID      int64
		createdAt   time.Time
		updatedAt   time.Time
	)

	err = r.db.QueryRowContext(ctx, query, args...).Scan(
		&id,
		&title,
		&description,
		&price,
		&currency,
		&categoryID,
		&userID,
		&createdAt,
		&updatedAt,
	)
	if err != nil {
		if err == sql.ErrNoRows {
			return nil, errors.New("advertisement not found")
		}
		return nil, fmt.Errorf("failed to get advertisement: %w", err)
	}

	return &pb.GetAdvertisementByIdResponse{
		Advertisement: &pb.Advertisement{
			Id:          id,
			Title:       title,
			Description: description,
			Price:       price,
			Currency:    currency,
			CategoryId:  categoryID,
			UserId:      userID,
			CreatedAt:   timestamppb.New(createdAt),
			UpdatedAt:   timestamppb.New(updatedAt),
		},
	}, nil
}

func (r *advertisementsRepository) GetAll(ctx context.Context, req *pb.GetAllAdvertisementsRequest) (*pb.GetAllAdvertisementsResponse, error) {
	query, args, err := sq.
		Select(
			"id",
			"title",
			"description",
			"price",
			"currency",
			"category_id",
			"user_id",
			"created_at",
			"updated_at",
		).
		From("advertisements").
		OrderBy("created_at DESC").
		PlaceholderFormat(sq.Dollar).
		ToSql()
	if err != nil {
		return nil, fmt.Errorf("failed to build query: %w", err)
	}

	rows, err := r.db.QueryContext(ctx, query, args...)
	if err != nil {
		return nil, fmt.Errorf("failed to get advertisements: %w", err)
	}
	defer rows.Close()

	var advertisements []*pb.Advertisement
	for rows.Next() {
		var (
			id          int64
			title       string
			description string
			price       float64
			currency    string
			categoryID  int64
			userID      int64
			createdAt   time.Time
			updatedAt   time.Time
		)

		err := rows.Scan(
			&id,
			&title,
			&description,
			&price,
			&currency,
			&categoryID,
			&userID,
			&createdAt,
			&updatedAt,
		)
		if err != nil {
			return nil, fmt.Errorf("failed to scan advertisement: %w", err)
		}

		advertisements = append(advertisements, &pb.Advertisement{
			Id:          id,
			Title:       title,
			Description: description,
			Price:       price,
			Currency:    currency,
			CategoryId:  categoryID,
			UserId:      userID,
			CreatedAt:   timestamppb.New(createdAt),
			UpdatedAt:   timestamppb.New(updatedAt),
		})
	}

	err = rows.Err()
	if err != nil {
		return nil, fmt.Errorf("rows error: %w", err)
	}

	return &pb.GetAllAdvertisementsResponse{
		Advertisements: advertisements,
	}, nil
}

func (r *advertisementsRepository) Update(ctx context.Context, req *pb.UpdateAdvertisementByIdRequest) (*pb.UpdateAdvertisementByIdResponse, error) {
	updateBuilder := sq.
		Update("advertisements").
		Set("updated_at", time.Now()).
		Where(sq.Eq{"id": req.Id})

	if len(req.Title) != 0 {
		updateBuilder = updateBuilder.Set("title", req.Title)
	}

	if len(req.Description) != 0 {
		updateBuilder = updateBuilder.Set("description", req.Description)
	}

	if req.Price != 0 {
		updateBuilder = updateBuilder.Set("price", req.Price)
	}

	if len(req.Currency) != 0 {
		updateBuilder = updateBuilder.Set("currency", strings.ToUpper(req.Currency))
	}

	if req.CategoryId != 0 {
		updateBuilder = updateBuilder.Set("category_id", req.CategoryId)
	}

	query, args, err := updateBuilder.
		Suffix("RETURNING id, title, description, price, currency, category_id, user_id, created_at, updated_at").
		PlaceholderFormat(sq.Dollar).
		ToSql()
	if err != nil {
		return nil, fmt.Errorf("failed to build query: %w", err)
	}

	var (
		id          int64
		title       string
		description string
		price       float64
		currency    string
		categoryID  int64
		userID      int64
		createdAt   time.Time
		updatedAt   time.Time
	)

	err = r.db.QueryRowContext(ctx, query, args...).Scan(
		&id,
		&title,
		&description,
		&price,
		&currency,
		&categoryID,
		&userID,
		&createdAt,
		&updatedAt,
	)
	if err != nil {
		return nil, fmt.Errorf("failed to update advertisement: %w", err)
	}

	return &pb.UpdateAdvertisementByIdResponse{
		Advertisement: &pb.Advertisement{
			Id:          id,
			Title:       title,
			Description: description,
			Price:       price,
			Currency:    currency,
			CategoryId:  categoryID,
			UserId:      userID,
			CreatedAt:   timestamppb.New(createdAt),
			UpdatedAt:   timestamppb.New(updatedAt),
		},
	}, nil
}

func (r *advertisementsRepository) Delete(ctx context.Context, req *pb.DeleteAdvertisementByIDRequest) (*pb.DeleteAdvertisementByIDResponse, error) {
	query, args, err := sq.
		Delete("advertisements").
		Where(sq.Eq{"id": req.Id}).
		PlaceholderFormat(sq.Dollar).
		ToSql()
	if err != nil {
		return nil, fmt.Errorf("failed build query: %s", err.Error())
	}

	result, err := r.db.ExecContext(ctx, query, args...)
	if err != nil {
		return nil, fmt.Errorf("failed to delete advertisement: %w", err)
	}

	rowsAffected, err := result.RowsAffected()
	if err != nil {
		return nil, fmt.Errorf("failed to get rows affected: %w", err)
	}

	if rowsAffected == 0 {
		return nil, errors.New("advertisement not found")
	}

	return &pb.DeleteAdvertisementByIDResponse{}, nil
}
