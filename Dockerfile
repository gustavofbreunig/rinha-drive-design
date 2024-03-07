FROM amazoncorretto:17-alpine
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "-XX:TieredStopAtLevel=1","-noverify", "/app.jar"]
