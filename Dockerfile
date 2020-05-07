#version 1.1
FROM adoptopenjdk/openjdk11:ubi
VOLUME /tmp
ADD /target/expression-converter.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","/app.jar"]