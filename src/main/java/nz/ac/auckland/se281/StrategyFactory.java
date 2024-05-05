package nz.ac.auckland.se281;

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
