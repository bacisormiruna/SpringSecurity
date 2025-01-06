FROM openjdk:21-jdk-slim
WORKDIR /app
COPY . /app
RUN ./gradlew clean build -x check -x test
CMD ["java", "-jar", "build/libs/demoM-0.0.1-SNAPSHOT.jar"]
