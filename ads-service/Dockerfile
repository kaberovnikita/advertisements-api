# ---------- Stage 1: Build ----------
FROM gradle:8.5-jdk21-alpine AS builder
WORKDIR /app

# Copy dependencies for boost start
COPY build.gradle settings.gradle gradle/ ./

RUN gradle dependencies --no-daemon || true

COPY src ./src
COPY build/generated ./build/generated

RUN gradle bootJar --no-daemon -x generateProto

# ---------- Stage 2: Run ----------
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy builded jar
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8005

ENTRYPOINT ["java", "-jar", "app.jar"]
