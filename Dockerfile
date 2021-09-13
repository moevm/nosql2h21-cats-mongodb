FROM openjdk:11.0.12-jdk-oracle as builder
RUN mkdir -p /app/source
COPY mvnw /app/source/mvnw
COPY .mvn /app/source/.mvn
COPY pom.xml /app/source/pom.xml
COPY src /app/source/src
WORKDIR /app/source
RUN chmod +x ./mvnw
RUN ./mvnw clean package

FROM builder
COPY --from=builder /app/source/target/*.jar /app/app.jar
CMD java -Dfile.encoding=UTF-8 -jar /app/app.jar

