package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  public int gameNumber = 0;
  public String playerName;
  public Strategy strategy;
  public Choice choice;
  public String choiceString;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    gameNumber = 0;
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    playerName = options[0];
    setDifficulty(difficulty);
    setChoice(choice);
    switch (choice) {
      case ODD:
          choiceString = "ODD";
          break;
      case EVEN:
          choiceString = "EVEN";
          break;
  }
  }

  public void play() {
    int finger;
    int sum;
    gameNumber++;
    MessageCli.START_ROUND.printMessage(Integer.toString(gameNumber));
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();
    while (!Utils.isInteger(input)
        || (Integer.parseInt(input) < 0 || Integer.parseInt(input) > 5)) {
      MessageCli.INVALID_INPUT.printMessage();
      input = Utils.scanner.nextLine();
    }
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, input);
    finger = strategy.chooseFinger();
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", Integer.toString(finger));

    sum = Integer.parseInt(input) + finger;

    if(wins(sum)){
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), choiceString, playerName);
    }
    else{
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), choiceString, "HAL-9000");
    }
  }

  public void endGame() {}

  public void showStats() {}

  public void setDifficulty(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        strategy = new Easy();
        break;
      case MEDIUM:
        strategy = new Medium();
        break;
      case HARD:
        strategy = new Hard();
        break;
    }
  }

  public void setChoice(Choice choice) {
    this.choice = choice;
  }

  public boolean wins(int sum) {
    if (((choice == Choice.ODD) && Utils.isOdd(sum))
        || ((choice == Choice.EVEN) && Utils.isEven(sum))) {
      return true;
    } else {
      return false;
    }
  }
}
