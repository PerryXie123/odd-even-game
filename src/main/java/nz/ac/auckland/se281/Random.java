package nz.ac.auckland.se281;

/** This class contains logic for choosing a random number between 0 and 5. */
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
    // Returns a random number
    return Utils.getRandomNumberRange(0, 5);
  }
}
