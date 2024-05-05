package nz.ac.auckland.se281;

public class Hard implements Strategy {
  private int roundCount = 0;
  private Strategy currentStrategy = new Random();
  private int lastWinStrategy = 0;

  @Override
  public int chooseFinger(int round, int oddCount, int evenCount, String choiceString) {
    if (roundCount > 3) {
      if (lastWinStrategy == 0) {
        currentStrategy = new Top();
        lastWinStrategy = 1;
      } else {
        currentStrategy = new Random();
        lastWinStrategy = 0;
      }
    }
    return currentStrategy.chooseFinger(round, oddCount, evenCount, choiceString);
  }

  public void setLastWinStrategy(int winner) {
    this.lastWinStrategy = winner;
  }
}
