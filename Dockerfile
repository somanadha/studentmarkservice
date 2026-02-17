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

# Copy the application JAR (LEAN/THIN) & its dependencies from the build stage to make a FAT/UBER JAR
COPY --from=build /app/target/*.jar studentmarkservice.jar

# Application is running in port 8100
EXPOSE 8100

# Command to run the application with all dependencies on the classpath
#CMD ["java", "-cp", "studentmarkservice.jar:dependency/*", "edu.vnrvjiet.sms.StudentMarkService"]
ENTRYPOINT ["java", "-jar", "studentmarkservice.jar"]
