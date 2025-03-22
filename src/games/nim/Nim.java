package games.nim;
 
public class Nim {
	private int n , k , nbreCourant ;
	private String joueur1 , joueur2 , joueurCourant ;

	public Nim (int n , int k , String j1 , String j2) {
		this.n = n;
		this.k = k;
		this.joueur1 = j1;
		this.joueur2 = j2;
		this.nbreCourant = n;
		this.joueurCourant = j1; 
	}

	public int getInitialNbMatches(){
		return this.n ;
	}

	public int getCurrentNbMatches(){
		return this.nbreCourant ;
	}

	public String getCurrentPlayer() {
		return this.joueurCourant;
	}

	public String situationToString() {
	 	return ("Il reste "+ this.nbreCourant  + " allumette(s)");	 
	}
	
	public void removeMatches(int nbreAllumettes){
		this.nbreCourant -= nbreAllumettes ;
		this.joueurCourant = this.joueurCourant.equals(this.joueur1) ? this.joueur2 : this.joueur1;																										
	}

	public boolean isValid(int nbreAllumettes){
		return nbreAllumettes > 0 && nbreAllumettes <= k && nbreAllumettes <= this.nbreCourant ;
	}
	
	public boolean isOver() {
		return nbreCourant == 0;
	}
	
	public String getWinner() {
		return isOver() ? this.joueurCourant : null;		
	}	
}
