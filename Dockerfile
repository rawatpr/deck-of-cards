FROM maven:3.6.3-ibmjava-8-alpine as base
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests
    
FROM ibmjava:8-jre-alpine as target

    
WORKDIR /app
USER root
RUN chgrp -R 0 /app && chmod -R g=u /app
VOLUME /jobs-poc
COPY --from=base /app/target/deck-of-cards-0.0.1-SNAPSHOT.jar deck-of-cards.jar

RUN chmod -R 770 /app

EXPOSE 1010
ENTRYPOINT ["java", "-jar", "deck-of-cards.jar"]
