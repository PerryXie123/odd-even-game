package nz.ac.auckland.se281;

public class Medium implements Strategy {
  private Strategy currentStrategy = new Random();

  @Override
  public int chooseFinger(int round, int oddCount, int evenCount, String choiceString) {
    if (round > 3) {
      currentStrategy = new Top();
    } else {
      currentStrategy = new Random();
    }
    return currentStrategy.chooseFinger(round, oddCount, evenCount, choiceString);
  }
}
