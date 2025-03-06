# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper and pom.xml first (to leverage Docker caching)
COPY mvnw pom.xml ./
COPY .mvn .mvn/

# Copy the source code into the container
COPY src ./src/

# Expose the application port
EXPOSE 80

# Install Maven and run the application in development mode
RUN apt-get update && apt-get install -y maven
CMD ["mvn", "spring-boot:run"]
