package nz.ac.auckland.se281;

/**
 * This class contains logic to create new Easy, Medium, and Hard difficulties based on the user
 * inputs.
 */
public class StrategyFactory {
  public Strategy getStrategy(Main.Difficulty difficulty) {
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
