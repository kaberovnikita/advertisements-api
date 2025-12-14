package usersservice

import (
	"context"
	"errors"
	"os"
	"regexp"
	"strings"

	"github.com/golang-jwt/jwt/v5"
	"golang.org/x/crypto/bcrypt"

	types "advertisement-storage/pkg"
	pb "advertisement-storage/pkg/pb"
)

type usersService struct {
	repo types.UserRepository
}

func NewUsersService(repo types.UserRepository) *usersService {
	return &usersService{
		repo: repo,
	}
}

func (s *usersService) RegisterUser(ctx context.Context, req *pb.RegisterUserRequest) (*pb.RegisterUserResponse, error) {
	emailRegex := regexp.MustCompile(`^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$`)
	if !emailRegex.MatchString(req.Email) {
		return nil, errors.New("invalid email format")
	}

	req.Email = strings.ToLower(strings.TrimSpace(req.Email))
	req.FirstName = strings.TrimSpace(req.FirstName)
	req.LastName = strings.TrimSpace(req.LastName)

	hashedPassword, err := bcrypt.GenerateFromPassword([]byte(req.Password), bcrypt.DefaultCost)
	if err != nil {
		return nil, errors.New("failed to process password")
	}

	return s.repo.Create(ctx, &pb.RegisterUserRequest{
		Email:     req.Email,
		Password:  string(hashedPassword),
		FirstName: req.FirstName,
		LastName:  req.LastName,
		Role:      req.Role,
	})
}

func (s *usersService) LoginUser(ctx context.Context, req *pb.LoginUserRequest) (*pb.LoginUserResponse, error) {
	req.Email = strings.TrimSpace(req.Email)
	req.Password = strings.TrimSpace(req.Password)

	userResp, err := s.repo.GetByEmail(ctx, &pb.GetUserByEmailRequest{Email: req.Email})
	if err != nil {
		return nil, err
	}

	err = bcrypt.CompareHashAndPassword([]byte(userResp.User.PasswordHash), []byte(req.Password))
	if err != nil {
		return nil, errors.New("invalid email or password")
	}

	token, err := generateJWT(userResp.User)
	if err != nil {
		return nil, errors.New("failed to generate authentication token")
	}

	return &pb.LoginUserResponse{
		AccessToken: token,
	}, nil
}

func (s *usersService) GetAllUsers(ctx context.Context, req *pb.GetAllUsersRequest) (*pb.GetAllUsersResponse, error) {
	resp, err := s.repo.GetAll(ctx, req)
	if err != nil {
		return nil, err
	}

	return resp, nil
}

func (s *usersService) GetUserByID(ctx context.Context, req *pb.GetUserByIDRequest) (*pb.GetUserByIdResponse, error) {
	resp, err := s.repo.GetByID(ctx, req)
	if err != nil {
		return nil, err
	}

	return resp, nil
}

func (s *usersService) UpdateUserById(ctx context.Context, req *pb.UpdateUserByIdRequest) (*pb.UpdateUserByIdResponse, error) {
	emailRegex := regexp.MustCompile(`^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$`)

	if len(req.Email) != 0 {
		req.Email = strings.ToLower(strings.TrimSpace(req.Email))
		if !emailRegex.MatchString(req.Email) {
			return nil, errors.New("invalid email format")
		}
	}

	if len(req.PasswordHash) != 0 {
		hashedPassword, err := bcrypt.GenerateFromPassword([]byte(req.PasswordHash), bcrypt.DefaultCost)
		if err != nil {
			return nil, errors.New("failed to process password")
		}

		req.PasswordHash = string(hashedPassword)
	}

	resp, err := s.repo.Update(ctx, req)
	if err != nil {
		return nil, err
	}

	return resp, nil
}

func (s *usersService) DeleteUserById(ctx context.Context, req *pb.DeleteUserByIdRequest) (*pb.DeleteUserByIdResponse, error) {
	_, err := s.repo.GetByID(ctx, &pb.GetUserByIDRequest{Id: req.Id})
	if err != nil {
		return nil, err
	}

	return s.repo.Delete(ctx, req)
}

func generateJWT(user *pb.User) (string, error) {
	secret := os.Getenv("JWT_SECRET")

	claims := jwt.MapClaims{
		"user_id": user.Id,
		"email":   user.Email,
	}

	if user.Role != nil {
		claims["role"] = *user.Role
	}

	token := jwt.NewWithClaims(jwt.SigningMethodHS256, claims)
	return token.SignedString([]byte(secret))
}
