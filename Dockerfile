# Estágio de build
FROM gradle:8.13-jdk17 AS build
WORKDIR /app
COPY . ./
RUN gradle :infrastructure:clean :infrastructure:build --no-daemon

# Estágio final
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/infrastructure/build/libs/infrastructure-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENV JAVA_OPTS="-Xms256m -Xmx512m"
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]