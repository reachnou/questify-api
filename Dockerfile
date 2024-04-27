FROM openjdk:18.0-jdk
WORKDIR /app
COPY ./target ./
RUN cd
ENTRYPOINT ["java","-jar","questify-api-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080:8080