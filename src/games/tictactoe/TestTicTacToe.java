package games.tictactoe;
import gamestests.tictactoe.TicTacToeTests;

public class TestTicTacToe { 
    public static void main(String[] args){
        boolean ok = true;
        TicTacToeTests ticTacToeTester=new TicTacToeTests();
        ok = ok && ticTacToeTester.testGetCurrentPlayer();
        ok = ok && ticTacToeTester.testExecuteAndIsValid();
        ok = ok && ticTacToeTester.testGetWinner();
        ok = ok && ticTacToeTester.testIsOver();
        System.out.println(ok ? "All tests OK" : "At least one test KO");
    }
}

