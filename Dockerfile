## dokcer based on jdk 1.19
FROM  openjdk:17-jdk-slim

## copy jar file to docker
COPY target/*.jar app.jar
## run jar file
ENTRYPOINT ["java","-jar","/app.jar"]
## expose port
EXPOSE 8080


