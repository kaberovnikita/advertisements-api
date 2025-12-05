package usersrepository

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

type usersRepository struct {
	db types.Database
}

func NewUsersRepository(db types.Database) *usersRepository {
	return &usersRepository{
		db: db,
	}
}

func (r *usersRepository) Create(ctx context.Context, req *pb.RegisterUserRequest) (*pb.RegisterUserResponse, error) {
	var role int32 = 0
	if req.Role != nil && *req.Role == pb.UserRole_USER_ROLE_ADMIN {
		role = 1
	}

	query, args, err := sq.
		Insert("users").
		Columns("email", "password_hash", "first_name", "last_name", "role").
		Values(req.Email, req.Password, req.FirstName, req.LastName, role).
		Suffix("RETURNING id").
		PlaceholderFormat(sq.Dollar).
		ToSql()
	if err != nil {
		return nil, fmt.Errorf("failed build query: %s", err.Error())
	}

	var id int64

	err = r.db.QueryRowContext(ctx, query, args...).Scan(&id)
	if err != nil {
		return nil, fmt.Errorf("failed to create user: %s", err.Error())
	}

	return &pb.RegisterUserResponse{
		Id: id,
	}, nil
}

func (r *usersRepository) GetByID(ctx context.Context, req *pb.GetUserByIDRequest) (*pb.GetUserByIdResponse, error) {
	query, args, err := sq.
		Select("id", "email", "password_hash", "first_name", "last_name", "role", "created_at", "updated_at").
		From("users").Where(sq.Eq{"id": req.Id}).
		PlaceholderFormat(sq.Dollar).
		ToSql()
	if err != nil {
		return nil, fmt.Errorf("failed build query: %s", err.Error())
	}

	var (
		id           int64
		email        string
		passwordHash string
		firstName    string
		lastName     string
		role         int32
		createdAt    time.Time
		updatedAt    time.Time
	)

	err = r.db.QueryRowContext(ctx, query, args...).Scan(
		&id,
		&email,
		&passwordHash,
		&firstName,
		&lastName,
		&role,
		&createdAt,
		&updatedAt,
	)
	if err != nil {
		if err == sql.ErrNoRows {
			return nil, errors.New("user not found")
		}
		return nil, fmt.Errorf("failed to get user: %s", err.Error())
	}

	userRole := pb.UserRole(role)

	return &pb.GetUserByIdResponse{
		User: &pb.User{
			Id:           id,
			Email:        email,
			PasswordHash: passwordHash,
			FirstName:    firstName,
			LastName:     lastName,
			Role:         &userRole,
			CreatedAt:    timestamppb.New(createdAt),
			UpdatedAt:    timestamppb.New(updatedAt),
		},
	}, nil
}

func (r *usersRepository) GetByEmail(ctx context.Context, req *pb.GetUserByEmailRequest) (*pb.GetUserByEmailResponse, error) {
	query, args, err := sq.
		Select("id", "email", "password_hash", "first_name", "last_name", "role", "created_at", "updated_at").
		From("users").Where(sq.Eq{"email": req.Email}).
		PlaceholderFormat(sq.Dollar).
		ToSql()
	if err != nil {
		return nil, fmt.Errorf("failed build query: %s", err.Error())
	}

	var (
		id           int64
		email        string
		passwordHash string
		firstName    string
		lastName     string
		role         int32
		createdAt    time.Time
		updatedAt    time.Time
	)

	err = r.db.QueryRowContext(ctx, query, args...).Scan(
		&id,
		&email,
		&passwordHash,
		&firstName,
		&lastName,
		&role,
		&createdAt,
		&updatedAt,
	)
	if err != nil {
		if err == sql.ErrNoRows {
			return nil, errors.New("user not found")
		}
		return nil, fmt.Errorf("failed to get user: %s", err.Error())
	}

	userRole := pb.UserRole(role)

	return &pb.GetUserByEmailResponse{
		User: &pb.User{
			Id:           id,
			Email:        email,
			PasswordHash: passwordHash,
			FirstName:    firstName,
			LastName:     lastName,
			Role:         &userRole,
			CreatedAt:    timestamppb.New(createdAt),
			UpdatedAt:    timestamppb.New(updatedAt),
		},
	}, nil
}

