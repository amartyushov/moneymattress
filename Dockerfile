FROM openjdk:14-alpine
COPY build/libs/moneykeeper-*-all.jar moneykeeper.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "moneykeeper.jar"]