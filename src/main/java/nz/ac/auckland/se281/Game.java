package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  public int gameNumber = 0;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    gameNumber++;
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  public void play() {
    MessageCli.START_ROUND.printMessage(Integer.toString(gameNumber));
  }

  public void endGame() {}

  public void showStats() {}
}
