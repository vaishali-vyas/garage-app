# Build stage
FROM maven:latest AS build
COPY . .
RUN mvn clean package --no-transfer-progress

# Runtime stage
FROM openjdk:11 AS runtime
COPY --from=build /target/Garage-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar"]
