
# 1st stage, build the app
FROM maven:3.8.4-openjdk-17-slim as build

WORKDIR /spring-boot

# Create a first layer to cache the "Maven World" in the local repository.
# Incremental docker builds will always resume after that, unless you update
# the pom
ADD pom.xml .
RUN mvn package -Dmaven.test.skip

# Do the Maven build!
# Incremental docker builds will resume here when you change sources
ADD src src
RUN mvn package -DskipTests

RUN echo "done!"

# 2nd stage, build the runtime image
FROM openjdk:17-jdk-slim
WORKDIR /spring-boot

# Copy the binary built in the 1st stage
COPY --from=build /spring-boot/target/spring-boot-client.jar ./

CMD ["java", "-jar", "spring-boot-client.jar"]

EXPOSE 8080
