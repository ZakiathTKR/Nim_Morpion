package games.players;
import games.genericgames.Game;
public class NegamaxPlayer implements Player {

    public NegamaxPlayer(){

    }

    public int evaluate(Game game){
        if(game.isOver()){
            if(game.getWinner() == game.getCurrentPlayer() && game.getWinner() != null){
                return 1;
                } else if(game.getWinner() != game.getCurrentPlayer() && game.getWinner() != null){
                    return -1;
                } else if (game.getWinner() == null){
                    return 0;
                }
            }
        Integer res = null;
        for(int coup : game.validMoves()){
            Game copy = game.copy();
            copy.execute(coup);
            int v = - evaluate(copy);
            if(res == null || v > res){
                res = v;
            }
        }
        return res;
    }
    @Override
    public int chooseMove(Game game){
        return negamax(game);
    }
    private int negamax(Game game){
        Integer meilleurValeur = null;
        Integer meilleurCoup = null ;
        for(int coup : game.validMoves()){
            Game copy = game.copy();
            copy.execute(coup);
            int v = - evaluate(copy);
            if(meilleurCoup == null || v > meilleurValeur){
                meilleurValeur = v;
                meilleurCoup = coup;
            }
        }
        return meilleurCoup;
    }

}
