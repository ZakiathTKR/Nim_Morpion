package games.tictactoe;

public class TicTacToe {
	protected String joueur1 , joueur2 , joueurCourant ;
	String[][] tab;
	
	public TicTacToe(String j1 , String j2){
		this.joueur1 = j1;
		this.joueur2 = j2;	
		this.joueurCourant = j1;
		this.tab = new String [3][3] ;
	}
	
  	public String getCurrentPlayer(){
 		return this.joueurCourant ;
 	}
 	
 	public void execute(int row,int col){
		//afficher le joueurCourant et non "X" ou "0"
 		this.tab[row][col] = this.joueurCourant;
 		this.joueurCourant = (this.joueurCourant.equals(this.joueur1)) ? this.joueur2 : this.joueur1;
 	}
 	
 	public boolean isValid(int row , int col){
		//Priorité des opérateurs
 		return !(row < 0 || row > 2 || col < 0 || col > 2 || this.tab[row][col] != null) ;
 	}
 	//Prendre une case, appeler wins(), wins() vérifie si les 3 cases selon une orientation sont identiques, dans ce cas la méthode retourne vraie
 	public boolean wins(String joueur , int row , int col , int deltaRow , int deltaColumn){
		int x2 = row + deltaRow ;
		int y2 = col + deltaColumn ;
		int x3 = row + 2*deltaRow ;
		int y3 = col + 2*deltaColumn ;
		// Vérifier si les coordonnées sont valides(si la case existe) et de même symbol 
 		return (
			joueur.equals(this.tab[row][col]) &&
			(x2 >= 0 && x2 <= 2 && y2 >= 0 && y2 <=2) && joueur.equals(this.tab[x2][y2]) && 
			(x3 >= 0 && x3 <= 2 && y3 >= 0 && y3 <=2) && joueur.equals(this.tab[x3][y3])
		) ;
	}		

 	public String getWinner(){
		for(int i=0;i<=2;i++){
			for(int j=0;j<=2;j++){
				String joueur = this.tab[i][j];
				if(this.tab[i][j] != null){
					if(
						wins(joueur,i,j,0,1) || // Horizontale
						wins(joueur,i,j,1,0) || // Verticale
						wins(joueur,i,j,1,1) || // Diagonale vers la droite
						wins(joueur,i,j,1,-1) // Diagonale vers la gauche
					){
						return joueur;
					}
				}
				
			}
		}
 		return null ;
 	}
 	
 	public boolean isOver (){
		if(getWinner() != null){
			return true ;
		}
 		for(int i=0;i<=2;i++){
			for(int j=0;j<=2;j++){
				// Existe t-il une case nulle ?
				if(this.tab[i][j] == null){
					return false;
				}
			}
		}
		return true ;//match nul		
	}
 	
 	public String situationToString(){
 		String chaine = "  0 1 2\n";
		for(int i=0;i<=2;i++) {
			chaine += i;
			for(int j=0;j<=2;j++) {
				String joueur = this.tab[i][j];
				chaine += " " +(joueur == null ? "." : joueur.equals(this.joueur1) ? "X": "O");
			}
			chaine += System.lineSeparator();
		}
		return chaine;
 	}
	
}