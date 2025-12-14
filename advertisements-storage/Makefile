SERVICE_NAME=advertisements-storage
BUILD_DIR=bin
BINARY=$(BUILD_DIR)/$(SERVICE_NAME)

.PHONY: build clean run

build:
	@mkdir -p $(BUILD_DIR)
	go build -o $(BINARY) ./cmd

clean:
	rm -rf $(BUILD_DIR)

run: 
	./bin/advertisements-storage
