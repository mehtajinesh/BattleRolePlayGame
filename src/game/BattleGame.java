package game;

import java.util.Scanner;

/**
 * This class is used to represent the battle game which is conducted between two player.
 * This class also uses all the functionalities that are part of the battle arena interface.
 * It is the driver class for this application.
 */
public class BattleGame {

  /**
   * This function is called the main function as it is executed as soon as the user
   * opens the application.
   *
   * @param args command line arguments provided
   */
  public static void main(String[] args) {
    try {
      String outputText = "Welcome to the battle game!!! This game is played between two players.";
      System.out.println(outputText);
      RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl();
      //create arena
      BattleArena battleArena = new BattleArenaImpl(randomizer);
      //create two players
      Player player1 = new PlayerImpl("Google", randomizer);
      Player player2 = new PlayerImpl("Apple", randomizer);
      System.out.println("Created Player 1 and Player 2");
      // add players to arena
      battleArena.addPlayerToArena(player1);
      battleArena.addPlayerToArena(player2);
      System.out.println("Added both the players to battle arena");
      //equip players with gears and weapons
      System.out.println("Both players are going to the equipment room to grab "
              + "some gears and weapons");
      battleArena.equipPlayersForBattle();
      System.out.println("Both players have now picked up gears and weapons for battle");
      // gear up players for battle
      battleArena.gearUpPlayersForBattle();
      System.out.println("Both players have now geared up for battle");
      //generate player information with gear and weapons
      System.out.println("\nPlayer Complete Description:");
      String player1Information = battleArena.generatePlayersDescription(player1);
      System.out.println(player1Information);
      String player2Information = battleArena.generatePlayersDescription(player2);
      System.out.println(player2Information);
      // perform battle between players
      String battleSummary = battleArena.performBattle();
      System.out.println("Match Summary: \n" + battleSummary);
      while (true) {
        System.out.println("Rematch? Type 'Yes' to confirm and 'No' to exit");
        Scanner inputScanner = new Scanner(System.in);
        String inputText = inputScanner.nextLine();
        if (inputText.compareToIgnoreCase("yes") == 0) {
          System.out.println("User has required for rematch.");
          // perform battle between players
          battleSummary = battleArena.performBattle();
          System.out.println("Match Summary: \n%s" + battleSummary);
        } else {
          break;
        }
      }
    } catch (IllegalStateException | IllegalArgumentException | UnsupportedOperationException e) {
      System.out.println("Exception occurred: " + e);
    }
  }
}
