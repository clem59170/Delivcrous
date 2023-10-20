# Delivcrous Backend

Delivcrous est une application de livraison qui permet aux utilisateurs de commander des plats depuis différents restaurants.

## Structure du Projet

La structure du projet est organisée comme suit :

- `src/main/java/com/example/delivcrous` : Contient le code source principal du projet.
    - `controller` : Contient les contrôleurs pour gérer les requêtes HTTP.
    - `model` : Contient les modèles de données utilisés dans l'application.
    - `repository` : Contient les interfaces de répository pour interagir avec la base de données.
    - `service` : Contient les services pour la logique métier.
    - `security` : Contient les configurations et utilitaires pour la sécurité et l'authentification.
    - `exceptions` : Contient les classes d'exception personnalisées.
    - `payload` : Contient les classes de requête et de réponse.
- `src/main/resources` : Contient les fichiers de ressources comme `application.properties`.
- `src/test` : Contient les tests unitaires et d'intégration (pas eu le temps des les faire)

## Installation et Exécution

1. Assurez-vous que Maven et Java sont installés sur votre machine.
2. Clonez ce dépôt dans votre machine locale.
3. Naviguez vers le répertoire du projet et exécutez la commande suivante pour construire le projet :
```bash
mvn clean install
```

Vous pouvez ensuite démarrer l'application java avec votre IDE. 

## API Endpoints

L'application fournit plusieurs endpoints API pour interagir avec le système. Voici quelques exemples d'endpoints :

    POST /api/utilisateurs/register : Permet de créer un nouvel utilisateur.
    POST /api/utilisateurs/login : Permet à un utilisateur de se connecter.
    GET /api/plats/getplats : Renvoie la liste des plats disponibles.
    GET /api/panier/getpanier : Renvoie le panier de l'utilisateur connecté
    POST /api/panier/postpanier : Enregistre le panier de l'utilisateur connecté
    POST /api/commandes/createcommande : Permet de créer une nouvelle commande pour l'utilisateur connecté.
    GET /api/commandes/getcommandes : Renvoie la liste de toutes les commandes de l'utilisateur connecté.

## Diagramme de séquence 

![Diagramme](https://showme.redstarplugin.com/d/d:lcJ70blj)