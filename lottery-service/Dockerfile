FROM 10.55.56.201:5000/kubesphere/builder-maven:v2.1.0
ENV TZ=Asia/Shanghai LANG=C.UTF-8 LANGUAGE=C.UTF-8 LC_ALL=C.UTF-8
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ADD target/lottery-service.jar /app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
