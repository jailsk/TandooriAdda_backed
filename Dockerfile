FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
COPY serviceAccountKey.json serviceAccountKey.json
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8083