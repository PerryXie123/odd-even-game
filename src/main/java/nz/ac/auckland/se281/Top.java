package nz.ac.auckland.se281;

public class Top implements Strategy {

  @Override
  public int chooseFinger(int round, int oddCount, int evenCount, String choiceString) {
    if (oddCount == evenCount) {
      return Utils.getRandomNumberRange(0, 5);
    } else if (oddCount > evenCount) {
      if (choiceString.equals("ODD")) {
        return Utils.getRandomOddNumber();
      } else {
        return Utils.getRandomEvenNumber();
      }
    } else {
      if (choiceString.equals("ODD")) {
        return Utils.getRandomEvenNumber();
      } else {
        return Utils.getRandomOddNumber();
      }
    }
  }
}
