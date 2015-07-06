public class BattleshipTestDrive {
  public static void main (String[] args) {
    Battleship cruiser = new Battleship();

    int[] locations = {2, 3, 4};
    cruiser.setLocationCells(locations);

    String userGuess = "2";
    String result = cruiser.checkYourself(userGuess);
  }
}