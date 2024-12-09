
FROM eclipse-temurin:17-jdk-alpine AS build


WORKDIR /app

COPY . .

RUN chmod +x ./gradlew

RUN ./gradlew bootJar --no-daemon


FROM eclipse-temurin:17-jre-alpine


WORKDIR /app

COPY --from=build /app/build/libs/gestion_candidatos-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
