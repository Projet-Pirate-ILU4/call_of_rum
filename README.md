# Équipe

NDOYE Assane - Chef de Projet et Responsable Tests Fonctionnels

RICHARD Jérémy - Responsable Développement Noyau

JOSEPH Wilkens McJ - Responsable Spécifications

IVANOVA Alina - Responsable Modélisation

FRANCES-GENTILLET Solène - Responsable IHM

LAFORGE Matéo - Responsable Technique

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
