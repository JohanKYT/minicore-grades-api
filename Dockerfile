# Primero se compila
FROM maven:3.9.5-amazoncorretto-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# Y luego se ejecuta
FROM amazoncorretto:21-al2023-headless
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]