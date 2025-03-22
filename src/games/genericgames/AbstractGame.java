package games.genericgames;
import games.players.Player;
import java.util.List;
public abstract class AbstractGame implements Game {
    protected Player joueur1 , joueur2 , joueurCourant;

    public AbstractGame(Player j1,Player j2){
        this.joueur1 = j1;
        this.joueur2 = j2;
        this.joueurCourant = j1;
    }

     @Override
    public Player getCurrentPlayer(){
        return this.joueurCourant;
    }

     @Override
    public abstract boolean isValid(int coup);

    protected abstract void doExecute(int coup);

    @Override
    public void execute(int coup){
        doExecute(coup);
        this.joueurCourant = this.joueurCourant.equals(this.joueur1) ? this.joueur2 : this.joueur1;
    }

}