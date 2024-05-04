package nz.ac.auckland.se281;

public class Easy implements Strategy {

  @Override
  public int chooseFinger() {
    return Utils.getRandomNumberRange(0, 5);
  }
}
