# Use openjdk:17-jdk-slim as base for build and runtime
FROM openjdk:17-jdk-slim

# Install Maven (since this image doesn't have Maven by default)
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Set working directory
WORKDIR /sample-aws

# Copy pom.xml and download dependencies to cache them
COPY pom.xml .

RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# The built jar will be under target folder; copy to app.jar for convenience
RUN cp target/*.jar sample-aws.jar

# Expose default Spring Boot port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "sample-aws.jar"]
