# projet - Chris Tramier

Mon projet compile et fonctionne. Je n'ai pas repéré de bugs.

J'ai implémenté une fonctionnalité en trop que j'ai laissé en argument. On peut donc lancer mon .jar de 3 façons :

* Sans arguments, on va chercher une table prédéfinie dans les *resources* 

* Avec l'argument *"Random"*, on init une table jouable aléatoire.

* On peut également fournir un chemin vers une table de Sudoku

Le projet peut se lancer avec *mvn exec:java -Dexec.args="arg0 arg1"*. On peut créer un .jar avec *mvn package* et le compiler avec *java -jar*

Par défaut j'ai laissé dans le pom.xml du Main un exclude qui évite de lancer les 3 tests qui lancent le sudoku à chaque fois, afin de ne pas avoir à fermer le jeu 3 fois quand on fait tous les tests (car je considère que le test doit fonctionner même sans la fonction quit, donc je ne l'appelle pas). 




# Sudoku
Le but de ce projet est de développer un jeu de Sudoku en mode texte, en utilisant Maven, GIT et JUnit.

## GIT
Toute la gestion du code source se fait à travers GIT, en utilisant le dépot associé
à la classroom GitHub. Les commits doivent se faire régulièrement et contenir un
message de commit pertinent.

### Branches
Le rendu final devra avoir au moins 3 branches. Attention à bien respecter le nom et la casse.
* _master_ qui contient la version finale du logiciel
* _bug_ qui contient une version où une grosse partie des tests unitaires échoue
* _dev_ qui contient des fonctionnalités expérimentales (voir après)

## Maven
Le logiciel sera composé de 3 modules au minimum
* IO : entrées-sorties sur le disque
* GUI : entrées-sorties sur l'écran
* Main : application
Le projet devra être exécuté depuis Maven et il pourra être packagé sous forme de jar exécutable de nom _sudokuV1.jar_. Ce jar pourra prendre comme paramêtre
un chemin vers un fichier contenant la grille. Si aucun paramêtre, il chargera une grille depuis _resources_.

## Tests Unitaires
Toutes les classes méthodes devront être testées avec JUnit.

## Fonctionnalités attendues
### Branche _master_
La grille de Sudoku est de taille 9x9 et chaque case peut contenir un chiffre entre 1 et 9. Elle est subdivisée et 9 zones de taille
3x3. Le but est d'avoir dans chaque zone, sur chaque ligne et chaque colonne chaque chiffre une unique fois.
* L'affichage de la grille se fait en mode texte en utilisant une bibliothèque comme Java ASCII Render. Après chaque coup la grille peut être complètement affichée de nouveau.
* Le joueur indique par 3 chiffres sans espaces le coup à jouer. Par exemple _123_ indique la ligne 1, la colonne 2, et mettre la valeur 3. Les lignes sont numérotées de haut en bas. 
* Chaque fois qu'un nombre est proposé, il est vérifié et le logiciel affiche un message si il est incorrect.
* Une grille peut être spécifiée sous forme de fichier texte. Une ligne de texte par ligne de la grille. Une case sans valeur sera représentée par '\_'
* Une grille peut être sauvegardée sous forme de fichier texte en tapant _save nom_ plutôt qu'un nombre et chargée en tapant _load nom_.

### Branche _dev_
Dans cette branche se trouvera une version du jeu permettant de revenir en arrière. Il devra être possible d'annuler les coups avec la commande 'b' (back). Chaque commande  annulera le dernier coup joué. Tous les coups joués depuis le début de la partie devront pouvoir être annulés.
