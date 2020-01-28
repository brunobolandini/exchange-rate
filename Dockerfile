FROM alpine:3.5

EXPOSE 8080

COPY . /opt

WORKDIR /opt

ENV APP_NAME=exchange-rate-spring-boot-demo-0.0.1-SNAPSHOT
ENV APP_PROFILE=dev

CMD java -jar -Dspring.profiles.active=$ $APP_NAME -Xms512M -Xmx768MAPP_PROFILE