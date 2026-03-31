FROM eclipse-temurin:21-jdk AS build
COPY --chown=gradle:gradle . /app
WORKDIR /app
run ./gradlew bootJar --no-daemon

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar platzi_play.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "platzi_play.jar"]
