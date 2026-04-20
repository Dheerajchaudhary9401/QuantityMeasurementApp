# =========================
# Stage 1: Build Stage
# =========================
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom first (better caching)
COPY pom.xml .

# Download dependencies first (faster rebuilds)
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build application
RUN mvn clean package -DskipTests

# =========================
# Stage 2: Runtime Stage
# =========================
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Render uses dynamic port → must be exposed
EXPOSE 8080

# IMPORTANT: Render injects PORT env variable
# Spring Boot must use it (see note below)

ENTRYPOINT ["java", "-jar", "app.jar"]