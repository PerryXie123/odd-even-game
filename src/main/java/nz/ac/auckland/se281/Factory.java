package nz.ac.auckland.se281;

/** This factory interface sets the scene for factory classes. */
public interface Factory {
  /**
   * This method builds a strategy based on the users chosen difficulty.
   *
   * @param difficulty the chosen difficulty
   * @return the strategy which should be initialised
   */
  public Strategy getStrategy(Main.Difficulty difficulty);
}