func (r *usersRepository) GetAll(ctx context.Context, req *pb.GetAllUsersRequest) (*pb.GetAllUsersResponse, error) {
	query, args, err := sq.
		Select("id", "email", "password_hash", "first_name", "last_name", "role", "created_at", "updated_at").
		From("users").
		OrderBy("email DESC").
		PlaceholderFormat(sq.Dollar).
		ToSql()
	if err != nil {
		return nil, fmt.Errorf("failed build query: %s", err.Error())
	}

	rows, err := r.db.QueryContext(ctx, query, args...)
	if err != nil {
		return nil, fmt.Errorf("failed to get users: %s", err.Error())
	}
	defer rows.Close()

	var users []*pb.User
	for rows.Next() {
		var (
			id           int64
			email        string
			passwordHash string
			firstName    string
			lastName     string
			role         int32
			createdAt    time.Time
			updatedAt    time.Time
		)

		err := rows.Scan(
			&id,
			&email,
			&passwordHash,
			&firstName,
			&lastName,
			&role,
			&createdAt,
			&updatedAt,
		)
		if err != nil {
			return nil, fmt.Errorf("failed to scan user: %s", err.Error())
		}

		userRole := pb.UserRole(role)

		users = append(users, &pb.User{
			Id:           id,
			Email:        email,
			PasswordHash: passwordHash,
			FirstName:    firstName,
			LastName:     lastName,
			Role:         &userRole,
			CreatedAt:    timestamppb.New(createdAt),
			UpdatedAt:    timestamppb.New(updatedAt),
		})
	}

	err = rows.Err()
	if err != nil {
		return nil, fmt.Errorf("rows error: %s", err.Error())
	}

	return &pb.GetAllUsersResponse{
		Users: users,
	}, nil
}

func (r *usersRepository) Update(ctx context.Context, req *pb.UpdateUserByIdRequest) (*pb.UpdateUserByIdResponse, error) {
	updateBuilder := sq.
		Update("users").
		Where(sq.Eq{"id": req.Id}).
		Set("updated_at", time.Now())

	if len(req.Email) != 0 {
		updateBuilder = updateBuilder.Set("email", req.Email)
	}

	if len(req.PasswordHash) != 0 {
		updateBuilder = updateBuilder.Set("password_hash", req.PasswordHash)
	}

	if len(req.FirstName) != 0 {
		updateBuilder = updateBuilder.Set("first_name", req.FirstName)
	}

	if len(req.LastName) != 0 {
		updateBuilder = updateBuilder.Set("last_name", req.LastName)
	}

	if req.Role != nil {
		updateBuilder = updateBuilder.Set("role", *req.Role)
	}

	query, args, err := updateBuilder.
		PlaceholderFormat(sq.Dollar).
		Suffix("RETURNING id, email, password_hash, first_name, last_name, role, created_at, updated_at").
		ToSql()
	if err != nil {
		return nil, fmt.Errorf("failed build query: %s", err.Error())
	}

	var (
		id           int64
		email        string
		passwordHash string
		firstName    string
		lastName     string
		role         int32
		createdAt    time.Time
		updatedAt    time.Time
	)

	err = r.db.QueryRowContext(ctx, query, args...).Scan(
		&id,
		&email,
		&passwordHash,
		&firstName,
		&lastName,
		&role,
		&createdAt,
		&updatedAt,
	)
	if err != nil {
		if err == sql.ErrNoRows {
			return nil, errors.New("user not found")
		}
		return nil, fmt.Errorf("failed to update user: %s", err.Error())
	}

	userRole := pb.UserRole(role)

	return &pb.UpdateUserByIdResponse{
		User: &pb.User{
			Id:           id,
			Email:        email,
			PasswordHash: passwordHash,
			FirstName:    firstName,
			LastName:     lastName,
			Role:         &userRole,
			CreatedAt:    timestamppb.New(createdAt),
			UpdatedAt:    timestamppb.New(updatedAt),
		},
	}, nil
}

func (r *usersRepository) Delete(ctx context.Context, req *pb.DeleteUserByIdRequest) (*pb.DeleteUserByIdResponse, error) {
	query, args, err := sq.
		Delete("users").
		Where(sq.Eq{"id": req.Id}).
		PlaceholderFormat(sq.Dollar).
		ToSql()
	if err != nil {
		return nil, fmt.Errorf("failed build query: %s", err.Error())
	}

	result, err := r.db.ExecContext(ctx, query, args...)
	if err != nil {
		return nil, fmt.Errorf("failed to delete user: %w", err)
	}

	rowsAffected, err := result.RowsAffected()
	if err != nil {
		return nil, fmt.Errorf("failed to get rows affected: %w", err)
	}

	if rowsAffected == 0 {
		return nil, errors.New("user not found")
	}

	return &pb.DeleteUserByIdResponse{}, nil
}
