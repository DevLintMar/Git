FROM lintmar/ubuntu-java:3.0
COPY target/springboot-1.0.0-SNAPSHOT.jar app.jar
CMD java -jar app.jar