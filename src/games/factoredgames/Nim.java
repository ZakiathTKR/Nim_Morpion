package games.factoredgames;
 
public class Nim extends AbstractGame{
	protected int n , k , nbreCourant ;

	public Nim (int n , int k , String j1 , String j2) {
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
	
	public String getWinner() {
		joueurCourant = getCurrentPlayer();
		return isOver() ? joueurCourant : null;		
	}	
}
