FROM openjdk:22-ea-21-jdk-slim-bullseye

WORKDIR /app/blog

COPY ./target/Blog-0.0.1-SNAPSHOT.jar .
RUN mkdir ./logs

ARG PORT_APP=8080
ENV PORT=$PORT_APP
EXPOSE $PORT

CMD ["java", "-jar", "Blog-0.0.1-SNAPSHOT.jar"]