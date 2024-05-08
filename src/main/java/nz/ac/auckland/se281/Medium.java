package nz.ac.auckland.se281;

/**
 * This class contains logic for the Medium difficulty.
 */
public class Medium implements Strategy {
  private Strategy currentStrategy = new Random();

  /**
   * Bot chooses a finger to output depending on the round number and the users past inputs.
   *
   * @param round the current round number
   * @param oddCount the number of times the user inputted an odd number
   * @param evenCount the number of times the user inputted an even number
   * @param choiceString the string version of the users choice
   * @return an integer that the bot choses
   */
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
