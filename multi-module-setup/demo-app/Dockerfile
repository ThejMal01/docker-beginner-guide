FROM maven:3.9.11-eclipse-temurin-21 AS build
WORKDIR /build

COPY . .

RUN mvn clean package -pl demo-app -am -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=build /build/demo-app/target/demo-app-*.jar demo-app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "demo-app.jar"]

###########################################################
#FROM maven:3.9.11-eclipse-temurin-21 AS build
#WORKDIR /build
#
#COPY ../pom.xml .
#
#COPY pom.xml demo-app/pom.xml
#RUN mvn -N -f demo-app/pom.xml dependency:go-offline -B
#
#COPY demo-app demo-app
#
#RUN mvn -N -f demo-app/pom.xml clean package -DskipTests
#
#FROM eclipse-temurin:21-jre
#WORKDIR /app
#
#COPY --from=build /build/demo-app/target/demo-app-*.jar demo-app.jar
#
#EXPOSE 8082
#
#ENTRYPOINT ["java", "-jar", "demo-app.jar"]