FROM gradle:6.9.2-jdk11
USER root
RUN mkdir -p /usr/app
ENV APP_HOME=/usr/app/
COPY . $APP_HOME
WORKDIR $APP_HOME
RUN gradle clean build
ENTRYPOINT ["java", "-jar", "build/libs/capitalgains-0.0.1-SNAPSHOT.jar"]
CMD ["src/test/resources/example_input.txt"]