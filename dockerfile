FROM openjdk:17-jdk-alpine
# RUN ["mvnw clean -DskipTests package"]  
COPY target/interns-0.0.1-SNAPSHOT.jar interns-0.0.1.jar
ENTRYPOINT ["java","-jar","/interns-0.0.1.jar"]