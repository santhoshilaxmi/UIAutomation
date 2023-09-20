FROM openjdk:17
EXPOSE 8080
ADD target/jenkins-pipeline.jar jenkins-pipeline.jar
ENTRYPOINT ["java","-jar","/jenkins-pipeline.jar"]