package searchrepository

import (
	"context"
	"fmt"
	"time"

	sq "github.com/Masterminds/squirrel"
	"google.golang.org/protobuf/types/known/timestamppb"

	types "advertisement-storage/pkg"
	pb "advertisement-storage/pkg/pb"
)

type searchRepository struct {
	db types.Database
}

func NewSearchRepository(db types.Database) *searchRepository {
	return &searchRepository{
		db: db,
	}
}

func (r *searchRepository) Search(ctx context.Context, req *pb.SearchAdvertisementByTitleRequest) (*pb.SearchAdvertisementByTitleResponse, error) {
	query, args, err := sq.
		Select(
			"a.id",
			"a.title",
			"a.description",
			"a.price",
			"a.currency",
			"a.category_id",
			"a.user_id",
			"a.created_at",
			"a.updated_at",
			"c.name as category_name",
			"c.alias as category_alias",
			"u.email as user_email",
			"u.first_name as user_first_name",
			"u.last_name as user_last_name",
		).
		From("advertisements a").
		Join("categories c ON a.category_id = c.id").
		Join("users u ON a.user_id = u.id").
		Where(sq.ILike{"a.title": "%" + req.Title + "%"}).
		OrderBy("a.created_at DESC").
		PlaceholderFormat(sq.Dollar).
		ToSql()
	if err != nil {
		return nil, fmt.Errorf("failed build query: %s", err.Error())
	}

	rows, err := r.db.QueryContext(ctx, query, args...)
	if err != nil {
		return nil, fmt.Errorf("failed to execute search query: %w", err)
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
			return nil, fmt.Errorf("failed to scan avdertisements: %s", err.Error())
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
		return nil, fmt.Errorf("rows error: %s", err.Error())
	}

	return &pb.SearchAdvertisementByTitleResponse{
		Advertisement: advertisements,
	}, nil
}
