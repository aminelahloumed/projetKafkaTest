# Étape de compilation
FROM openjdk:17-jdk as builder
WORKDIR /workspace

# Copier les sources
COPY . .

# Compiler et empaqueter l'application
RUN ./mvnw clean package -DskipTests

# Étape de déploiement
FROM openjdk:17-jdk
WORKDIR /app
# Copier seulement le jar depuis le builder
COPY --from=builder /workspace/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]