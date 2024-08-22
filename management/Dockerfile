# Use a base image with JDK 21 and Maven 4
FROM jelastic/maven:3.9.5-openjdk-21 AS build
# Install the necessary packages for Maven
#RUN apk add --no-cache ca-certificates wget
#
## Download the Maven binary
#RUN wget -qO- https://dlcdn.apache.org/maven/maven-3.10.0/binaries/apache-maven-3.10.0-bin.tar.gz | tar -xz
#RUN ls -l apache-maven-3.10.0-bin.tar.gz
#
## Set the Maven environment variables
#ENV MAVEN_HOME /usr/local/apache-maven-3.10.0
#ENV PATH $MAVEN_HOME/bin:$PATH

# Copy the project files to the container
COPY pom.xml ./
COPY src ./src

# Build the Spring Boot application
RUN mvn clean package

# Create a runtime stage based on the build stage
FROM openjdk:21-jdk AS runtime

# Copy the built JAR from the build stage
COPY --from=build target/*.jar app.jar

# Expose the port your application uses (replace 8080 with your actual port)
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "app.jar"]