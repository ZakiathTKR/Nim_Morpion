package games.players;
import games.genericgames.Game;
import java.util.Scanner;
import java.util.List;
public class Human implements Player{
    private String name;
    private Scanner scanner;
    
    public Human(String name, Scanner scanner ) {
        this.name = name;
        this.scanner = scanner;
    }

@Override
    public int chooseMove(Game game){
        List<Integer> validMoves = game.validMoves(); // Récupère les coups valides
        System.out.println("Coups valides: " + validMoves); 
        int coup;
        while(true){
            System.out.println("Quel est votre coup ?");
            coup = scanner.nextInt();
            if (validMoves.contains(coup)){
                break;
            } else{
                System.out.println("Coup invalide. Veuillez saisir un coup valide ");
            }
        
        }
        return coup;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
        
}