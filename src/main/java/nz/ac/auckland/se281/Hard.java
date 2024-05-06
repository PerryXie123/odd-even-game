package nz.ac.auckland.se281;

public class Hard implements Strategy {
  private Strategy currentStrategy = new Random();
  private int lastWinStrategy = 0;

  /**
   * Bot chooses a finger to output depending on the round number, past round outcomes, and the users past inputs.
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
      if (lastWinStrategy == 0) {
        currentStrategy = new Top();
        lastWinStrategy = 1;
      } else {
        currentStrategy = new Random();
        lastWinStrategy = 0;
      }
    }
    return currentStrategy.chooseFinger(round, oddCount, evenCount, choiceString);
  }

  /**
   * Setter function for the strategy picked.
   * 
   * @param winner integer corresponding to a win or a loss
   */
  public void setLastWinStrategy(int winner) {
    this.lastWinStrategy = winner;
  }
}
