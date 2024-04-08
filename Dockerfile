FROM amazoncorretto:22-alpine-jdk
VOLUME /tmp
COPY target/*.jar app.jar
COPY inst/opentelemetry-javaagent-2.2.0.jar opentelemetry-javaagent.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar"]