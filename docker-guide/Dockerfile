# 1) Build stage: compile the app with Maven + JDK
FROM maven:3.9.11-eclipse-temurin-21 AS build
WORKDIR /build

# Copy only pom.xml and download dependencies first (caching)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src ./src

# Build the jar (skip tests to speed up in examples)
RUN mvn clean package -DskipTests

# 2) Runtime stage: smaller image only with JRE + jar
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copy the fat jar (or spring-boot jar) from the build stage
COPY --from=build /build/target/*.jar app.jar

# Application listens on 8080 by default (change if you use another port)
EXPOSE 8080

# Start the app
ENTRYPOINT ["java", "-jar", "app.jar"]