package games.plays;
import games.genericgames.Game;
import games.players.Player;
import games.players.RandomPlayer;
public class Orchestrator {
    private Game game;

    public Orchestrator(Game game){
        this.game = game;
    }

    public void play(){
        while(!game.isOver()){
            System.out.println(game.situationToString());
            System.out.println("C'est au tour de: " + game.getCurrentPlayer());
            int coup = game.getCurrentPlayer().chooseMove(game);
            if(game.isValid(coup)){
                game.execute(coup);
            }else {
                System.out.println("Coup invalide. Essayer encore.");
            }
        }
        // partie est terminée, afficher le résultat
         System.out.println("La partie est terminée !");
        if (game.getWinner() != null) {
            System.out.println("Le gagnant est : " + game.getWinner());
        } else {
            System.out.println("Match nul !");
        }
    }
}