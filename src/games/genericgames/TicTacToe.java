package games.genericgames;
import games.players.Player;
import java.util.ArrayList;
import java.util.List;
public class TicTacToe extends AbstractGame{
	Player[][] tab;
	
	public TicTacToe(Player j1 , Player j2){
		super(j1,j2);	
		this.tab = new Player [3][3];  //Initialisation de la table à 9 cases;
	}
	
 	@Override
	//coup = numéro de la case compris entre 0 et 8
 	public void doExecute(int coup){
		//on place le symbole du joueur actuel dans la case correspondante
		int row = coup/3;
		int col = coup%3;
 		this.tab[row][col] = super.joueurCourant;
 	}
 	
 	public boolean isValid(int coup){
		int row = coup/3;
		int col = coup%3;
		return !(row < 0 || row > 2 || col < 0 || col > 2 || this.tab[row][col] != null) ;
	}
 	//Prendre une case, appeler wins(), wins() vérifie si les 3 cases selon une orientation sont identiques, dans ce cas la méthode retourne vraie
 	public boolean wins(Player joueur , int row, int col, int deltaRow , int deltaColumn){
		int x2 = row + deltaRow ;
		int y2 = col + deltaColumn ;
		int x3 = row + 2*deltaRow ;
		int y3 = col + 2*deltaColumn ;
 		return (
			// Vérifier si les coordonnées sont valides(si la case existe) et de même symbol 
			joueur.equals(this.tab[row][col]) && 
			(x2 >= 0 && x2 <= 2 && y2 >= 0 && y2 <=2) && joueur.equals(this.tab[x2][y2]) && 
			(x3 >= 0 && x3 <= 2 && y3 >= 0 && y3 <=2) && joueur.equals(this.tab[x3][y3])
		) ;
	}		

 	public Player getWinner(){
		for( int i=0; i <= 2; i++){
			for( int j=0;j<= 2; j++){
				if(this.tab[i][j] != null){
					Player joueur = this.tab[i][j];
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
 		for(int i=0; i <= 2; i++){
			for(int j=0; j<= 2; j++){
				// Existe t-il une case nulle ?
				if(this.tab[i][j] == null){
					return false;//il reste des cases à jouer
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
				Player joueur=this.tab[i][j];
				chaine += " " +(joueur == null ? "." : joueur.equals(super.joueur1) ? "X": "O");
			}
			chaine += System.lineSeparator();
		}
		return chaine;
 	}

	public List<Integer> validMoves(){
		List<Integer> validMoves = new ArrayList<>();
		for(int i=0; i <= 2; i++){
			for(int j=0; j <=2; j++){
				int coup = i*3 + j;
				if(isValid(coup)){
					validMoves.add(coup);
				}
			}
		}
		return validMoves;
	}

	public String moveToString(int coup){
		int row = coup/3;
		int col = coup%3;
		return "Rangée : " + row + " ; " + "Colonne: " + col ;
	}

	// Cloner l'état actuel du jeu
	public Game copy(){
		String tab [][];
		TicTacToe copy = new TicTacToe(super.joueur1, super.joueur2);
		for(int i=0; i<=2; i++){
			for(int j=0; j<=2; j++){
				copy.tab[i][j] = this.tab[i][j];
			}
		}
		copy.joueurCourant = super.joueurCourant; 
		return copy;
	}
	
}
