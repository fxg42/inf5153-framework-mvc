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

### 2. Parser

Utilisez le patron de conception _State_ pour complémenter l'interpréteur de
requêtes HTTP.

Actuellement, le parser n'interprête que la première ligne des requêtes HTTP
reçues par le système. Une requête HTTP est définie selon le [standard RF2616](https://www.w3.org/Protocols/rfc2616/rfc2616-sec5.html).

        Request       = Request-Line
                        *(( general-header
                         | request-header
                         | entity-header ) CRLF)
                        CRLF
                        [ message-body ]

Vous devez écrire un interpréteur de requête HTTP qui capture:

- Les informations de la première ligne (_Request-Line_)
- S'ils sont présents, tous les _headers_
- S'il est présent, le corps de la requête (_message-body_)
