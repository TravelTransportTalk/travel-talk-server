FROM docker.io/library/maven:3.9.6-eclipse-temurin-21-alpine as builder

WORKDIR /build
ADD pom.xml pom.xml
ADD src src

RUN --mount=type=cache,target=/root/.m2 mvn -DskipTests=true package && rm target/*.original

FROM docker.io/library/eclipse-temurin:21.0.2_13-jre-alpine
WORKDIR /app
RUN adduser -DH runner

ENTRYPOINT ["java"]
CMD ["-jar", "/app/app.jar"]
COPY --from=builder --chown=runner /build/target/*.jar /app/app.jar
