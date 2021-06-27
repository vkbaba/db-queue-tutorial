### BUILD image
FROM maven:3.8.1-jdk-11 as builder
# create app folder for sources
RUN mkdir -p /build
WORKDIR /build
COPY pom.xml /build
#Download all required dependencies into one layer
RUN mvn -B dependency:resolve dependency:resolve-plugins
#Copy source code
COPY src /build/src
# Build application
RUN mvn package -Dmaven.test.skip=true

FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=builder /build/target/demo-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]