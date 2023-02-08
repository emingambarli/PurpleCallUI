FROM openjdk:19
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=./target/loginapp*.jar
ADD ${JAR_FILE} loginapp.jar
ENTRYPOINT ["java","-jar","/loginapp.jar"]