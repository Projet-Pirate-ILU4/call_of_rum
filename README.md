# Équipe

NDOYE Assane - Chef de Projet et Responsable Tests Fonctionnels

RICHARD Jérémy - Responsable Développement Noyau

JOSEPH Wilken McJ - Responsable Spécifications

IVANOVA Alina - Responsable Modélisation

FRANCES-GENTILLET Solène - Responsable IHM

LAFORGE Matéo - Responsable Technique

# Indications aux professeurs

### Lambdas

Nous avons une utilisation assez conséquente des Supplier dans la [frontière console](https://github.com/Projet-Pirate-ILU4/call_of_rum/blob/main/src/main/java/fr/call_of_rum/boundary/ConsoleBoundary.java).
Elle nous as permis de créer une fonction `askQuestion()` générale car c'était une partie du code qui était beaucoup de fois répétée.

Une autre utilisation a été utile dans [`Inventory`](https://github.com/Projet-Pirate-ILU4/call_of_rum/blob/main/src/main/java/fr/call_of_rum/model/inventory/Inventory.java#L20) pour pouvoir représenter l'utilisation, soit de `==` si l'on compare 1 objet null, et `.equals()` sinon.

Enfin, une dernière utilisation à été utile pour les fournisseurs d'objet (encore des Supplier) dans l'implémentation du [registre dynamique d'objets](https://github.com/Projet-Pirate-ILU4/call_of_rum/blob/main/src/main/java/fr/call_of_rum/model/item/ItemRegistry.java) et dans celle du [marchet et de son `ItemStock`](https://github.com/Projet-Pirate-ILU4/call_of_rum/blob/main/src/main/java/fr/call_of_rum/model/market/ItemStock.java) avec comme implémentation détaillée [`LimitedSupplier`](https://github.com/Projet-Pirate-ILU4/call_of_rum/blob/main/src/main/java/fr/call_of_rum/util/LimitedSupplier.java).
Cette première a permis d'utiliser des constructeur de façon dynamique, fournissant une instance d'objet `Item` quelconque.
Et Cette dernière a permis de déplacer les conditions permettant, ou pas, à un marchand de vendre un objet précis, dans une classe à part (dans `LimitedSupplier` on a décidé de mimer un stock limité d'objet).

# Comment utiliser Gradle

Que ce soit sur Eclipse ou IntelliJ vous devrez importer le projet en tant que projet Gradle

Une fois cela fait vous devrez trouver la fenêtre des tâches Gradle

![Eclipse](https://github.com/Projet-Pirate-ILU4/call_of_rum/assets/90221120/28e365cb-8bbb-46d1-8c3d-383f30038145)
![IntelliJ](https://github.com/Projet-Pirate-ILU4/call_of_rum/assets/90221120/c29cfcff-5a9a-4121-ad9d-2916a2083c72)

En tant que développeur vous pourrez utiliser la tâche `application/run` qui compile et exécute la classe Main,
ainsi que la tâche `build/build` pour compiler, check et importer les éventuelles dépendances du projet.

# Versions de Java sur Apache NetBeans

Si vous rencontrez des problèmes pour importer le projet sur NetBeans, veuillez suivre ces consignes:

1. Vérifiez que vous êtes bien sur la branche `gui`
2. Définissez explicitement le JDK utilisé par NetBeans:
    1. Dans les propriétés du projet cherchez un onglet `Gradle Execution`
    2. Sélectionnez le JDK 17 dans la liste déroulante.
    Si il n'est pas disponible, dans `Manage Runtimes`, ajoutez une nouvelle plateforme avec le dossier d'installation du jdk 17 (sur Windows: `C:\Program Files\Java\jdk-17`)
3. Si le problème persiste contactez le Responsable Technique ou soumettez une Issue
