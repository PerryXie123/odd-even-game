package nz.ac.auckland.se281;

public class Random implements Strategy {

  /**
   * Bot chooses a random finger to output.
   *
   * @param round the current round number
   * @param oddCount the number of times the user inputted an odd number
   * @param evenCount the number of times the user inputted an even number
   * @param choiceString the string version of the users choice
   * @return an integer that the bot choses
   */
  @Override
  public int chooseFinger(int round, int oddCount, int evenCount, String choiceString) {
    return Utils.getRandomNumberRange(0, 5);
  }
}
