package game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * This class is used to provide testing for player implementation.
 */
public class PlayerImplTest {

  /**
   * This function is used to test if a null randomizer is not passed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRandomizerNotNullPlayer() {
    Player player = new PlayerImpl("Google", null);
  }

  /**
   * This function is used to test if empty player name is passed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyPlayerName() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl();
    Player player = new PlayerImpl("", randomizer);
  }

  /**
   * This function is used to test if null player name is passed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullPlayerName() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl();
    Player player = new PlayerImpl(null, randomizer);
  }

  /**
   * This function is used to test get player name.
   */
  @Test
  public void testGetPlayerName() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl();
    Player player = new PlayerImpl("Google", randomizer);
    assertEquals("Player name not matching", "Google", player.getPlayerName());
  }

  /**
   * This function is used to test min ability range satisfied or not.
   */
  @Test
  public void testMinAbilityValue() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl(
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);
    Player player1 = new PlayerImpl("Google", randomizer);
    Player player2 = new PlayerImpl("Facebook", randomizer);
    BattleArena battleArena = new BattleArenaImpl(randomizer);
    battleArena.addPlayerToArena(player1);
    battleArena.addPlayerToArena(player2);
    String player1Description = battleArena.generatePlayersDescription(player1);
    String player2Description = battleArena.generatePlayersDescription(player2);
    boolean validationStrengthTest = player1Description.contains("Strength Value: 6")
            && player2Description.contains("Strength Value: 6");
    boolean validationConstitutionTest = player1Description.contains("Constitution Value: 6")
            && player2Description.contains("Constitution Value: 6");
    boolean validationDexterityTest = player1Description.contains("Dexterity Value: 6")
            && player2Description.contains("Dexterity Value: 6");
    assertTrue("Randomizer for min possible strength value not working", validationStrengthTest);
    assertTrue("Randomizer for min possible constitution value not working",
            validationConstitutionTest);
    assertTrue("Randomizer for min possible dexterity value not working", validationDexterityTest);
    boolean validationCharismaTest = player1Description.contains("Charisma Value: 6")
            && player2Description.contains("Charisma Value: 6");
    assertTrue("Randomizer for min possible charisma value not working", validationCharismaTest);
  }

  /**
   * This function is used to test max ability range satisfied or not.
   */
  @Test
  public void testMaxAbilityValue() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl(
            6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
            6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6);
    Player player1 = new PlayerImpl("Google", randomizer);
    Player player2 = new PlayerImpl("Facebook", randomizer);
    BattleArena battleArena = new BattleArenaImpl(randomizer);
    battleArena.addPlayerToArena(player1);
    battleArena.addPlayerToArena(player2);
    String player1Description = battleArena.generatePlayersDescription(player1);
    String player2Description = battleArena.generatePlayersDescription(player2);
    boolean validationStrengthTest = player1Description.contains("Strength Value: 18")
            && player2Description.contains("Strength Value: 18");
    boolean validationConstitutionTest = player1Description.contains("Constitution Value: 18")
            && player2Description.contains("Constitution Value: 18");
    boolean validationDexterityTest = player1Description.contains("Dexterity Value: 18")
            && player2Description.contains("Dexterity Value: 18");
    assertTrue("Randomizer for min possible strength value not working", validationStrengthTest);
    assertTrue("Randomizer for min possible constitution value not working",
            validationConstitutionTest);
    assertTrue("Randomizer for min possible dexterity value not working", validationDexterityTest);
    boolean validationCharismaTest = player1Description.contains("Charisma Value: 18")
            && player2Description.contains("Charisma Value: 18");
    assertTrue("Randomizer for min possible charisma value not working", validationCharismaTest);
  }

  /**
   * This function is used to test normal ability ranges.
   */
  @Test
  public void testNormalAbilityValue() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl(
            2, 3, 4, 6, 2, 2, 6, 6, 2, 3, 5, 6, 6, 2, 4, 6,
            2, 3, 4, 6, 2, 2, 6, 6, 2, 3, 5, 6, 6, 2, 4, 6);
    Player player1 = new PlayerImpl("Google", randomizer);
    Player player2 = new PlayerImpl("Facebook", randomizer);
    BattleArena battleArena = new BattleArenaImpl(randomizer);
    battleArena.addPlayerToArena(player1);
    battleArena.addPlayerToArena(player2);
    String player1Description = battleArena.generatePlayersDescription(player1);
    String player2Description = battleArena.generatePlayersDescription(player2);
    boolean validationStrengthTest = player1Description.contains("Strength Value: 13")
            && player2Description.contains("Strength Value: 13");
    boolean validationConstitutionTest = player1Description.contains("Constitution Value: 14")
            && player2Description.contains("Constitution Value: 14");
    boolean validationDexterityTest = player1Description.contains("Dexterity Value: 14")
            && player2Description.contains("Dexterity Value: 14");
    assertTrue("Randomizer for normal possible strength value not working", validationStrengthTest);
    assertTrue("Randomizer for normal possible constitution value not working",
            validationConstitutionTest);
    assertTrue("Randomizer for normal possible dexterity value not working",
            validationDexterityTest);
    boolean validationCharismaTest = player1Description.contains("Charisma Value: 16")
            && player2Description.contains("Charisma Value: 16");
    assertTrue("Randomizer for normal possible charisma value not working", validationCharismaTest);
  }

  /**
   * This function is used to test if re-dice works or not when we get '1'.
   */
  @Test
  public void testReDiceAbilityValue() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl(
            1, 2, 3, 4, 6, 2, 2, 1, 6, 6, 2, 3, 5, 6, 6, 2, 4, 6,
            1, 2, 3, 4, 6, 2, 2, 6, 6, 2, 3, 5, 6, 6, 2, 4, 6);
    Player player1 = new PlayerImpl("Google", randomizer);
    Player player2 = new PlayerImpl("Facebook", randomizer);
    BattleArena battleArena = new BattleArenaImpl(randomizer);
    battleArena.addPlayerToArena(player1);
    battleArena.addPlayerToArena(player2);
    String player1Description = battleArena.generatePlayersDescription(player1);
    String player2Description = battleArena.generatePlayersDescription(player2);
    boolean validationStrengthTest = player1Description.contains("Strength Value: 13")
            && player2Description.contains("Strength Value: 13");
    boolean validationConstitutionTest = player1Description.contains("Constitution Value: 14")
            && player2Description.contains("Constitution Value: 14");
    boolean validationDexterityTest = player1Description.contains("Dexterity Value: 14")
            && player2Description.contains("Dexterity Value: 14");
    assertTrue("Randomizer for normal possible strength value not working", validationStrengthTest);
    assertTrue("Randomizer for normal possible constitution value not working",
            validationConstitutionTest);
    assertTrue("Randomizer for normal possible dexterity value not working",
            validationDexterityTest);
    boolean validationCharismaTest = player1Description.contains("Charisma Value: 16")
            && player2Description.contains("Charisma Value: 16");
    assertTrue("Randomizer for normal possible charisma value not working", validationCharismaTest);
  }
}