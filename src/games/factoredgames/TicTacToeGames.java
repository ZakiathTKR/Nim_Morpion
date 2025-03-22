package games.factoredgames;
import java.util.Scanner;
public class TicTacToeGames {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("BIENVENU AU JEU DE MORPION");
		System.out.println("Nom du joueur 1:");
		String joueur1 = scanner.next();
		System.out.println("Nom du joueur 2:");
		String joueur2 = scanner.next();
		
		TicTacToe game = new TicTacToe(joueur1 ,joueur2);
		while(!game.isOver()){
			System.out.println(game.situationToString());
			System.out.println("C'est à " + game.getCurrentPlayer() +" de jouer:");
			System.out.println("Votre coup:");
			System.out.println("Rangée ?");
			int row = scanner.nextInt();
			System.out.println("Colonne ?");
			int col = scanner.nextInt();
			if(game.isValid(3*row + col)){
				game.execute(3*row+col);
			}
			else {
				System.out.println("Le coup est invalide");
			}
			
		}
		// Je dois mettre une condition pour montrer que soit il y a un gagnant, soit il y a eu un match nul
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
