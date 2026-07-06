FROM eclipse-temurin:21-jdk-alpine
MAINTAINER algebra-it.hr
COPY target/Zavrsni3-1.0-SNAPSHOT.jar Zavrsni3.jar
EXPOSE 8888
ENTRYPOINT [ "java","-jar","/Zavrsni3.jar" ]