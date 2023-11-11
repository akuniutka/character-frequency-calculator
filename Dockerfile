FROM eclipse-temurin:8-jdk as build
RUN apt-get update
RUN apt-get upgrade -y
RUN apt-get install -y git
RUN git clone https://github.com/akuniutka/character-frequency-calculator.git character-frequency-calculator
WORKDIR character-frequency-calculator
RUN ./mvnw clean package
FROM eclipse-temurin:8-jre as target
COPY --from=build /character-frequency-calculator/target/character-frequency-calculator-0.1.0-SNAPSHOT.jar /app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app.jar"]