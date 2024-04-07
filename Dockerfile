FROM amazoncorretto:22-alpine-jdk
VOLUME /tmp
#ARG JAR_FILE
COPY target/*.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar"]