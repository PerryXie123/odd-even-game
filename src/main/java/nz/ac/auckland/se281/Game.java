package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  public int gameNumber = 0;
  public String playerName;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    gameNumber++;
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    playerName = options[0];
  }

  public void play() {
    MessageCli.START_ROUND.printMessage(Integer.toString(gameNumber));
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, input);
  }

  public void endGame() {}

  public void showStats() {}
}
