package games.genericgames;
import java.util.Random;
import games.players.Player;
import games.plays.Orchestrator;
import games.players.Human;
import games.players.RandomPlayer;
import games.players.NegamaxPlayer;
import java.util.Scanner;
public class PlaysDemo {
    public static void main(String[]args){
        Player player1 = null;
        Player player2 = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("BIENVENU AU JEU DE MORPION");
        System.out.println("Choisissez un type de joueur1: \n 1-Humain \n 2-Joueur Aléatoire \n 3-Joueur Negamax");
        String typePlayer1 = "";
        while (!(typePlayer1.equals("1") || typePlayer1.equals("2") || typePlayer1.equals("3"))) {
            typePlayer1 = scanner.nextLine();
            if(!(typePlayer1.equals("1") || typePlayer1.equals("2") || typePlayer1.equals("3"))){
                System.out.println("Type invalide. Veuillez entrer 1 pour Humain ou 2 pour Joueur Aléatoire ou 3 pour un Joueur Negamax.");
            }
        }

        switch (typePlayer1){
            case "1": 
                System.out.println("Nom du joueur 1:");
		        String joueur1 = scanner.nextLine();
                player1 = new Human(joueur1, scanner);
                break;
            case "2" : 
                Random random = new Random(1);
                player1 = new RandomPlayer(random);
                break;
            case "3" :
                player1 = new NegamaxPlayer();
                break;
            default :
                System.exit(1);
        }

        System.out.println("Choisissez un type de joueur2: \n 1-Humain \n 2-Joueur Aléatoire \n 3-Joueur Negamax");
        String typePlayer2 = "";
        while (!(typePlayer2.equals("1") || typePlayer2.equals("2") || typePlayer2.equals("3"))) {
            typePlayer2 = scanner.nextLine();
            if(!(typePlayer2.equals("1") || typePlayer2.equals("2") || typePlayer2.equals("3"))){
                System.out.println("Type invalide. Veuillez entrer 1 pour Humain ou 2 pour Joueur Aléatoire ou 3 pour un Joueur Negamax.");
            }
        }
        switch (typePlayer2){
            case "1": 
                System.out.println("Nom du joueur 2:");
                String joueur2 = scanner.nextLine();
                player2 = new Human(joueur2, scanner);
                break;
            case "2" : 
                Random random = new Random(1);
                player2 = new RandomPlayer(random);
                break;
            case "3" :
                player2 = new NegamaxPlayer();
                break;
            default :
                System.exit(1);
            }
        
        System.out.println(" Choisissez un jeu: \n 1- Nim \n 2- Tictactoe");
        String typeGame = scanner.nextLine();
        Game game = null;
        switch (typeGame){
            case "1":
                System.out.println("Vous avez décidez de jouer au jeu de Nim");
                System.out.println ("Taille initiale du tas :");
                int n=-1;
                while(n < 0){
                    n = scanner.nextInt();
                    if(n<0){
                        System.out.println ("Nombre invalide.\nVeuillez entrer un nombre positif  : ");
                    }
                }
                System.out.println ("Nombre maximal d'allumettes qu'un joueur peut retirer : ");
                int k = -1;
                while(k <= 0){
                    k = scanner.nextInt();
                    if(k<=0){
                        System.out.println ("Nombre invalide.\nVeuillez entrer un nombre strictement positif  : ");
                    }
                }

                game = new Nim(n,k,player1, player2);

                break;

            case "2":
                System.out.println("Vous avez décidez de jouer au jeu de Tictactoe");
                game = new TicTacToe (player1, player2);

                String answer = ""; // vide
                System.out.println("Voulez-vous jouer avec des indices ? (oui/non)");
                while (!(answer.equals("oui") || answer.equals("non"))) {
                    answer = scanner.nextLine().trim().toLowerCase();//ignore les espaces et les majuscules ou miniscules

                    if (!(answer.equals("oui") || answer.equals("non"))) {
                        System.out.println("Réponse invalide. Veuillez entrer 'oui' ou 'non': ");
                    }
                }
                if (answer.equals("oui")) {
                    System.out.println("Vous avez choisi de jouer avec des indices.");
                } else {
                    System.out.println("Vous avez choisi de ne pas jouer avec des indices.");
                }

                if (answer.equals("oui")) {
                    game = new TicTacToeWithHints(player1 , player2);
                } else {
                    game = new TicTacToe(player1 , player2);
                }
                break;
            default:
                System.exit(1);
        }
        Orchestrator orchestrator = new Orchestrator(game);
        orchestrator.play();
        scanner.close();
}
}  
        

       