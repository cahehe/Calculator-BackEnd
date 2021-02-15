FROM openjdk:13.0.2
WORKDIR /home/calculatorBackend
COPY build/libs/calculator-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]
EXPOSE 8080