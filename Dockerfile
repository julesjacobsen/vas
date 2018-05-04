FROM azul/zulu-openjdk-alpine
VOLUME /tmp
VOLUME /data
#ARG JAR_FILE
#COPY ${JAR_FILE} app.jar
ADD /target/vas-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Xms2G", "-Xmx4G", "-jar","app.jar"]