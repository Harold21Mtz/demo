FROM openjdk:17
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} miProyecto.jar
ENTRYPOINT ["java", "-jar", "/miProyecto.jar"]
