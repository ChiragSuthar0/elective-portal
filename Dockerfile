FROM openjdk:17
EXPOSE 8080
ADD build/libs/Elective-Portal-0.0.2-SNAPSHOT.jar ./Elective-Portal-0.0.2-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar", "./Elective-Portal-0.0.2-SNAPSHOT.jar" ]
