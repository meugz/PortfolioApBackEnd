FROM openjdk:18
MAINTAINER MEZ
COPY target/tpfinal-0.0.1-SNAPSHOT.jar mez-app.jar
ENTRYPOINT ["java","-jar","/mez-app.jar"]
EXPOSE 8080