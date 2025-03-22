package games.genericgames;
import games.players.Player;
import games.players.Player;
import java.util.List;
// Déclaration des méthodes utiles
public interface Game {
    Player getCurrentPlayer();
	boolean isValid(int coup);
    void execute(int coup);
	boolean isOver ();
 	Player getWinner();
    List<Integer> validMoves();// contient la liste de tous les coups valides possibles à ce moment dans la partie.
	String moveToString(int coup);//convertir un coup donné en une chaîne de caractère lisible pour un humain
	String situationToString();//representation de la situation actuelle du jeu.
	Game copy();// crée et retourne une copie exacte de l'état actuelle.
}
