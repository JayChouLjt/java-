# 使用官方的Java基础镜像
FROM openjdk:8-jdk-alpine
# 将本地的jar文件复制到容器中
COPY music-1.0-SNAPSHOT.jar app.jar
# 暴露端口
EXPOSE 8888
# 运行命令
ENTRYPOINT ["java", "-jar", "/app.jar"]
