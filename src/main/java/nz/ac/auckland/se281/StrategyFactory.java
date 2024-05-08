package nz.ac.auckland.se281;

/**
 * This class contains logic to create new Easy, Medium, and Hard difficulties based on the user
 * inputs.
 */
public class StrategyFactory {
  /**
   * This method builds a strategy based on the users chosen difficulty.
   *
   * @param difficulty the chosen difficulty
   * @return the strategy which should be initialised
   */
  public Strategy getStrategy(Main.Difficulty difficulty) {
    // Switch case for all different types of difficulties
    switch (difficulty) {
      case EASY:
        return new Random();
      case MEDIUM:
        return new Medium();
      case HARD:
        return new Hard();
      default:
        return null;
    }
  }
}
