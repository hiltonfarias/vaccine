FROM openjdk:16-alpine

RUN mkdir /usr/vaccine

COPY target/vaccine.jar /usr/vaccine/vaccine.jar
WORKDIR /usr/vaccine

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java --enable-preview $JAVA_OPTS -jar vaccine.jar"]