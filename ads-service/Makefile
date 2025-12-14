GRADLE=./gradlew

ifeq ($(OS),Windows_NT)
	GRADLE=gradlew.bat
endif

.PHONY: build clean run gen

build:
	$(GRADLE) build

run:
	$(GRADLE) bootRun

clean:
	$(GRADLE) clean

gen:
	$(GRADLE) generateProto
