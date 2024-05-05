package nz.ac.auckland.se281;

public class Top implements Strategy {

  @Override
  public int chooseFinger(int round) {
    if (Game.oddCount == Game.evenCount) {
      return Utils.getRandomNumberRange(0, 5);
    } else if (Game.oddCount > Game.evenCount) {
      if (Game.choiceString.equals("ODD")) {
        return Utils.getRandomOddNumber();
      } else {
        return Utils.getRandomEvenNumber();
      }
    } else {
      if (Game.choiceString.equals("ODD")) {
        return Utils.getRandomEvenNumber();
      } else {
        return Utils.getRandomOddNumber();
      }
    }
  }
}
