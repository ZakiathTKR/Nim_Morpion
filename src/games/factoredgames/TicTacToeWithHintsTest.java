package games.factoredgames;
import gamestests.factoredgames.TicTacToeWithHintsTests;
public class TicTacToeWithHintsTest {
    public static void main (String[] args){
boolean ok = true;
TicTacToeWithHintsTests tester = new TicTacToeWithHintsTests();
ok = ok && tester.testGetCurrentPlayer();
ok = ok && tester.testExecuteAndIsValid();
ok = ok && tester.testWins(); // si wins() est implementee
ok = ok && tester.testGetWinner();
ok = ok && tester.testIsOver();
ok = ok && tester.testHints();
System.out.println(ok ? "All tests OK" : "At least one test KO");
}
}
