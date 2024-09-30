FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY src /app/src
COPY pom.xml /app
RUN mvn clean install -DskipTests -Dmaven.test.skip=true
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/FiadoSafe-0.0.1-SNAPSHOT.jar /app/app.jar
CMD ["java", "-jar", "app.jar"]

