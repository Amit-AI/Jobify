# Stage 1: Build the application using Maven
FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /app

# Copy the pom.xml and src directory to the container
COPY pom.xml .
COPY src ./src

# Run Maven build (clean and package) and skip tests
RUN echo "Building the application..."
RUN mvn clean package -DskipTests

# Stage 2: Create the final image with the built JAR file
FROM openjdk:17-oracle

WORKDIR /app

# Copy the JAR file from the Maven build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8081
EXPOSE 8081

# Define the command to run the JAR file
CMD ["java", "-jar", "app.jar"]
