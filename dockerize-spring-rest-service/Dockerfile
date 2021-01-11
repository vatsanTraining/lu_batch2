FROM java:8

ARG JAR_FILE=target/doctor-rest-service.jar

WORKDIR /opt/app

expose 8080

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]
