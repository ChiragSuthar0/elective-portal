FROM openjdk:17
EXPOSE 8080
WORKDIR /app
ADD build/libs/Elective-Portal-0.0.2-SNAPSHOT.jar ./Elective-Portal-0.0.2-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar", "/app/Elective-Portal-0.0.2-SNAPSHOT.jar" ]