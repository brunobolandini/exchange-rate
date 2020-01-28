FROM openjdk:8-jre-alpine

EXPOSE 8080

COPY . /opt

WORKDIR /opt

ENV APP_NAME=target/exchange-rate-spring-boot-demo-0.0.1-SNAPSHOT.jar
ENV APP_PROFILE=dev

CMD java -jar -Dspring.profiles.active=$APP_PROFILE $APP_NAME -Xms512M -Xmx768M