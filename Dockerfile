FROM fantito/jdk11-maven-git

MAINTAINER huyoucheng

RUN mkdir -p /app

WORKDIR /app

COPY target/lifeplus-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD java -jar lifeplus-0.0.1-SNAPSHOT.jar
