package nz.ac.auckland.se281;

public class Medium implements Strategy {
  private int roundCount = 0;
  private Strategy currentStrategy = new Random();

  @Override
  public int chooseFinger(int round) {
    if (roundCount > 3) {
      currentStrategy = new Top();
    }
    return currentStrategy.chooseFinger(round);
  }
}
