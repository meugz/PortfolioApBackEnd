FROM openjdk:18
MAINTAINER MEZ
COPY target/tpfinal-0.0.1-SNAPSHOT.jar tpfinal-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/tpfinal-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080