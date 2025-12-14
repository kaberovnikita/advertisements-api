package dtoads

type AdsDto struct {
	Title       string  `json:"title" validate:"required,min=3,max=200"`
	Description string  `json:"description" validate:"required,min=3,max=5000"`
	Price       float64 `json:"price" validate:"required,gt=0"`
	Currency    string  `json:"currency" validate:"required,len=3,uppercase"`
	CategoryID  int64   `json:"category_id" validate:"required,gt=0"`
	UserID      int64   `json:"user_id" validate:"required,gt=0"`
}

type CreateAdsResponse struct {
	Id int64 `json:"id"`
}

type UpdateAdsDto struct {
	Title       string  `json:"title,omitempty" validate:"omitempty,min=3,max=200"`
	Description string  `json:"description,omitempty" validate:"omitempty,min=3,max=5000"`
	Price       float64 `json:"price,omitempty" validate:"omitempty,gt=0"`
	Currency    string  `json:"currency,omitempty" validate:"omitempty,len=3,uppercase"`
	CategoryID  int64   `json:"category_id,omitempty" validate:"omitempty,gt=0"`
}
