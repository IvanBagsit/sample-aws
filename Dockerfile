# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /sample-cloud

# Copy the jar file into the container
COPY target/sample-cloud-0.0.1-SNAPSHOT.jar sample-cloud.jar

# Expose the port your app runs on (default 8080)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "sample-cloud.jar"]