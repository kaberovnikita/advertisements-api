.PHONY: proto proto-storage proto-search proto-category proto-user proto-all

proto-storage:
	@echo "Generating for advertisements-storage..."
	mkdir -p advertisements-storage/pkg/pb
	protoc -I api/proto \
		--go_out=advertisements-storage/pkg/pb \
		--go_opt=paths=source_relative \
		--go_opt=Madvertisements_storage.proto=./pkg/pb \
		--go-grpc_out=advertisements-storage/pkg/pb \
		--go-grpc_opt=paths=source_relative \
		--go-grpc_opt=Madvertisements_storage.proto=./pkg/pb \
		api/proto/advertisements_storage.proto
	@echo "✅ Generated in advertisements-storage/pkg/pb/"

proto-category:
	@echo "Generating for category-service..."
	mkdir -p category-service/pkg/pb
	protoc -I api/proto \
		--go_out=category-service/pkg/pb \
		--go_opt=paths=source_relative \
		--go_opt=Madvertisements_storage.proto=category-service/pkg/pb \
		--go-grpc_out=category-service/pkg/pb \
		--go-grpc_opt=paths=source_relative \
		--go-grpc_opt=Madvertisements_storage.proto=category-service/pkg/pb \
		api/proto/advertisements_storage.proto
	@echo "✅ Generated in category-service/pkg/pb/"

proto-search:
	@echo "Generating for search-service..."
	mkdir -p search-service/pkg/pb
	protoc -I api/proto \
		--go_out=search-service/pkg/pb \
		--go_opt=paths=source_relative \
		--go_opt=Madvertisements_storage.proto=search-service/pkg/pb \
		--go-grpc_out=search-service/pkg/pb \
		--go-grpc_opt=paths=source_relative \
		--go-grpc_opt=Madvertisements_storage.proto=search-service/pkg/pb \
		api/proto/advertisements_storage.proto
	@echo "✅ Generated in search-service/pkg/pb/"


proto-user:
	@echo "Generating for users-service..."
	mkdir -p users-service/pkg/pb
	protoc -I api/proto \
		--go_out=users-service/pkg/pb \
		--go_opt=paths=source_relative \
		--go_opt=Madvertisements_storage.proto=users-service/pkg/pb \
		--go-grpc_out=users-service/pkg/pb \
		--go-grpc_opt=paths=source_relative \
		--go-grpc_opt=Madvertisements_storage.proto=users-service/pkg/pb \
		api/proto/advertisements_storage.proto
	@echo "✅ Generated in users-service/pkg/pb/"

proto-gateway:
	@echo "Generating for api-gateway..."
	mkdir -p api-gateway/pkg/pb
	protoc -I api/proto \
		--go_out=api-gateway/pkg/pb \
		--go_opt=paths=source_relative \
		--go_opt=Madvertisements_storage.proto=api-gateway/pkg/pb \
		--go-grpc_out=api-gateway/pkg/pb \
		--go-grpc_opt=paths=source_relative \
		--go-grpc_opt=Madvertisements_storage.proto=api-gateway/pkg/pb \
		api/proto/advertisements_storage.proto
	@echo "✅ Generated in api-gateway/pkg/pb/"



proto-all: proto-storage proto-search proto-category proto-user
	@echo "✅ All proto files generated!"

proto: proto-all