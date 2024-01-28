FROM openjdk:11
EXPOSE 8086
ADD target/SpringBootAppClone-0.0.1-SNAPSHOT.jar SpringBootAppClone-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/SpringBootAppClone-0.0.1-SNAPSHOT.jar"]
