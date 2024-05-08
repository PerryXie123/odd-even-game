package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  // Initialises the needed variables for game logic
  private int gameNumber = 0;
  private String playerName;
  private Strategy strategy;
  private Choice choice;
  private String choiceString;
  private int oddCount;
  private int evenCount;
  private boolean active = false;
  private int userWins;
  private int botWins;

  /**
   * Initialises a new game with a default round number and win values.
   *
   * @param difficulty the difficulty chosen by the user
   * @param choice the choice of the user between odd and even
   * @param options an array with information about the user
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // Sets all variables to zero, and sets the game active
    active = true;
    gameNumber = 0;
    oddCount = 0;
    evenCount = 0;
    userWins = 0;
    botWins = 0;
    // Prints welcome message
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    // Sets the player name, difficulty, and choice
    playerName = options[0];
    setDifficulty(difficulty);
    setChoice(choice);
    // Sets the string version of the users choice
    switch (choice) {
      case ODD:
        choiceString = "ODD";
        break;
      case EVEN:
        choiceString = "EVEN";
        break;
    }
  }

  /** Includes the logic for the game, and how the user inputs interact with the bots difficulty. */
  public void play() {
    // Initialises the finger and sum integers
    int finger;
    int sum;
    // Error message if a game is not active
    if (active == false) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      // Else, continues with game logic
    } else {
      gameNumber++;
      // Prints the start round messages
      MessageCli.START_ROUND.printMessage(Integer.toString(gameNumber));
      MessageCli.ASK_INPUT.printMessage();
      String input = Utils.scanner.nextLine();
      // Checks if the user input number is an integer between 0 and 5
      while (!Utils.isInteger(input)
          || (Integer.parseInt(input) < 0 || Integer.parseInt(input) > 5)) {
        MessageCli.INVALID_INPUT.printMessage();
        input = Utils.scanner.nextLine();
      }
      MessageCli.PRINT_INFO_HAND.printMessage(playerName, input);
      // Increments odd or even counter
      if (Utils.isEven(Integer.parseInt(input))) {
        evenCount++;
      } else {
        oddCount++;
      }

      // The bot choses a finger based on the users difficulty choice
      finger = strategy.chooseFinger(gameNumber, oddCount, evenCount, choiceString);
      MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", Integer.toString(finger));

      // Calculates the sum of the user and bot fingers
      sum = Integer.parseInt(input) + finger;

      String EVENODD;

      // Gets the string version of the round outcomes
      if (Utils.isEven(sum)) {
        EVENODD = "EVEN";
      } else {
        EVENODD = "ODD";
      }

      // Prints winner messages
      if (wins(sum)) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), EVENODD, playerName);
        userWins++;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), EVENODD, "HAL-9000");
        botWins++;
      }
    }
  }

  /** Ends the instance of the game, and prints out corresponding messages. */
  public void endGame() {
    // Shows the stats
    showStats();
    // Prints the winning message depending on who had more round wins
    if (userWins > botWins) {
      MessageCli.PRINT_END_GAME.printMessage(playerName);
    } else if (botWins > userWins) {
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }
    // Deactivates the game
    active = false;
  }

  /** Shows the current statistics for the user and the bot. */
  public void showStats() {
    // Only shows stats if there is an active game
    if (active == false) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      // Prints stats based on the number of round wins
    } else {
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          playerName, Integer.toString(userWins), Integer.toString(botWins));
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          "HAL-9000", Integer.toString(botWins), Integer.toString(userWins));
    }
  }

  /**
   * Invokes a strategy factory to build the corresponding bot.
   *
   * @param difficulty the difficulty as specified by the user
   */
  public void setDifficulty(Main.Difficulty difficulty) {
    // Sets the difficulty and invokes the strategy factory
    StrategyFactory factory = new StrategyFactory();
    this.strategy = factory.getStrategy(difficulty);
  }

  /**
   * Setter method for the users choice.
   *
   * @param choice the users choice between odd or even
   */
  public void setChoice(Choice choice) {
    // Sets the users choice
    this.choice = choice;
  }

  /**
   * Checks whether the user or bot wins depending on the sum of the provided numbers and the users
   * choice.
   *
   * @param sum the sum of the numbers provided by the user and the bot
   * @return boolean true if the user wins, and false if the bot wins
   */
  public boolean wins(int sum) {
    //Checks if the user wins the round
    if (((choice == Choice.ODD) && Utils.isOdd(sum))
        || ((choice == Choice.EVEN) && Utils.isEven(sum))) {
      return true;
    } else {
      return false;
    }
  }
}
