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
  public int oddCount;
  public int evenCount;
  public Hard hardStrategy;
  public int win;
  public boolean active = false;
  public int userWins;
  public int botWins;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    active = true;
    gameNumber = 0;
    oddCount = 0;
    evenCount = 0;
    userWins = 0;
    botWins = 0;
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
    if (active == false) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else {
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

      if (Utils.isEven(Integer.parseInt(input))) {
        evenCount++;
      } else {
        oddCount++;
      }

      finger = strategy.chooseFinger(gameNumber, oddCount, evenCount, choiceString);
      MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", Integer.toString(finger));

      sum = Integer.parseInt(input) + finger;

      String EVENODD;

      if (Utils.isEven(sum)) {
        EVENODD = "EVEN";
      } else {
        EVENODD = "ODD";
      }

      if (wins(sum)) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), EVENODD, playerName);
        userWins++;
        win = 1;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), EVENODD, "HAL-9000");
        botWins++;
        win = 0;
      }
    }
  }

  public void endGame() {
    showStats();
    if(userWins > botWins){
      MessageCli.PRINT_END_GAME.printMessage(playerName);
    }
    else if(botWins > userWins){
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    }
  }

  public void showStats() {
    if (active == false) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else {
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          playerName, Integer.toString(userWins), Integer.toString(botWins));
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          "HAL-9000", Integer.toString(botWins), Integer.toString(userWins));
    }
  }

  public void setDifficulty(Main.Difficulty difficulty) {
    StrategyFactory factory = new StrategyFactory();
    this.strategy = factory.getStrategy(difficulty);
    if (difficulty == Main.Difficulty.HARD) {
      hardStrategy = (Hard) strategy;
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
