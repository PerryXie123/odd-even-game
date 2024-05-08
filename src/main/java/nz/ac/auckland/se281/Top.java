package nz.ac.auckland.se281;

/**
 * This class contains logic for which chooses a number between 0 and 5 based on the users past
 * inputs.
 */
public class Top implements Strategy {

  /**
   * Bot chooses a finger depending on what the user has inputted in the past.
   *
   * @param round the current round number
   * @param oddCount the number of times the user inputted an odd number
   * @param evenCount the number of times the user inputted an even number
   * @param choiceString the string version of the users choice
   * @return an integer that the bot choses
   */
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
