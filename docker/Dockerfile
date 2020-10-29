FROM openjdk:latest

RUN git clone https://github.com/NobuhisaAbe/demo.git
WORKDIR ./demo

RUN ./gradlew --full-stacktrace -q build

CMD ./gradlew bootRun

#FROM adoptopenjdk/openjdk11:jdk-11.0.6_10-alpine
#RUN mkdir -p /home/www/demo
#RUN mkdir -p /usr/local/src/demo
#WORKDIR /usr/local/src/demo
#COPY ./gradlew ./
#COPY ./gradle ./gradle
#COPY ./settings.gradle.kts ./
#COPY ./build.gradle.kts ./
#COPY ./src ./src
#RUN ./gradlew build

#FROM adoptopenjdk/openjdk11:jdk-11.0.6_10-alpine
#COPY --from=0 /usr/local/src/demo/build/libs/*.jar /home/www/demo/app.jar
#CMD ["java", "-jar", "/home/www/demo/app.jar"]
#CMD /bin/ash -c "./gradlew bootRun"