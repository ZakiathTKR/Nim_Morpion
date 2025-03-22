package games.genericgames;
import games.players.Player;
import java.util.ArrayList;
import java.util.List;
public class Nim extends AbstractGame {
	protected int n , k , nbreCourant ;

	public Nim (int n , int k , Player j1 , Player j2) {
		super(j1,j2);
		this.n = n;
		this.k = k;
		this.nbreCourant = n;
	}

	public int getInitialNbMatches(){
		return this.n ;
	}

	public int getCurrentNbMatches(){
		return this.nbreCourant ;
	}
	public String situationToString() {
	 	return ("Il reste "+ this.nbreCourant  + " allumette(s)");	 
	}
	@Override
	//coup = retirer un certains nbres d'allumettes
	public void doExecute(int coup){ 
		this.nbreCourant -= coup ;
	}
	public boolean isValid(int coup){
		return coup > 0 && coup <= k && coup <= this.nbreCourant ;
	}
	
	public boolean isOver() {
		return nbreCourant == 0;
	}
	
	public Player getWinner() {
		Player joueurCourant = getCurrentPlayer();
		return isOver() ? joueurCourant : null;		
	}

	//Liste de nombres d'allumettes que l'on peut retirer qui dépend de k et de nbreCourant.	
	public List<Integer> validMoves(){
		List<Integer> validMoves = new ArrayList<>();
		for(int i=1; i <= k && i <= nbreCourant; i++){
			validMoves.add(i);
		}
		return validMoves;
	}

	// nombres d'allumettes retiré(s)
	public String moveToString(int coup){
		return "Retirer" + coup + "allumette(s)";
	}

	// Cloner l'état actuel du jeu
	public Game copy(){
		Nim copy = new Nim(this.n, this.k, super.joueur1, super.joueur2);
		copy.nbreCourant = this.nbreCourant;
		copy.joueurCourant = super.joueurCourant;
		return copy;
	}

}
