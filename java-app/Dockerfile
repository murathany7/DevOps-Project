# Stage 1: Build the application
FROM maven:3.8.4-openjdk-11 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Stage 2: Run the application
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/simple-java-app-0.0.1-SNAPSHOT.jar /app/simple-java-app.jar
EXPOSE 8080
CMD ["java", "-jar", "simple-java-app.jar"]
