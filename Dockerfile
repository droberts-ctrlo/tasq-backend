FROM maven:3-amazoncorretto-21 AS build
WORKDIR /app
COPY . /app/
RUN mvn clean package -DskipTests

FROM amazoncorretto:21
WORKDIR /app
COPY --from=build /app/target/backend.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
