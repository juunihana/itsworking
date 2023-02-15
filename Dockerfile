FROM maven:3.6-jdk-8-alpine AS build
COPY . /home/spring/
RUN mvn -f /home/spring/pom.xml clean package

FROM openjdk:8-alpine
COPY --from=build /home/spring/target/*.jar /home/spring/app.jar
WORKDIR /home/spring
EXPOSE 80
ENTRYPOINT ["java", "-jar", "/home/spring/app.jar"]
