# ---------- Stage 1: Build ----------
FROM gradle:8.5-jdk21-alpine AS builder
WORKDIR /app

# Copy dependencies for boost start
COPY build.gradle settings.gradle ./
COPY gradle ./gradle
RUN gradle dependencies --no-daemon || true

# Copy all project and build it
COPY . .
RUN gradle bootJar --no-daemon

# ---------- Stage 2: Run ----------
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy builded jar
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8005

ENTRYPOINT ["java", "-jar", "app.jar"]
