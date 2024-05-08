package nz.ac.auckland.se281;

/** This interface sets the needed methods for all implemented classes. */
public interface Strategy {
  /**
   * Bot chooses a finger to output depending on the user choices.
   *
   *
   * @param round the current round number
   * @param oddCount the number of times the user inputted an odd number
   * @param evenCount the number of times the user inputted an even number
   * @param choiceString the string version of the users choice
   * @return an integer that the bot choses
   */
  public int chooseFinger(int round, int oddCount, int evenCount, String choiceString);
}
