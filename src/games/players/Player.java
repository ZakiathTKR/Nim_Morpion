package games.players;
import games.genericgames.Game;
import games.players.Player;
//Demander un coup à un joueur
public interface Player {
   public int chooseMove(Game game);// Demende au joueur de jouer;
   public String toString(); // Retourne une représentation sous forme de chaîne de caractère du joueur;
}
