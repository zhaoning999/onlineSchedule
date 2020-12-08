FROM openjdk:8-jdk-alpine as build
WORKDIR /workspace/app

COPY mvnw pom.xml ./
COPY .mvn .mvn

RUN ls \
  && chmod 777 mvnw \
  && ./mvnw install -DskipTests \
  &&  mkdir -p target/dependency \
  &&  cd target/dependency \
  &&  jar -xf ../*.jar

COPY src src

FROM openjdk:8-jdk-alpine

ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","OnlineSchedule.Application"]