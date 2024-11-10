# Builder step
FROM maven:3-amazoncorretto-21-alpine AS builder
ARG MSVC_NAME=blog
WORKDIR /app

COPY ./pom.xml /app
COPY ./.mvn ./.mvn
#COPY ./mvnw .
COPY ./pom.xml .

RUN mvn clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN --mount=type=cache,target=/root/.m2 \
 #   mvn clean package -DskipTests
COPY ./src ./src

RUN mvn clean package -DskipTests

FROM openjdk:22-ea-21-jdk-slim-bullseye
ARG MSVC_NAME=blog
WORKDIR /app
RUN mkdir ./logs

ARG TARGET_FOLDER=/app/target
COPY --from=builder $TARGET_FOLDER/*.jar .
ARG PORT_APP=9000
ENV PORT=$PORT_APP
EXPOSE $PORT

CMD ["java", "-jar", "Blog-0.0.1-SNAPSHOT.jar"]