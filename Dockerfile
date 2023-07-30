MAINTAINER Carlos Sierra carlos.sierra.at@usa.edu.co

FROM --platform=$BUILDPLATFORM maven:3.9.1-jdk-11-slim AS development

WORKDIR /workspace

COPY pom.xml /workspace/pom.xml
RUN mvn clean install -DskipTests=true

FROM development AS dev-envs
RUN <<EOF
apt-get update
apt-get install git -y
EOF

COPY src /workspace/src

FROM openjdk:8-alpine
COPY --from=build /workspace/target/*.jar app.jar

EXPOSE 8080
VOLUME /tmp
ARG DEPENDENCY=/workspace/target/dependency
COPY --from=prepare-production ${DEPENDENCY}/BOOT-INF/lib /app/lib
ENTRYPOINT ["java","-jar","app.jar"]
