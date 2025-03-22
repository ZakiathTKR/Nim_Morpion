package games.nim;
import java.util.Scanner ;

public class GamesNim {

	public static void main (String[] args){
        System.out.println ("BIENVENU AU JEU DE NIM");
        Scanner scanner = new Scanner(System.in);
        System.out.println ("Nom du joueur 1 :");
        String joueur1 = scanner.next();
        System.out.println ("Nom du joueur 2 :");
        String joueur2 = scanner.next();
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
  
        Nim game = new Nim(n , k , joueur1 , joueur2);
  
        while (!game.isOver()){
            System.out.println(game.situationToString());
            System.out.print(game.getCurrentPlayer() + ", combien d'allumettes voulez vous retirez ? ");
            int nbreAllumettes = Integer.parseInt(scanner.next());
 	        if (game.isValid(nbreAllumettes)) {
                game.removeMatches(nbreAllumettes);
            } else {
                System.out.println("Coup invalide, réessayez.");
            }
        }
        System.out.println("La partie est terminée. Le gagnant est : " + game.getWinner());
        scanner.close();

    }
}
