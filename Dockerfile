FROM maven:3.5.0-jdk-8-alpine
MAINTAINER "Felipe Oliveira"

ENV SRC_HOME /usr/src/mars-exploration-rovers

COPY src $SRC_HOME/src
COPY pom.xml $SRC_HOME
RUN mvn -f $SRC_HOME/pom.xml clean package

ENV APP_HOME /opt/mars-exploration-rovers

RUN mkdir -p $APP_HOME
RUN cp $SRC_HOME/target/mars-exploration-rovers-1.0.0-SNAPSHOT.jar $APP_HOME/mars-exploration-rovers.jar

WORKDIR $APP_HOME

EXPOSE 8080

CMD ["java", "-jar", "mars-exploration-rovers.jar"]