# Stage 1: Build the application
FROM openjdk:21-jdk-slim AS builder
WORKDIR /build

# Install Maven in the builder stage
RUN apt-get update && apt-get install -y maven

# Copy the project files and build the application
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /build/target/redis-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 for the application
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
