FROM adoptopenjdk/openjdk15:jdk-15.0.1_9-slim
RUN apt-get update && apt-get install -y git
RUN git clone https://github.com/NobuhisaAbe/demo.git
WORKDIR ./demo
RUN ./gradlew --full-stacktrace -q build -x test
CMD ./gradlew bootRun