#FROM openjdk:8
#FROM openjdk:11
FROM amazoncorretto:11

#타임존세팅
RUN ln -snf /usr/share/zoneinfo/Asia/Seoul /etc/localtime && echo Asia/Seoul > /etc/timezon
#권한 부여
RUN chmod -R 777 HOOXIADMIN
#외부에서 도커로 복사해옴
#COPY *.jar app.jar


EXPOSE 8001

#빌드
ENTRYPOINT ["java","-jar","app.jar"]
