package usersdto

import (
	pb "api-gateway/pkg/pb"
)

type RegisterDto struct {
	Email     string `json:"email" validate:"required"`
	Password  string `json:"password" validate:"required,min=6"`
	FirstName string `json:"first_name" validate:"required,min=2"`
	LastName  string `json:"last_name" validate:"required,min=2"`
	Role      int32  `json:"role" validate:"omitempty"`
}

type LoginDto struct {
	Email    string `json:"email" validate:"required"`
	Password string `json:"password" validate:"required"`
}

type UpdateUserDto struct {
	Email     string `json:"email" validate:"omitempty"`
	FirstName string `json:"first_name" validate:"omitempty,min=2"`
	LastName  string `json:"last_name" validate:"omitempty,min=2"`
	Role      int32  `json:"role" validate:"omitempty"`
}

func (r *RegisterDto) ConvertRoleToPB() *pb.UserRole {
	if r.Role == 1 {
		role := pb.UserRole_USER_ROLE_ADMIN
		return &role
	}

	role := pb.UserRole_USER_ROLE_USER
	return &role
}

func (u *UpdateUserDto) ConvertRoleToPB() *pb.UserRole {
	switch u.Role {
	case 1:
		role := pb.UserRole_USER_ROLE_ADMIN
		return &role
	case 0:
		role := pb.UserRole_USER_ROLE_USER
		return &role
	}

	return nil
}
