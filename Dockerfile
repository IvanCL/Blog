# Builder step
ARG JAVA_VERSION=22-ea-21-jdk-slim-bullseye
FROM maven:3.8.6-jdk-11-slim AS builder
WORKDIR /app

COPY pom.xml .
COPY src src
COPY .mvn .mvn

RUN --mount=type=cache,target=/root/.m2 \ mvn -B package -DskipTests -Dmaven.java.version=21

# Ejecution step
FROM openjdk:$JAVA_VERSION

# Install Maven
RUN apt-get update && apt-get install -y maven

# Set working directory
WORKDIR /app

# Copy JAR file
COPY target/*.jar app.jar

# Expose port
EXPOSE 8080

# Start the application
CMD ["java", "-jar", "app.jar"]