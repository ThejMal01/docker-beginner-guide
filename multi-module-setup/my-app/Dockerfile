FROM maven:3.9.11-eclipse-temurin-21 AS build
WORKDIR /build

COPY ../pom.xml .

COPY pom.xml my-app/pom.xml
RUN mvn -N -f my-app/pom.xml dependency:go-offline -B

COPY my-app my-app

RUN mvn -N -f my-app/pom.xml clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=build /build/my-app/target/my-app-*.jar my-app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "my-app.jar"]