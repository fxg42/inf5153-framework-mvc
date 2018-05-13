# Framework MVC 5153

## Dépendances

- JDK 10

## Compilation et démarrage

    ./gradlew run

Le serveur est ensuite accessible à l'adresse [http://localhost:5153](http://localhost:5153).

## Exercices

### 1. Router

Utilisez le patron de conception _Strategy_ pour implémenter un aiguilleur de
requêtes HTTP (un _Router_). Un router examine l'URL indiquée dans la requête
HTTP est assigne une classe en particulier pour traiter la requête et générer la
réponse.

Par exemple, un router pourrait examiner l'URL (p.e. "/bonjour") et déterminer
par cette chaîne de caractères le bon "RequestHandler" à appeler.

Une autre sorte de router pourrait utiliser un fichier de configuration
indiquant les url permises et le RequestHandler correspondant.
