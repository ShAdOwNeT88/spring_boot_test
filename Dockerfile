# FROM openjdk:21
# COPY //target/docker-0.0.1-SNAPSHOT.jar app.jar
# ENTRYPOINT ["java", "-jar", "/app.jar"]

FROM maven:3.9.6-amazoncorretto-21
WORKDIR /docker
COPY .. .
RUN mvn clean install

CMD mvn spring-boot:run

#
# Build stage
#
#FROM maven:3.9.6-amazoncorretto-21 AS build
#COPY src /home/app/src
#COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean package
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/home/app/target/spring_rest_docker.jar"]
