package dtocategory

type CategoryDto struct {
	Name  string `json:"name" validate:"required,min=3,max=100"`
	Alias string `json:"alias" validate:"required,min=3,max=100,lowercase"`
}

type CreateCategoryResponse struct {
	Id int64 `json:"id"`
}

type UpdateCategoryDto struct {
	Name  string `json:"name" validate:"omitempty,min=3,max=100"`
	Alias string `json:"alias" validate:"omitempty,min=3,max=100,lowercase"`
}
