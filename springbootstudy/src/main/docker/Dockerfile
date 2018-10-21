FROM frolvlad/alpine-oraclejdk8:slim
COPY springbootstudy.jar springbootstudy.jar
EXPOSE 9080
ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/springbootstudy.jar" ]
