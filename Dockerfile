# FROM openjdk:11
#
# MAINTAINER Mariia Slobodian
#
# ARG JAR_FILE=build/libs/*.jar
#
# COPY ${JAR_FILE} /app.jar
#
# ENTRYPOINT ["java", "--enable-preview", "-jar", "/app.jar"]