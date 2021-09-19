FROM openjdk:8
ADD target/kdbms_web.jar kdbms_web.jar
ENTRYPOINT ["java", "-jar", "kdbms_web.jar"]
EXPOSE 8080