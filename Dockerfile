FROM openjdk:17
MAINTAINER MEZ
COPY out/artifacts/tpfinal_jar/tpfinal.jar mez-app.jar
ENTRYPOINT ["java","-jar","/mez-app.jar"]
