FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/student_demo-0.1.0.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]