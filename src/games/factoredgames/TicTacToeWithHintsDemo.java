package games.factoredgames;
import java.util.Scanner;
public class TicTacToeWithHintsDemo {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("BIENVENU AU JEU DE MORPION");
        System.out.println("Nom du joueur 1:");
		String joueur1 = scanner.nextLine();
		System.out.println("Nom du joueur 2:");
		String joueur2 = scanner.nextLine();
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
        TicTacToe game; // mécanisme de polymorphisme(game est un objet de type TicTacToe/TicTacToeWithHints)
        if (answer.equals("oui")) {
            game = new TicTacToeWithHints(joueur1 , joueur2);
        } else {
            game = new TicTacToe(joueur1 , joueur2);
        }
        while(!game.isOver()){
		    System.out.println(game.situationToString());
            System.out.println("C'est à " + game.getCurrentPlayer() +" de jouer:");
			System.out.println("Votre coup:");
			System.out.println("Rangée ?");
			int row = scanner.nextInt();
			System.out.println("Colonne ?");
			int col = scanner.nextInt();
			if(game.isValid(3*row+ col)){
				game.execute(3*row + col);
			}else {
				System.out.println("Le coup est invalide");
			}
        }
    //afficher le résultat final
        System.out.println(game.situationToString());
        String winner = game.getWinner();
		if(winner != null){
			System.out.println("La partie est terminée, le gagnant est: " + winner);
		}else {
			System.out.println("Match nul.");
		}
        scanner.close();
    }
}
