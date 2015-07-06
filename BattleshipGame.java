import java.util.*;
public class BattleshipGame {

  private GameHelper helper = new GameHelper();
  private ArrayList<Battleship> battleshipsList = new ArrayList<Battleship>();
  private int numOfGuesses = 0;

  private void setUpGame() {
    Battleship one = new Battleship();
    one.setName("Cruiser");
    Battleship two = new Battleship();
    two.setName("Destroyer");
    Battleship three = new Battleship();
    three.setName("Submarine");
    battleshipsList.add(one);
    battleshipsList.add(two);
    battleshipsList.add(three);

    System.out.println("Your goal is to sink three battleships.");
    System.out.println("Cruiser, Destroyer, and Submarine");
    System.out.println("Try to sink them all in the fewest numer of guesses");

    for (Battleship BattleshipToSet : battleshipsList) {
      ArrayList<String> newLocation = helper.placeBattleship(3);
      BattleshipToSet.setLocationCells(newLocation);
    }
  }

  private void startPlaying() {
    while(!battleshipsList.isEmpty()) {
      String userGuess = helper.getUserInput("Enter a guess");
      checkUserGuess(userGuess);
    }
    finishGame();
  }

  private void checkUserGuess(String userGuess) {
    numOfGuesses++;
    String result = "miss";

    for (Battleship battleshipToTest : battleshipsList) {
      result = battleshipToTest.checkYourself(userGuess);
      if (result.equals("hit")) {
        break;
      }
      if (result.equals("kill")) {
        battleshipsList.remove(battleshipToTest);
        break;
      }
    }
    System.out.println(result);
  }

  private void finishGame() {
    System.out.println("All battleships are dead! Clear seas ahead.");
    if (numOfGuesses <= 8) {
      System.out.println("It only took you " + numOfGuesses + " guesses.");
      System.out.println("Great job!");
    } else {
      System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
      System.out.println("Maybe try a little harder next time.");
    }
  }

  public static void main (String[] args) {
    BattleshipGame game = new BattleshipGame();
    game.setUpGame();
    game.startPlaying();
  }
}