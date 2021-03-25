FROM openjdk:11
EXPOSE 8080
RUN mkdir -p /app/
ADD build/libs/rest-api-service-0.0.1.jar /app/rest-api-service-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/app/rest-api-service-0.0.1.jar"]