package games.factoredgames;
public abstract class AbstractGame{
    protected String joueur1 , joueur2 , joueurCourant;

    public AbstractGame(String j1,String j2){
        this.joueur1 = j1;
        this.joueur2 = j2;
        this.joueurCourant = j1;
    }
    protected abstract void doExecute(int coup);

    public void execute(int coup){
        doExecute(coup);
        this.joueurCourant = this.joueurCourant.equals(this.joueur1) ? this.joueur2 : this.joueur1;
    }
    public String getCurrentPlayer(){
        return this.joueurCourant;
    }

}