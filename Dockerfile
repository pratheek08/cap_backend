# Use OpenJDK base image
FROM openjdk:17-jdk-slim

# Set application JAR name
ARG JAR_FILE=target/*.jar

# Create app directory
WORKDIR /app

# Copy the JAR file into the container
COPY ${JAR_FILE} app.jar

# Expose the port your app runs on (change if needed)
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
