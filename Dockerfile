# -------- Stage 1: Build --------
FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy pom.xml first (for caching dependencies)
COPY pom.xml .

RUN mvn dependency:go-offline

# Copy full project
COPY src ./src

# Build JAR
RUN mvn clean install -DskipTests

# -------- Stage 2: Run --------
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy jar from builder
COPY --from=builder /app/target/*.jar app.jar

# Render requires dynamic port
ENV PORT=8080

EXPOSE 8080

# Run app
ENTRYPOINT ["java","-jar","app.jar"]
