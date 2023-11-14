FROM openjdk:17-alpine
RUN mkdir /opt/app
COPY target/*.jar /opt/app/
EXPOSE 8080
CMD sh -c 'java -jar /opt/app/$(ls -t /opt/app | head -n 1)'