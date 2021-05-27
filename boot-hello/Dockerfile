FROM openjdk:8
ARG JAR_FILE=target/boot-hello.jar
COPY ${JAR_FILE} .
EXPOSE 8780
ENTRYPOINT ["java","-jar","/boot-hello.jar"]