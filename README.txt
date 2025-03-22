Groupe_cc_121

Groupe TP: 3B

Auteur: Zakiath TOUKOUROU

Numéro étudiant: 22412507

Le projet "Fil rouge" est désormais composé de trois versions des jeux, la version non factorisée (dans les packages games.nim et games.tictactoe), la version factorisée (dans le package games.factoredgames), et la version générique (dans le package games.genericgames).
Les packets nim, tictactoe, factoredgames et genericgames se trouvent dans le dossier "games" qui lui même est contenu dans le dossier "src".

        Mode d'emploi:
Avant de lancer les jeux, il faudra d'abord compiler les fichiers des jeux en exécutant les commandes: 
- factoredgames: "javac -d ../build -cp ../lib/gamestests.jar games/factoredgames/*.java" 

- genericgames: "javac -d ../build -cp ../lib/gamestests.jar games/genericgames/*.java games/players/*.java games/plays/*.java"

Pour lancer les jeux, il faudra exécuter les fichiers suivants:
- factoredgames: games/factoredgames/GamesNim.java
"java -cp ../build:../lib/gamestests.jar games.factoredgames.GamesNim".
- factoredgames: games/factoredgames/TicTacToeGames.java 
"java -cp ../build:../lib/gamestests.jar games.factoredgames.TicTacToeGames".
- factoredgames: games/factoredgames/TicTacToeWithHintsDemo.java (Exercice optionnel).
"java -cp ../build:../lib/gamestests.jar games.factoredgames.TicTacToeWithHintsDemo".

Afin que l'on puisse généraliser les jeux, de façon que l’on puisse écrire un seul « orchestrateur » pour
gérer la boucle de jeu d’une partie de jeu de Nim comme d’une partie de jeu du morpion, on va exécuter le fichier "PlaysDemo" qui se trouve dans le package games.genericgames 
- genericgames: games/genericgames/PlaysDemo
"java -cp ../build:../lib/gamestests.jar games.genericgames.PlaysDemo"

                                                                ******************
                Algorithme de Negamax
Compiler le fichier : "javac -d ../build -cp ../lib/gamestests.jar games/genericgames/*.java games/players/*.java games/plays/*.java"
Exécuter le fichier : "java -cp ../build:../lib/gamestests.jar games.genericgames.PlaysDemo"





