package games.factoredgames;
import java.util.ArrayList;
public class TicTacToeWithHints extends TicTacToe{
	
    public TicTacToeWithHints(String j1 , String j2){
        super(j1,j2);
	}

    public ArrayList<Integer> hints(){
		//Creer une liste qui peut contenir des entiers en utilisant le constructeur par défaut de ArrayList qui initialaise une liste vide
        ArrayList <Integer> hints = new ArrayList<>();
        String joueur = getCurrentPlayer().equals(super.joueur1) ? super.joueur2 : super.joueur1;
		// Tester tous les coups possibles
        for(int i=0;i<=2;i++){
            for(int j=0;j<=2;j++){
                if(super.tab[i][j] == null){ // si la case est vide
 		            super.tab[i][j] = joueur; //simuler un coup de l'adversaire
					//if(getWinner())
					if(getWinner() != null){//vérifier si cela entraine une victoire){//vérifier si cela entraine une victoire
						hints.add(3 * i + j);//ajouter le coup sous forme d'entier
                	}
                	super.tab[i][j] = null;//Anuler le coups simulé
				}
            }
        }
        return hints;
    }

    @Override
    public String situationToString(){
 		String chaine = "  0 1 2\n";
        ArrayList<Integer> hints = hints();// Récupérer les hints pour le joueur courant
		System.out.println(hints);
		for(int i=0;i<=2;i++) {
			chaine += i;
			for(int j=0;j<=2;j++) {
				String joueur=super.tab[i][j];
            // Si la case contient un coup menant à la victoire, afficher "!"
				chaine += " " + (joueur == null ? 
				hints.contains(3 * i + j) ? "!" : "." : // si cela entraine une victoire "!" sinon "."
				joueur.equals(super.joueur1) ? "X": "O");  // si joueur différent de null "X" sinon "0"
					//chaine += " " +(hints.contains(3 * i + j) ? "!" : marker);//Vérifier si la case à la position (i, j) est une menace et convertir en entier.
				}
			chaine += System.lineSeparator();
		}
		return chaine;
 	}
}