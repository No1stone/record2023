#FROM openjdk:8
#FROM openjdk:11
FROM amazoncorretto:11

RUN ln -snf /usr/share/zoneinfo/Asia/Seoul /etc/localtime && echo Asia/Seoul > /etc/timezon

COPY *.jar app.jar

EXPOSE 8001

ENTRYPOINT ["java","-jar","app.jar"]
