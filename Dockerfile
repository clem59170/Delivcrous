# Utiliser l'image OpenJDK 19
FROM openjdk:19
# Répertoire de travail
WORKDIR /app

# Copie du jar généré par Maven
COPY Delivcrous-0.0.1-SNAPSHOT.jar Delivcrous-0.0.1-SNAPSHOT.jar

# Commande pour exécuter l'application
CMD ["java", "-jar", "Delivcrous-0.0.1-SNAPSHOT.jar"]

