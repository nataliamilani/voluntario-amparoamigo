FROM openjdk:11-jre-slim

WORKDIR /app

EXPOSE 8081

ENV DATABASE_CONNECTION_URL="jdbc:mysql://dbvoluntario:3306/voluntariodb"
ENV EUREKA_CONNECTION_URL="http://eureka:8761"

COPY target/voluntario.jar /app/voluntario.jar

ENTRYPOINT ["java", "-jar", "voluntario.jar"]