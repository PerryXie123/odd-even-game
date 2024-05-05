package nz.ac.auckland.se281;

public class Random implements Strategy {

  @Override
  public int chooseFinger(int round, int oddCount, int evenCount, String choiceString) {
    return Utils.getRandomNumberRange(0, 5);
  }
}
