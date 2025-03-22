package games.players;
import games.genericgames.Game;
import java.util.Random;
import java.util.List;
public class RandomPlayer implements Player{
    private Random rand;

    public RandomPlayer(Random rand){
        this.rand = rand;
    }

    @Override
    public int chooseMove(Game game){
        List<Integer> validMoves = game.validMoves();
        int n = rand.nextInt(validMoves.size()); //génère un index aléatoire dans la plage [0, validMoves.size()[ qui est stocké dans la variable "n"
        return validMoves.get(n); //retourne l'élément de la liste à l'index spécifié.
    }

    @Override
    public String toString(){
        return "Joueur aléatoire n° " + this.hashCode(); // distinguer plusieurs joueurs aléatoires.
    }

}