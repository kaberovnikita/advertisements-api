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
	@echo "Generating for user-service..."
	mkdir -p user-service/pkg/pb
	protoc -I api/proto \
		--go_out=user-service/pkg/pb \
		--go_opt=paths=source_relative \
		--go_opt=Madvertisements_storage.proto=user-service/pkg/pb \
		--go-grpc_out=user-service/pkg/pb \
		--go-grpc_opt=paths=source_relative \
		--go-grpc_opt=Madvertisements_storage.proto=user-service/pkg/pb \
		api/proto/advertisements_storage.proto
	@echo "✅ Generated in user-service/pkg/pb/"


proto-all: proto-storage proto-search proto-category proto-user
	@echo "✅ All proto files generated!"

proto: proto-all