# Step 1: Use official Java runtime
FROM eclipse-temurin:17-jdk-jammy

# Step 2: Set working directory
WORKDIR /app

# Step 3: Copy jar file into container
COPY target/*.jar app.jar

# Step 4: Expose port (default Spring Boot port)
EXPOSE 8080

# Step 5: Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]