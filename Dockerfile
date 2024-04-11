# 第一阶段构建，设置基础镜像，并设置别名在其他构建阶段可以直接使用
FROM gradle:8.7.0-jdk AS gradle-latest
# 维护者信息
LABEL maintainer="Niemingzhi"
# 设置工作空间，后续命令会在此目录下执行
WORKDIR /app
# 添加文件到容器中
COPY . /app/
# 执行打包命令
RUN gradle clean bootJar

# 第二阶段构建，以第一阶段构建为基础，再次进行构建步骤
FROM openjdk:21-jdk-oracle
WORKDIR /accounting
# 从第一阶段复制结果
# 如果要用的阶段没有设置别名，那么要使用--from=n，n表示从0开始的标记位
COPY --from=gradle-latest /app/ .
# 容器启动时执行的指令
ENTRYPOINT ["/bin/sh", "-c", "java -jar ./build/libs/accounting-0.0.1-SNAPSHOT.jar"]
