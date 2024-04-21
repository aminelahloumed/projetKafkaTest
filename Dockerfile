# Utiliser une image de base officielle Java avec JDK 17
FROM openjdk:17-jdk

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier jar de l'application dans le répertoire de travail
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Exposer le port que votre application utilise, modifiez si nécessaire
EXPOSE 8080

# Exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]