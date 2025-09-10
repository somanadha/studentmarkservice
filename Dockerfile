# Stage 1: Build the application and resolve dependencies
FROM maven:3.9.4-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Download dependencies only to cache them for later build stages
# Download dependencies to the target/dependency directory for later build stages
RUN mvn dependency:copy-dependencies

# Package the application as a fat jar or a standard jar
RUN mvn -X package -DskipTests

# Stage 2: Create the final image
FROM eclipse-temurin:21-alpine
WORKDIR /app

# Copy the application JAR from the build stage
COPY --from=build /app/target/*.jar studentmarkservice.jar

# This is the key part to get all the dependency jars
# The 'go-offline' goal from the first stage already downloaded them.
# The 'dependency:copy-dependencies' goal copies all the jars to a specific directory.
COPY --from=build /app/target/dependency /app/dependency

# Application is running in port 8100
EXPOSE 8100

# Command to run the application with all dependencies on the classpath
#CMD ["java", "-cp", "studentmarkservice.jar:dependency/*", "edu.vnrvjiet.sms.StudentMarkService"]
ENTRYPOINT ["java", "-jar", "studentmarkservice.jar"]
