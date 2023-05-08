FROM openjdk:8-alpine

ADD target/*.jar /opt/ms/clients.jar

EXPOSE 8082
CMD java -jar /opt/ms/clients.jar
