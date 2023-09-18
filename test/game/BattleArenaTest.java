package game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * This class is used to perform testing for battle arena.
 */
public class BattleArenaTest {

  /**
   * This function is used to test randomizer null condition.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRandomizerNullBattleArena() {
    BattleArena battleArena = new BattleArenaImpl(null);
    fail("Exception should have been called by now");
  }

  /**
   * This function is used to test adding player functionality into the arena.
   */
  @Test
  public void testValidAddTwoPlayersToArena() {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGeneratorImpl();
    BattleArena battleArena = new BattleArenaImpl(randomNumberGenerator);
    Player player1 = new PlayerImpl("Google", randomNumberGenerator);
    Player player2 = new PlayerImpl("Facebook", randomNumberGenerator);
    battleArena.addPlayerToArena(player1);
    battleArena.addPlayerToArena(player2);
    String player1Description = battleArena.generatePlayersDescription(player1);
    String player2Description = battleArena.generatePlayersDescription(player2);
    boolean validationTest = player1Description.contains("Player Name: Google")
            && player2Description.contains("Player Name: Facebook");
    assertTrue("Player addition not working properly", validationTest);
  }

  /**
   * This function is used to perform testing for null player condition.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullPlayerConditionAdditionToArena() {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGeneratorImpl();
    BattleArena battleArena = new BattleArenaImpl(randomNumberGenerator);
    battleArena.addPlayerToArena(null);
    fail("This should have thrown exception by now.");
  }

  /**
   * This function is used to test if the player added has no gears on him/her/them.
   */
  @Test
  public void testCheckForZeroGearOnPlayersWhenAddingToArena() {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGeneratorImpl();
    BattleArena battleArena = new BattleArenaImpl(randomNumberGenerator);
    Player player1 = new PlayerImpl("Google", randomNumberGenerator);
    Player player2 = new PlayerImpl("Facebook", randomNumberGenerator);
    battleArena.addPlayerToArena(player1);
    battleArena.addPlayerToArena(player2);
    String player1Description = battleArena.generatePlayersDescription(player1);
    String player2Description = battleArena.generatePlayersDescription(player2);
    boolean validationTest = player1Description.contains("Total Gears: 0")
            && player2Description.contains("Total Gears: 0");
    assertTrue("Players are not entering with basic abilities", validationTest);
  }

  /**
   * This function is used to test if the player added has no weapons on him/her/them.
   */
  @Test
  public void testCheckForZeroWeaponsOnPlayersWhenAddingToArena() {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGeneratorImpl();
    BattleArena battleArena = new BattleArenaImpl(randomNumberGenerator);
    Player player1 = new PlayerImpl("Google", randomNumberGenerator);
    Player player2 = new PlayerImpl("Facebook", randomNumberGenerator);
    battleArena.addPlayerToArena(player1);
    battleArena.addPlayerToArena(player2);
    String player1Description = battleArena.generatePlayersDescription(player1);
    String player2Description = battleArena.generatePlayersDescription(player2);
    boolean validationTest = player1Description.contains("Total Weapons: 1\nHands")
            && player2Description.contains("Total Weapons: 1\nHands");
    assertTrue("Players are not entering with only bare hands", validationTest);
  }

  /**
   * This function is used to test whether we are getting 15 potions in the bag of gears or not.
   */
  @Test
  public void testMinimumFifteenPotionWearGears() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl(
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            10, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3,
            15, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1,
            2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1,
            2, -2, 1, 2, -2, 1,
            55, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3,
            -4, -4, -4, -4, -4, -4, -4, -4, -4, -4,
            -4, -4, -4, -4, -4, -4, -4, -4, -4, -4,
            2, 2, 2, 2, 2,
            0, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43,
            5);
    Player player1 = new PlayerImpl("Google", randomizer);
    BattleArena battleArena = new BattleArenaImpl(randomizer);
    battleArena.addPlayerToArena(player1);
    battleArena.equipPlayersForBattle();
    String playerDescription = battleArena.generatePlayersDescription(player1);
    boolean testMinTextPotion = true;
    for (int counter = 0; counter < 15; counter++) {
      if (!playerDescription.contains(String.format("Potion-%s", counter + 1))) {
        testMinTextPotion = false;
        break;
      }
    }
    assertTrue("Minimum Potion not generated", testMinTextPotion);
  }

  /**
   * This function is used to test whether we are getting 15 belts in the bag of gears or not.
   */
  @Test
  public void testMinimumFifteenBeltWearGears() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl(
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            10, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3,
            15, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1,
            2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1,
            2, -2, 1, 2, -2, 1,
            55, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3,
            -4, -4, -4, -4, -4, -4, -4, -4, -4, -4,
            -4, -4, -4, -4, -4, -4, -4, -4, -4, -4,
            2, 2, 2, 2, 2,
            0, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43,
            5);
    Player player1 = new PlayerImpl("Google", randomizer);
    Player player2 = new PlayerImpl("Apple", randomizer);
    BattleArena battleArena = new BattleArenaImpl(randomizer);
    battleArena.addPlayerToArena(player1);
    battleArena.equipPlayersForBattle();
    String playerDescription = battleArena.generatePlayersDescription(player1);
    boolean testMinTextPotion = true;
    for (int counter = 0; counter < 15; counter++) {
      if (!playerDescription.contains(String.format("Potion-%s", counter + 1))) {
        testMinTextPotion = false;
        break;
      }
    }
    assertTrue("Minimum Potion not generated", testMinTextPotion);
  }

  /**
   * This function is used to test whether we are able to assign exactly 10 belts units
   * when picking gears.
   */
  @Test
  public void testExactTenBeltUnitWearPickForGears() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl(
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            10, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3,
            15, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1,
            2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1,
            2, -2, 1, 2, -2, 1,
            55, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3,
            -4, -4, -4, -4, -4, -4, -4, -4, -4, -4,
            -4, -4, -4, -4, -4, -4, -4, -4, -4, -4,
            2, 2, 2, 2, 2,
            0, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 36, 37, 38, 39, 40, 41, 42, 43, 44,
            5);
    Player player1 = new PlayerImpl("Google", randomizer);
    Player player2 = new PlayerImpl("Apple", randomizer);
    BattleArena battleArena = new BattleArenaImpl(randomizer);
    battleArena.addPlayerToArena(player1);
    battleArena.equipPlayersForBattle();
    String playerDescription = battleArena.generatePlayersDescription(player1);
    boolean testExactTenBelt = true;
    for (int counter = 0; counter < 10; counter++) {
      if (!playerDescription.contains(String.format("Belt-%s", counter + 1))) {
        testExactTenBelt = false;
        break;
      }
    }
    for (int counter = 10; counter < 15; counter++) {
      if (playerDescription.contains(String.format("Belt-%s", counter + 1))) {
        testExactTenBelt = false;
        break;
      }
    }
    assertTrue("Belts picked up are not equal to exact 10 units", testExactTenBelt);
  }

  /**
   * This function is used to test whether we are able to restrict the user from assigning
   * more than 10 belt units.
   */
  @Test
  public void testMoreThanTenBeltWearPickRestrictionGears() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl(
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            10, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3,
            15, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1,
            2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1,
            2, -2, 1, 2, -2, 1,
            55, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3,
            -4, -4, -4, -4, -4, -4, -4, -4, -4, -4,
            -4, -4, -4, -4, -4, -4, -4, -4, -4, -4,
            2, 2, 2, 2, 2,
            0, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 36, 37, 38, 39, 40, 41, 42, 43, 44,
            5);
    Player player1 = new PlayerImpl("Google", randomizer);
    Player player2 = new PlayerImpl("Apple", randomizer);
    BattleArena battleArena = new BattleArenaImpl(randomizer);
    battleArena.addPlayerToArena(player1);
    battleArena.equipPlayersForBattle();
    String playerDescription = battleArena.generatePlayersDescription(player1);
    boolean testNoMoreThanTenBeltSelected = true;
    for (int counter = 0; counter < 10; counter++) {
      if (!playerDescription.contains(String.format("Belt-%s", counter + 1))) {
        testNoMoreThanTenBeltSelected = false;
        break;
      }
    }
    for (int counter = 10; counter < 15; counter++) {
      if (playerDescription.contains(String.format("Belt-%s", counter + 1))) {
        testNoMoreThanTenBeltSelected = false;
        break;
      }
    }
    assertTrue("More than 10 belts units should not be picked", testNoMoreThanTenBeltSelected);
  }

  /**
   * This function is used to test whether we are able to restrict the user from picking
   * up more than one headgear.
   */
  @Test
  public void testMaximumOneHeadGearPickUp() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl(
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            10, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3,
            15, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1,
            2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1,
            2, -2, 1, 2, -2, 1,
            55, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3,
            -4, -4, -4, -4, -4, -4, -4, -4, -4, -4,
            -4, -4, -4, -4, -4, -4, -4, -4, -4, -4,
            2, 2, 2, 2, 2,
            80, 81, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43,
            5);
    Player player1 = new PlayerImpl("Google", randomizer);
    Player player2 = new PlayerImpl("Apple", randomizer);
    BattleArena battleArena = new BattleArenaImpl(randomizer);
    battleArena.addPlayerToArena(player1);
    battleArena.equipPlayersForBattle();
    String playerDescription = battleArena.generatePlayersDescription(player1);
    boolean testOneHeadgearRestPotion = true;
    for (int counter = 0; counter < 19; counter++) {
      if (!playerDescription.contains(String.format("Potion-%s", counter + 1))) {
        testOneHeadgearRestPotion = false;
        break;
      }
    }
    if (!playerDescription.contains("Headgear-1")) {
      testOneHeadgearRestPotion = false;
    }
    assertTrue("More than one headgear is getting picked up", testOneHeadgearRestPotion);
  }

  /**
   * This function is used to test if we are able to restrict the user to pick up
   * more than one footwear.
   */
  @Test
  public void testMaximumOneFootwearPickUp() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl(
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            10, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3,
            15, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1,
            2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1,
            2, -2, 1, 2, -2, 1,
            55, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3,
            -4, -4, -4, -4, -4, -4, -4, -4, -4, -4,
            -4, -4, -4, -4, -4, -4, -4, -4, -4, -4,
            2, 2, 2, 2, 2,
            0, 1, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43,
            5);
    Player player1 = new PlayerImpl("Google", randomizer);
    Player player2 = new PlayerImpl("Apple", randomizer);
    BattleArena battleArena = new BattleArenaImpl(randomizer);
    battleArena.addPlayerToArena(player1);
    battleArena.equipPlayersForBattle();
    String playerDescription = battleArena.generatePlayersDescription(player1);
    boolean testOneFootWearRestPotion = true;
    for (int counter = 0; counter < 19; counter++) {
      if (!playerDescription.contains(String.format("Potion-%s", counter + 1))) {
        testOneFootWearRestPotion = false;
        break;
      }
    }
    if (!playerDescription.contains("Footwear-1")) {
      testOneFootWearRestPotion = false;
    }
    assertTrue("More than one footwear is getting picked up", testOneFootWearRestPotion);
  }

  /**
   * This function is used to test if the player was able to acquire one weapon
   * from the bag of weapons.
   */
  @Test
  public void testWeaponAcquiredForBattle() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl(
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            10, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3,
            15, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1,
            2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1,
            2, -2, 1, 2, -2, 1,
            55, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3,
            -4, -4, -4, -4, -4, -4, -4, -4, -4, -4,
            -4, -4, -4, -4, -4, -4, -4, -4, -4, -4,
            2, 2, 2, 2, 2,
            0, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43,
            5);
    Player player1 = new PlayerImpl("Google", randomizer);
    BattleArena battleArena = new BattleArenaImpl(randomizer);
    battleArena.addPlayerToArena(player1);
    battleArena.equipPlayersForBattle();
    String playerDescription = battleArena.generatePlayersDescription(player1);
    boolean testTwoHandedSword = playerDescription.contains("Two Handed Sword-2");
    assertTrue("Player not able to choose weapon", testTwoHandedSword);
  }

  /**
   * This function is used to test if the gear up functionality is working or not.
   */
  @Test
  public void testGearUpPlayersForBattle() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl(
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            10, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3,
            15, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1,
            2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1,
            2, -2, 1, 2, -2, 1,
            55, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3,
            -4, -4, -4, -4, -4, -4, -4, -4, -4, -4,
            -4, -4, -4, -4, -4, -4, -4, -4, -4, -4,
            2, 2, 2, 2, 2,
            0, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43,
            5);
    Player player1 = new PlayerImpl("Google", randomizer);
    BattleArena battleArena = new BattleArenaImpl(randomizer);
    battleArena.addPlayerToArena(player1);
    battleArena.equipPlayersForBattle();
    battleArena.gearUpPlayersForBattle();
    String playerDescription = battleArena.generatePlayersDescription(player1);
    boolean testEquip = playerDescription.contains("Gears equipped: \n"
            + "Total Gears: 20\n"
            + "Gear name: Potion-1\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-10\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-11\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-12\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-13\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-14\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-15\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-16\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-17\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-18\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-19\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-2\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-3\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-4\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-5\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-6\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-7\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-8\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-9\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Footwear-1\n"
            + "Gear type: Footwear\n"
            + "Ability Affected: DEXTERITY, by Value: -3");
    boolean testGearUp = playerDescription.contains("Basic Strength Value: 6 \n"
            + "Basic Constitution Value: 6 \n"
            + "Basic Dexterity Value: 6 \n"
            + "Basic Charisma Value: 6 ");
    assertTrue("Player not able to gear up for battle", testGearUp);
    assertTrue("Player not able to equip up for battle", testEquip);
  }

  /**
   * This function is used to check if the player description is getting generated
   * properly or not.
   */
  @Test
  public void testGeneratePlayersDescription() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl(
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            10, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3,
            15, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1,
            2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1, 2, -2, 1,
            2, -2, 1, 2, -2, 1,
            55, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3,
            -4, -4, -4, -4, -4, -4, -4, -4, -4, -4,
            -4, -4, -4, -4, -4, -4, -4, -4, -4, -4,
            2, 2, 2, 2, 2,
            0, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43,
            5);
    Player player1 = new PlayerImpl("Google", randomizer);
    BattleArena battleArena = new BattleArenaImpl(randomizer);
    battleArena.addPlayerToArena(player1);
    battleArena.equipPlayersForBattle();
    battleArena.gearUpPlayersForBattle();
    String playerDescription = battleArena.generatePlayersDescription(player1);
    String expectedPlayerDescription = "\n"
            + "Player Name: Google \n"
            + "Basic Strength Value: 6 \n"
            + "Basic Constitution Value: 6 \n"
            + "Basic Dexterity Value: 6 \n"
            + "Basic Charisma Value: 6 \n"
            + "Effective Strength Value: 63 \n"
            + "Effective Constitution Value: 6 \n"
            + "Effective Dexterity Value: 3 \n"
            + "Effective Charisma Value: 6 \n"
            + "Gears equipped: \n"
            + "Total Gears: 20\n"
            + "Gear name: Potion-1\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-10\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-11\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-12\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-13\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-14\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-15\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-16\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-17\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-18\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-19\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-2\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-3\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-4\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-5\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-6\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-7\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-8\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-9\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Footwear-1\n"
            + "Gear type: Footwear\n"
            + "Ability Affected: DEXTERITY, by Value: -3\n"
            + "Weapon(s) carried: \n"
            + "Total Weapons: 1\n"
            + "Two Handed Sword-2\n";
    assertEquals("Player description incorrect", expectedPlayerDescription, playerDescription);
  }

  /**
   * This function is used to test player striking power calculation during battle.
   */
  @Test
  public void testPlayerStrikingPowerWorking() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl(
            4, 5, 6, 5, 1, 1, 5, 5, 4, 3, 3, 2, 2, 3, 5, 6, 4, 1,
            6, 4, 1, 3, 2, 4, 2, 4, 3, 6, 5, 4, 6, 5, 3, 1, 2, 3, 5,
            19, -4, -4, -2, -4, -2, -3, -3, -4, -4, -2, -4, -2, -3, -4, -4, -2,
            -3, -3, -2, 26, 2, -1, 1, 2, -2, 3, 3, -2, 3, 2, -1, 2, 4, -1, 3, 3,
            -1, 2, 3, -2, 1, 2, -2, 1, 2, -2, 2, 4, -1, 2, 3, -2, 1, 3, -1, 3, 4,
            -2, 1, 2, -1, 3, 2, -1, 2, 2, -1, 2, 4, -1, 3, 2, -2, 2, 4, -2, 1, 4,
            -2, 3, 4, -1, 1, 4, -2, 3, 4, -2, 2, 2, -2, 3, 3, -1, 2, 3, -1, 3, 71,
            6, 5, 5, 5, 6, 6, 4, 3, 6, 3, 6, 3, 5, 4, 4, 5, 6, 6, 5, 6, 3, 6, 3, 5,
            3, 6, 4, 3, 5, 3, 5, 3, 3, 6, 3, 6, 3, 5, 4, 6, 5, 4, 5, 5, 5, 4, 3, 3, 5,
            4, 5, 3, 3, 4, 5, 5, 5, 6, 3, 5, 3, 5, 6, 3, 6, 6, 4, 6, 6, 4, 5, 6, 6, 6,
            6, 6, 6, 4, 6, 4, 4, 5, 6, 4, 6, 5, 5, 4, 5, 6, 6, 6, 6, 5, 6, 6, 4, 6, 5, 4,
            4, 5, 4, 4, 5, 4, 6, 6, 4, 4, 6, 4, 5, 6, 4, 4, 4, 5, 5, 5, 5, 4, 6, 6, 5, 5,
            4, 5, 5, 6, 5, 6, 5, 4, 4, 7, 4, 3, 2, 2, 127, 142, 5, 155, 89, 130, 60, 103,
            51, 128, 93, 80, 100, 111, 140, 85, 118, 35, 101, 36, 125, 71, 97, 17, 163, 100,
            105, 154, 3, 117, 62, 159, 56, 159, 166, 110, 11, 112, 8, 158, 63, 19, 72, 57, 35,
            159, 142, 6, 42, 141, 113, 1, 151, 117, 140, 74, 13, 128, 129, 8, 107, 124, 74,
            138, 132, 9, 93, 72, 159, 81, 59, 9, 136, 117, 118, 126, 113, 130, 29, 11, 137,
            130, 5, 102, 54, 14, 21, 152, 18, 65, 46, 64, 64, 8, 21, 151, 137, 118, 63, 110,
            151, 116, 152, 115, 14, 118, 15, 147, 66, 136, 2, 89, 57, 103, 65, 148, 157, 44, 16,
            6, 2, 11, 0, 1, 9, 5, 9, 1, 1, 1, 0, 5, 5, 10, 0, 1
    );
    Player player1 = new PlayerImpl("Google", randomizer);
    Player player2 = new PlayerImpl("Apple", randomizer);
    BattleArena battleArena = new BattleArenaImpl(randomizer);
    battleArena.addPlayerToArena(player1);
    battleArena.addPlayerToArena(player2);
    battleArena.equipPlayersForBattle();
    battleArena.gearUpPlayersForBattle();
    String player1Description = battleArena.generatePlayersDescription(player1);
    String matchSummary = battleArena.performBattle();
    // for this case, we have taken values in such a way that google has ability values:
    // strength:88, constitution:20, dexterity:2, charisma:23, total = 133
    // potential striking for Google: 94 = 16(basic) +
    // 72(potion gear-3,5,6,4,6,5,5,5,3,5,5,3,3,6,4,4) + 6(random)
    boolean validateTest = matchSummary.contains("Player Google's Striking Power: 94")
            && player1Description.contains("Basic Strength Value: 16")
            && player1Description.contains("Effective Constitution Value: 20")
            && player1Description.contains("Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-16\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 5\n"
            + "Gear name: Potion-18\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 6\n"
            + "Gear name: Potion-27\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 4\n"
            + "Gear name: Potion-36\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 6\n"
            + "Gear name: Potion-41\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 5\n"
            + "Gear name: Potion-45\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 5\n"
            + "Gear name: Potion-49\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 5\n"
            + "Gear name: Potion-53\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-56\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 5\n"
            + "Gear name: Potion-57\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 5\n"
            + "Gear name: Potion-59\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-61\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 3\n"
            + "Gear name: Potion-66\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 6\n"
            + "Gear name: Potion-67\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 4\n"
            + "Gear name: Potion-7\n"
            + "Gear type: Potion\n"
            + "Ability Affected: STRENGTH, by Value: 4");
    assertTrue("Player striking power calc not working", validateTest);
  }

  /**
   * This function is used to test player avoidance ability calculation during battle.
   */
  @Test
  public void testPlayerAvoidanceAbilityWorking() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl(
            4, 5, 6, 5, 1, 1, 5, 5, 4, 3, 3, 2, 2, 3, 5, 6, 4, 1,
            6, 4, 1, 3, 2, 4, 2, 4, 3, 6, 5, 4, 6, 5, 3, 1, 2, 3, 5,
            19, -4, -4, -2, -4, -2, -3, -3, -4, -4, -2, -4, -2, -3, -4, -4, -2,
            -3, -3, -2, 26, 2, -1, 1, 2, -2, 3, 3, -2, 3, 2, -1, 2, 4, -1, 3, 3,
            -1, 2, 3, -2, 1, 2, -2, 1, 2, -2, 2, 4, -1, 2, 3, -2, 1, 3, -1, 3, 4,
            -2, 1, 2, -1, 3, 2, -1, 2, 2, -1, 2, 4, -1, 3, 2, -2, 2, 4, -2, 1, 4,
            -2, 3, 4, -1, 1, 4, -2, 3, 4, -2, 2, 2, -2, 3, 3, -1, 2, 3, -1, 3, 71,
            6, 5, 5, 5, 6, 6, 4, 3, 6, 3, 6, 3, 5, 4, 4, 5, 6, 6, 5, 6, 3, 6, 3, 5,
            3, 6, 4, 3, 5, 3, 5, 3, 3, 6, 3, 6, 3, 5, 4, 6, 5, 4, 5, 5, 5, 4, 3, 3, 5,
            4, 5, 3, 3, 4, 5, 5, 5, 6, 3, 5, 3, 5, 6, 3, 6, 6, 4, 6, 6, 4, 5, 6, 6, 6,
            6, 6, 6, 4, 6, 4, 4, 5, 6, 4, 6, 5, 5, 4, 5, 6, 6, 6, 6, 5, 6, 6, 4, 6, 5, 4,
            4, 5, 4, 4, 5, 4, 6, 6, 4, 4, 6, 4, 5, 6, 4, 4, 4, 5, 5, 5, 5, 4, 6, 6, 5, 5,
            4, 5, 5, 6, 5, 6, 5, 4, 4, 7, 4, 3, 2, 2, 127, 142, 5, 155, 89, 130, 60, 103,
            51, 128, 93, 80, 100, 111, 140, 85, 118, 35, 101, 36, 125, 71, 97, 17, 163, 100,
            105, 154, 3, 117, 62, 159, 56, 159, 166, 110, 11, 112, 8, 158, 63, 19, 72, 57, 35,
            159, 142, 6, 42, 141, 113, 1, 151, 117, 140, 74, 13, 128, 129, 8, 107, 124, 74,
            138, 132, 9, 93, 72, 159, 81, 59, 9, 136, 117, 118, 126, 113, 130, 29, 11, 137,
            130, 5, 102, 54, 14, 21, 152, 18, 65, 46, 64, 64, 8, 21, 151, 137, 118, 63, 110,
            151, 116, 152, 115, 14, 118, 15, 147, 66, 136, 2, 89, 57, 103, 65, 148, 157, 44, 16,
            6, 2, 11, 0, 1, 9, 5, 9, 1, 1, 1, 0, 5, 5, 10, 0, 1
    );
    Player player1 = new PlayerImpl("Google", randomizer);
    Player player2 = new PlayerImpl("Apple", randomizer);
    BattleArena battleArena = new BattleArenaImpl(randomizer);
    battleArena.addPlayerToArena(player1);
    battleArena.addPlayerToArena(player2);
    battleArena.equipPlayersForBattle();
    battleArena.gearUpPlayersForBattle();
    String player1Description = battleArena.generatePlayersDescription(player1);
    String player2Description = battleArena.generatePlayersDescription(player2);
    String matchSummary = battleArena.performBattle();
    // for this case, we have taken values in such a way that apple has ability values:
    // strength:11, constitution:13, dexterity:16, charisma:11, total = 133
    // avoidance ability for Apple: 11 = 16(basic) +
    // (-7)(belt gear: -2,-2,-1 and footwear: -2) + 2(random)
    boolean validateTest = matchSummary.contains("Player Apple's Avoidance Ability: 11")
            && player2Description.contains("Basic Dexterity Value: 16")
            && player2Description.contains("Effective Dexterity Value: 9")
            && player2Description.contains("Gear name: Belt-2\n"
            + "Gear type: Belt\n"
            + "Belt type: BELT_LARGE\n"
            + "Ability Affected: CHARISMA, by Value: 2\n"
            + "Ability Affected: DEXTERITY, by Value: -2\n"
            + "Gear name: Belt-20\n"
            + "Gear type: Belt\n"
            + "Belt type: BELT_LARGE\n"
            + "Ability Affected: CHARISMA, by Value: 4\n"
            + "Ability Affected: DEXTERITY, by Value: -2\n"
            + "Gear name: Belt-4\n"
            + "Gear type: Belt\n"
            + "Belt type: BELT_MEDIUM\n"
            + "Ability Affected: CHARISMA, by Value: 2\n"
            + "Ability Affected: DEXTERITY, by Value: -1\n"
            + "Gear name: Footwear-10\n"
            + "Gear type: Footwear\n"
            + "Ability Affected: DEXTERITY, by Value: -2");
    assertTrue("Player Avoidance ability not working", validateTest);
  }

  /**
   * This function is used to test if the player potential striking damage calculation
   * is working or not during battle.
   */
  @Test
  public void testPlayerPotentialStrikingAbilityWorking() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl(
            6, 1, 6, 2, 2, 5, 4, 4, 4, 5, 3, 2, 2, 2, 6, 4, 4, 4, 1, 4, 4,
            5, 1, 2, 2, 2, 6, 6, 3, 3, 4, 1, 4, 1, 1, 6, 2, 6, 18, -4, -2, -2, -4, -4, -3,
            -3, -2, -2, -4, -4, -2, -3, -2, -3, -2, -2, -4, 18, 3, -2, 3, 4, -1, 2, 2,
            -2, 3, 2, -2, 3, 3, -1, 3, 4, -1, 2, 3, -1, 3, 2, -1, 1, 3, -1, 1, 4, -2, 1, 3,
            -2, 2, 3, -2, 2, 2, -2, 2, 4, -2, 1, 4, -1, 3, 2, -2, 2, 3, -1, 2, 3, -1, 3, 71,
            4, 4, 6, 3, 3, 5, 3, 4, 4, 4, 4, 3, 5, 4, 3, 3, 5, 4, 6, 4, 6, 5, 3, 4, 3, 5, 6,
            5, 6, 3, 4, 5, 4, 5, 5, 4, 3, 4, 6, 4, 4, 5, 4, 4, 3, 4, 4, 3, 5, 4, 4, 4, 4, 4,
            6, 6, 5, 3, 6, 6, 6, 6, 3, 4, 4, 3, 5, 5, 3, 5, 4, 6, 5, 4, 5, 5, 5, 6, 5, 5, 4,
            6, 4, 6, 5, 5, 6, 4, 6, 6, 5, 5, 6, 6, 6, 4, 4, 5, 6, 6, 4, 6, 6, 6, 4, 6, 6, 6,
            16, 5, 8, 2, 6, 142, 21, 120, 120, 9, 58, 42, 127, 62, 25, 119, 71, 84,
            131, 60, 130, 78, 79, 10, 25, 112, 39, 115, 119, 111, 44, 66, 112, 65, 7, 39, 66,
            68, 46, 128, 22, 11, 127, 115, 99, 12, 23, 7, 84, 86, 10, 99, 63, 84, 35, 66, 30,
            12, 87, 110, 69, 112, 48, 52, 58, 35, 40, 84, 107, 76, 45, 42, 39, 110, 80, 12, 80,
            73, 1, 23, 5, 5, 4, 1, 4, 3, 6, 0, 10, 6, 4, 1, 1, 4, 6, 1, 1, 1, 1, 0
    );
    Player player1 = new PlayerImpl("Google", randomizer);
    Player player2 = new PlayerImpl("Apple", randomizer);
    BattleArena battleArena = new BattleArenaImpl(randomizer);
    battleArena.addPlayerToArena(player1);
    battleArena.addPlayerToArena(player2);
    battleArena.equipPlayersForBattle();
    battleArena.gearUpPlayersForBattle();
    String player1Description = battleArena.generatePlayersDescription(player1);
    String matchSummary = battleArena.performBattle();
    //Here the weapon selected for Google is katana which has a range of 4 to 6
    // For this test, the value selected is 4.
    // for potential damage, 76 = 72(effective strength) +4(weapon damage)
    // if we have 72 as effective strength and 76 as potential damage, we are sure that
    // we have a weapon damage impact of 4 for Google.
    boolean validateTest = player1Description.contains("Effective Strength Value: 72")
            && matchSummary.contains("Potential Striking Damage for Player Google : 76");
    assertTrue("Potential Striking damage not working", validateTest);
  }

  /**
   * This function is used to test if the player actual damage calculation is working or not
   * during battle.
   */
  @Test
  public void testPlayerActualDamageWorking() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl(
            4, 5, 6, 5, 1, 1, 5, 5, 4, 3, 3, 2, 2, 3, 5, 6, 4, 1,
            6, 4, 1, 3, 2, 4, 2, 4, 3, 6, 5, 4, 6, 5, 3, 1, 2, 3, 5,
            19, -4, -4, -2, -4, -2, -3, -3, -4, -4, -2, -4, -2, -3, -4, -4, -2,
            -3, -3, -2, 26, 2, -1, 1, 2, -2, 3, 3, -2, 3, 2, -1, 2, 4, -1, 3, 3,
            -1, 2, 3, -2, 1, 2, -2, 1, 2, -2, 2, 4, -1, 2, 3, -2, 1, 3, -1, 3, 4,
            -2, 1, 2, -1, 3, 2, -1, 2, 2, -1, 2, 4, -1, 3, 2, -2, 2, 4, -2, 1, 4,
            -2, 3, 4, -1, 1, 4, -2, 3, 4, -2, 2, 2, -2, 3, 3, -1, 2, 3, -1, 3, 71,
            6, 5, 5, 5, 6, 6, 4, 3, 6, 3, 6, 3, 5, 4, 4, 5, 6, 6, 5, 6, 3, 6, 3, 5,
            3, 6, 4, 3, 5, 3, 5, 3, 3, 6, 3, 6, 3, 5, 4, 6, 5, 4, 5, 5, 5, 4, 3, 3, 5,
            4, 5, 3, 3, 4, 5, 5, 5, 6, 3, 5, 3, 5, 6, 3, 6, 6, 4, 6, 6, 4, 5, 6, 6, 6,
            6, 6, 6, 4, 6, 4, 4, 5, 6, 4, 6, 5, 5, 4, 5, 6, 6, 6, 6, 5, 6, 6, 4, 6, 5, 4,
            4, 5, 4, 4, 5, 4, 6, 6, 4, 4, 6, 4, 5, 6, 4, 4, 4, 5, 5, 5, 5, 4, 6, 6, 5, 5,
            4, 5, 5, 6, 5, 6, 5, 4, 4, 7, 4, 3, 2, 2, 127, 142, 5, 155, 89, 130, 60, 103,
            51, 128, 93, 80, 100, 111, 140, 85, 118, 35, 101, 36, 125, 71, 97, 17, 163, 100,
            105, 154, 3, 117, 62, 159, 56, 159, 166, 110, 11, 112, 8, 158, 63, 19, 72, 57, 35,
            159, 142, 6, 42, 141, 113, 1, 151, 117, 140, 74, 13, 128, 129, 8, 107, 124, 74,
            138, 132, 9, 93, 72, 159, 81, 59, 9, 136, 117, 118, 126, 113, 130, 29, 11, 137,
            130, 5, 102, 54, 14, 21, 152, 18, 65, 46, 64, 64, 8, 21, 151, 137, 118, 63, 110,
            151, 116, 152, 115, 14, 118, 15, 147, 66, 136, 2, 89, 57, 103, 65, 148, 157, 44, 16,
            6, 2, 11, 0, 1, 9, 5, 9, 1, 1, 1, 0, 5, 5, 10, 0, 1
    );
    Player player1 = new PlayerImpl("Google", randomizer);
    Player player2 = new PlayerImpl("Apple", randomizer);
    BattleArena battleArena = new BattleArenaImpl(randomizer);
    battleArena.addPlayerToArena(player1);
    battleArena.addPlayerToArena(player2);
    battleArena.equipPlayersForBattle();
    battleArena.gearUpPlayersForBattle();
    String player1Description = battleArena.generatePlayersDescription(player1);
    String player2Description = battleArena.generatePlayersDescription(player2);
    String matchSummary = battleArena.performBattle();
    // for this case, we have taken values in such a way that google has ability values:
    // strength:88, constitution:20, dexterity:2, charisma:23, total = 133
    // striking power = 94
    // for this case, we have taken values in such a way that apple has ability values:
    // strength:11, constitution:13, dexterity:16, charisma:11, total = 127
    // avoidance ability for Apple: 11 = 16(basic) +
    // (-7)(belt gear: -2,-2,-1 and footwear: -2) + 2(random)
    // potential damage from Google = 99 (88(strength) + 11(two-hand sword damage))
    // actual damage = 82 (99(potential damage by google) - 13(constitution of Apple))
    // updated health = 45 (127 - 82)
    boolean validateTest = player1Description.contains("Effective Strength Value: 88")
            && player2Description.contains("Effective Dexterity Value: 9")
            && player2Description.contains("Effective Constitution Value: 17")
            && matchSummary.contains("Potential Striking Damage for Player Google : 99")
            && matchSummary.contains("Actual Damage for Player Google : 82")
            && matchSummary.contains("Player Apple's updated health value: 45");
    assertTrue("Player Health updating not working properly", validateTest);
  }

  /**
   * This function is used to test if the total health calculation is working or not.
   */
  @Test
  public void testPlayerHealthSumWorking() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl(
            4, 5, 6, 5, 1, 1, 5, 5, 4, 3, 3, 2, 2, 3, 5, 6, 4, 1,
            6, 4, 1, 3, 2, 4, 2, 4, 3, 6, 5, 4, 6, 5, 3, 1, 2, 3, 5,
            19, -4, -4, -2, -4, -2, -3, -3, -4, -4, -2, -4, -2, -3, -4, -4, -2,
            -3, -3, -2, 26, 2, -1, 1, 2, -2, 3, 3, -2, 3, 2, -1, 2, 4, -1, 3, 3,
            -1, 2, 3, -2, 1, 2, -2, 1, 2, -2, 2, 4, -1, 2, 3, -2, 1, 3, -1, 3, 4,
            -2, 1, 2, -1, 3, 2, -1, 2, 2, -1, 2, 4, -1, 3, 2, -2, 2, 4, -2, 1, 4,
            -2, 3, 4, -1, 1, 4, -2, 3, 4, -2, 2, 2, -2, 3, 3, -1, 2, 3, -1, 3, 71,
            6, 5, 5, 5, 6, 6, 4, 3, 6, 3, 6, 3, 5, 4, 4, 5, 6, 6, 5, 6, 3, 6, 3, 5,
            3, 6, 4, 3, 5, 3, 5, 3, 3, 6, 3, 6, 3, 5, 4, 6, 5, 4, 5, 5, 5, 4, 3, 3, 5,
            4, 5, 3, 3, 4, 5, 5, 5, 6, 3, 5, 3, 5, 6, 3, 6, 6, 4, 6, 6, 4, 5, 6, 6, 6,
            6, 6, 6, 4, 6, 4, 4, 5, 6, 4, 6, 5, 5, 4, 5, 6, 6, 6, 6, 5, 6, 6, 4, 6, 5, 4,
            4, 5, 4, 4, 5, 4, 6, 6, 4, 4, 6, 4, 5, 6, 4, 4, 4, 5, 5, 5, 5, 4, 6, 6, 5, 5,
            4, 5, 5, 6, 5, 6, 5, 4, 4, 7, 4, 3, 2, 2, 127, 142, 5, 155, 89, 130, 60, 103,
            51, 128, 93, 80, 100, 111, 140, 85, 118, 35, 101, 36, 125, 71, 97, 17, 163, 100,
            105, 154, 3, 117, 62, 159, 56, 159, 166, 110, 11, 112, 8, 158, 63, 19, 72, 57, 35,
            159, 142, 6, 42, 141, 113, 1, 151, 117, 140, 74, 13, 128, 129, 8, 107, 124, 74,
            138, 132, 9, 93, 72, 159, 81, 59, 9, 136, 117, 118, 126, 113, 130, 29, 11, 137,
            130, 5, 102, 54, 14, 21, 152, 18, 65, 46, 64, 64, 8, 21, 151, 137, 118, 63, 110,
            151, 116, 152, 115, 14, 118, 15, 147, 66, 136, 2, 89, 57, 103, 65, 148, 157, 44, 16,
            6, 2, 11, 0, 1, 9, 5, 9, 1, 1, 1, 0, 5, 5, 10, 0, 1
    );
    Player player1 = new PlayerImpl("Google", randomizer);
    Player player2 = new PlayerImpl("Apple", randomizer);
    BattleArena battleArena = new BattleArenaImpl(randomizer);
    battleArena.addPlayerToArena(player1);
    battleArena.addPlayerToArena(player2);
    battleArena.equipPlayersForBattle();
    battleArena.gearUpPlayersForBattle();
    String matchSummary = battleArena.performBattle();
    // for this case, we have taken values in such a way that google has ability values:
    // strength:88, constitution:20, dexterity:2, charisma:23, total = 133
    String player1Description = battleArena.generatePlayersDescription(player1);
    boolean validateTest = matchSummary.contains("Total health of Player Google: 133")
            && player1Description.contains("Effective Strength Value: 88")
            && player1Description.contains("Effective Constitution Value: 20")
            && player1Description.contains("Effective Dexterity Value: 2")
            && player1Description.contains("Effective Charisma Value: 23");
    assertTrue("Player Total health not working", validateTest);
  }

  /**
   * This function is used to test if the actual damage less than zero situation is handled
   * or not.
   */
  @Test
  public void testActualDamageLessThanZero() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl(
            2, 2, 2, 2, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            5, 5, 0, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0
    );
    Player player1 = new PlayerImpl("Google", randomizer);
    Player player2 = new PlayerImpl("Apple", randomizer);
    BattleArena battleArena = new BattleArenaImpl(randomizer);
    battleArena.addPlayerToArena(player1);
    battleArena.addPlayerToArena(player2);
    String matchSummary = battleArena.performBattle();
    boolean validateTest = matchSummary
            .contains("Player Google avoided Player Apple's strike without any damage");
    assertTrue("Actual Damage less than zero not working", validateTest);
  }

  /**
   * This function is used to test if the turn based battle is working correctly or not.
   */
  @Test
  public void testTurnWorkingForBattle() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl(
            4, 5, 6, 5, 1, 1, 5, 5, 4, 3, 3, 2, 2, 3, 5, 6, 4, 1,
            6, 4, 1, 3, 2, 4, 2, 4, 3, 6, 5, 4, 6, 5, 3, 1, 2, 3, 5,
            19, -4, -4, -2, -4, -2, -3, -3, -4, -4, -2, -4, -2, -3, -4, -4, -2,
            -3, -3, -2, 26, 2, -1, 1, 2, -2, 3, 3, -2, 3, 2, -1, 2, 4, -1, 3, 3,
            -1, 2, 3, -2, 1, 2, -2, 1, 2, -2, 2, 4, -1, 2, 3, -2, 1, 3, -1, 3, 4,
            -2, 1, 2, -1, 3, 2, -1, 2, 2, -1, 2, 4, -1, 3, 2, -2, 2, 4, -2, 1, 4,
            -2, 3, 4, -1, 1, 4, -2, 3, 4, -2, 2, 2, -2, 3, 3, -1, 2, 3, -1, 3, 71,
            6, 5, 5, 5, 6, 6, 4, 3, 6, 3, 6, 3, 5, 4, 4, 5, 6, 6, 5, 6, 3, 6, 3, 5,
            3, 6, 4, 3, 5, 3, 5, 3, 3, 6, 3, 6, 3, 5, 4, 6, 5, 4, 5, 5, 5, 4, 3, 3, 5,
            4, 5, 3, 3, 4, 5, 5, 5, 6, 3, 5, 3, 5, 6, 3, 6, 6, 4, 6, 6, 4, 5, 6, 6, 6,
            6, 6, 6, 4, 6, 4, 4, 5, 6, 4, 6, 5, 5, 4, 5, 6, 6, 6, 6, 5, 6, 6, 4, 6, 5, 4,
            4, 5, 4, 4, 5, 4, 6, 6, 4, 4, 6, 4, 5, 6, 4, 4, 4, 5, 5, 5, 5, 4, 6, 6, 5, 5,
            4, 5, 5, 6, 5, 6, 5, 4, 4, 7, 4, 3, 2, 2, 127, 142, 5, 155, 89, 130, 60, 103,
            51, 128, 93, 80, 100, 111, 140, 85, 118, 35, 101, 36, 125, 71, 97, 17, 163, 100,
            105, 154, 3, 117, 62, 159, 56, 159, 166, 110, 11, 112, 8, 158, 63, 19, 72, 57, 35,
            159, 142, 6, 42, 141, 113, 1, 151, 117, 140, 74, 13, 128, 129, 8, 107, 124, 74,
            138, 132, 9, 93, 72, 159, 81, 59, 9, 136, 117, 118, 126, 113, 130, 29, 11, 137,
            130, 5, 102, 54, 14, 21, 152, 18, 65, 46, 64, 64, 8, 21, 151, 137, 118, 63, 110,
            151, 116, 152, 115, 14, 118, 15, 147, 66, 136, 2, 89, 57, 103, 65, 148, 157, 44, 16,
            6, 2, 11, 0, 1, 9, 5, 9, 1, 1, 1, 0, 5, 5, 10, 0, 1
    );
    Player player1 = new PlayerImpl("Google", randomizer);
    Player player2 = new PlayerImpl("Apple", randomizer);
    BattleArena battleArena = new BattleArenaImpl(randomizer);
    battleArena.addPlayerToArena(player1);
    battleArena.addPlayerToArena(player2);
    battleArena.equipPlayersForBattle();
    battleArena.gearUpPlayersForBattle();
    String matchSummary = battleArena.performBattle();
    // for this battle, google takes two turn and apple takes one turn,
    // in the seq - google, apple, google
    boolean validateTest = matchSummary.contains("Turn 1: Player Google strikes")
            && matchSummary.contains("Turn 2: Player Apple strikes")
            && matchSummary.contains("Turn 3: Player Google strikes");
    assertTrue("Turn switch not working", validateTest);
  }

  /**
   * This function is used to test winner player 1 battle game.
   */
  @Test
  public void testWinnerPlayer1Battle() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl(
            4, 5, 6, 5, 1, 1, 5, 5, 4, 3, 3, 2, 2, 3, 5, 6, 4, 1,
            6, 4, 1, 3, 2, 4, 2, 4, 3, 6, 5, 4, 6, 5, 3, 1, 2, 3, 5,
            19, -4, -4, -2, -4, -2, -3, -3, -4, -4, -2, -4, -2, -3, -4, -4, -2,
            -3, -3, -2, 26, 2, -1, 1, 2, -2, 3, 3, -2, 3, 2, -1, 2, 4, -1, 3, 3,
            -1, 2, 3, -2, 1, 2, -2, 1, 2, -2, 2, 4, -1, 2, 3, -2, 1, 3, -1, 3, 4,
            -2, 1, 2, -1, 3, 2, -1, 2, 2, -1, 2, 4, -1, 3, 2, -2, 2, 4, -2, 1, 4,
            -2, 3, 4, -1, 1, 4, -2, 3, 4, -2, 2, 2, -2, 3, 3, -1, 2, 3, -1, 3, 71,
            6, 5, 5, 5, 6, 6, 4, 3, 6, 3, 6, 3, 5, 4, 4, 5, 6, 6, 5, 6, 3, 6, 3, 5,
            3, 6, 4, 3, 5, 3, 5, 3, 3, 6, 3, 6, 3, 5, 4, 6, 5, 4, 5, 5, 5, 4, 3, 3, 5,
            4, 5, 3, 3, 4, 5, 5, 5, 6, 3, 5, 3, 5, 6, 3, 6, 6, 4, 6, 6, 4, 5, 6, 6, 6,
            6, 6, 6, 4, 6, 4, 4, 5, 6, 4, 6, 5, 5, 4, 5, 6, 6, 6, 6, 5, 6, 6, 4, 6, 5, 4,
            4, 5, 4, 4, 5, 4, 6, 6, 4, 4, 6, 4, 5, 6, 4, 4, 4, 5, 5, 5, 5, 4, 6, 6, 5, 5,
            4, 5, 5, 6, 5, 6, 5, 4, 4, 7, 4, 3, 2, 2, 127, 142, 5, 155, 89, 130, 60, 103,
            51, 128, 93, 80, 100, 111, 140, 85, 118, 35, 101, 36, 125, 71, 97, 17, 163, 100,
            105, 154, 3, 117, 62, 159, 56, 159, 166, 110, 11, 112, 8, 158, 63, 19, 72, 57, 35,
            159, 142, 6, 42, 141, 113, 1, 151, 117, 140, 74, 13, 128, 129, 8, 107, 124, 74,
            138, 132, 9, 93, 72, 159, 81, 59, 9, 136, 117, 118, 126, 113, 130, 29, 11, 137,
            130, 5, 102, 54, 14, 21, 152, 18, 65, 46, 64, 64, 8, 21, 151, 137, 118, 63, 110,
            151, 116, 152, 115, 14, 118, 15, 147, 66, 136, 2, 89, 57, 103, 65, 148, 157, 44, 16,
            6, 2, 11, 0, 1, 9, 5, 9, 1, 1, 1, 0, 5, 5, 10, 0, 1
    );
    Player player1 = new PlayerImpl("Google", randomizer);
    Player player2 = new PlayerImpl("Apple", randomizer);
    BattleArena battleArena = new BattleArenaImpl(randomizer);
    battleArena.addPlayerToArena(player1);
    battleArena.addPlayerToArena(player2);
    battleArena.equipPlayersForBattle();
    battleArena.gearUpPlayersForBattle();
    String matchSummary = battleArena.performBattle();
    boolean validateTest = matchSummary.contains("Winner Player Name: Google");
    assertTrue("Winner Player 1 not working", validateTest);
  }

  /**
   * This function is used to test winner player 2 battle game.
   */
  @Test
  public void testWinnerPlayer2Battle() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl(
            6, 1, 6, 2, 2, 5, 4, 4, 4, 5, 3, 2, 2, 2, 6, 4, 4, 4, 1, 4, 4,
            5, 1, 2, 2, 2, 6, 6, 3, 3, 4, 1, 4, 1, 1, 6, 2, 6, 18, -4, -2, -2, -4, -4, -3,
            -3, -2, -2, -4, -4, -2, -3, -2, -3, -2, -2, -4, 18, 3, -2, 3, 4, -1, 2, 2,
            -2, 3, 2, -2, 3, 3, -1, 3, 4, -1, 2, 3, -1, 3, 2, -1, 1, 3, -1, 1, 4, -2, 1, 3,
            -2, 2, 3, -2, 2, 2, -2, 2, 4, -2, 1, 4, -1, 3, 2, -2, 2, 3, -1, 2, 3, -1, 3, 71,
            4, 4, 6, 3, 3, 5, 3, 4, 4, 4, 4, 3, 5, 4, 3, 3, 5, 4, 6, 4, 6, 5, 3, 4, 3, 5, 6,
            5, 6, 3, 4, 5, 4, 5, 5, 4, 3, 4, 6, 4, 4, 5, 4, 4, 3, 4, 4, 3, 5, 4, 4, 4, 4, 4,
            6, 6, 5, 3, 6, 6, 6, 6, 3, 4, 4, 3, 5, 5, 3, 5, 4, 6, 5, 4, 5, 5, 5, 6, 5, 5, 4,
            6, 4, 6, 5, 5, 6, 4, 6, 6, 5, 5, 6, 6, 6, 4, 4, 5, 6, 6, 4, 6, 6, 6, 4, 6, 6, 6,
            16, 5, 8, 2, 6, 142, 21, 120, 120, 9, 58, 42, 127, 62, 25, 119, 71, 84,
            131, 60, 130, 78, 79, 10, 25, 112, 39, 115, 119, 111, 44, 66, 112, 65, 7, 39, 66,
            68, 46, 128, 22, 11, 127, 115, 99, 12, 23, 7, 84, 86, 10, 99, 63, 84, 35, 66, 30,
            12, 87, 110, 69, 112, 48, 52, 58, 35, 40, 84, 107, 76, 45, 42, 39, 110, 80, 12, 80,
            73, 1, 23, 5, 5, 4, 1, 4, 3, 6, 0, 10, 6, 4, 1, 1, 4, 6, 1, 1, 1, 1, 0
    );
    Player player1 = new PlayerImpl("Google", randomizer);
    Player player2 = new PlayerImpl("Apple", randomizer);
    BattleArena battleArena = new BattleArenaImpl(randomizer);
    battleArena.addPlayerToArena(player1);
    battleArena.addPlayerToArena(player2);
    battleArena.equipPlayersForBattle();
    battleArena.gearUpPlayersForBattle();
    String matchSummary = battleArena.performBattle();
    boolean validateTest = matchSummary.contains("Winner Player Name: Apple");
    assertTrue("Winner Player 2 not working", validateTest);
  }

  /**
   * This function is used to test basic ability and bare hand battle.
   */
  @Test
  public void testBasicAbilityBareHandBattle() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl(
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0,
            5, 5, 1,
            5, 5, 4, 0
    );
    Player player1 = new PlayerImpl("Google", randomizer);
    Player player2 = new PlayerImpl("Apple", randomizer);
    BattleArena battleArena = new BattleArenaImpl(randomizer);
    battleArena.addPlayerToArena(player1);
    battleArena.addPlayerToArena(player2);
    String matchSummary = battleArena.performBattle();
    boolean validateTest = matchSummary.contains("Winner Player Name: Apple");
    assertTrue("Bare hand and basic ability battle not working", validateTest);
  }

  /**
   * This function is used to test weapon damage done is in valid range or not.
   */
  @Test
  public void testDamageForValidRangeDuringBattle() {
    RandomNumberGenerator randomizer = new RandomNumberGeneratorImpl(
            6, 1, 6, 2, 2, 5, 4, 4, 4, 5, 3, 2, 2, 2, 6, 4, 4, 4, 1, 4, 4,
            5, 1, 2, 2, 2, 6, 6, 3, 3, 4, 1, 4, 1, 1, 6, 2, 6, 18, -4, -2, -2, -4, -4, -3,
            -3, -2, -2, -4, -4, -2, -3, -2, -3, -2, -2, -4, 18, 3, -2, 3, 4, -1, 2, 2,
            -2, 3, 2, -2, 3, 3, -1, 3, 4, -1, 2, 3, -1, 3, 2, -1, 1, 3, -1, 1, 4, -2, 1, 3,
            -2, 2, 3, -2, 2, 2, -2, 2, 4, -2, 1, 4, -1, 3, 2, -2, 2, 3, -1, 2, 3, -1, 3, 71,
            4, 4, 6, 3, 3, 5, 3, 4, 4, 4, 4, 3, 5, 4, 3, 3, 5, 4, 6, 4, 6, 5, 3, 4, 3, 5, 6,
            5, 6, 3, 4, 5, 4, 5, 5, 4, 3, 4, 6, 4, 4, 5, 4, 4, 3, 4, 4, 3, 5, 4, 4, 4, 4, 4,
            6, 6, 5, 3, 6, 6, 6, 6, 3, 4, 4, 3, 5, 5, 3, 5, 4, 6, 5, 4, 5, 5, 5, 6, 5, 5, 4,
            6, 4, 6, 5, 5, 6, 4, 6, 6, 5, 5, 6, 6, 6, 4, 4, 5, 6, 6, 4, 6, 6, 6, 4, 6, 6, 6,
            16, 5, 8, 2, 6, 142, 21, 120, 120, 9, 58, 42, 127, 62, 25, 119, 71, 84,
            131, 60, 130, 78, 79, 10, 25, 112, 39, 115, 119, 111, 44, 66, 112, 65, 7, 39, 66,
            68, 46, 128, 22, 11, 127, 115, 99, 12, 23, 7, 84, 86, 10, 99, 63, 84, 35, 66, 30,
            12, 87, 110, 69, 112, 48, 52, 58, 35, 40, 84, 107, 76, 45, 42, 39, 110, 80, 12, 80,
            73, 1, 23, 5, 5, 4, 1, 4, 3, 6, 0, 10, 6, 4, 1, 1, 4, 6, 1, 1, 1, 1, 0
    );
    Player player1 = new PlayerImpl("Google", randomizer);
    Player player2 = new PlayerImpl("Apple", randomizer);
    BattleArena battleArena = new BattleArenaImpl(randomizer);
    battleArena.addPlayerToArena(player1);
    battleArena.addPlayerToArena(player2);
    battleArena.equipPlayersForBattle();
    battleArena.gearUpPlayersForBattle();
    String player1Description = battleArena.generatePlayersDescription(player1);
    String matchSummary = battleArena.performBattle();
    //Here the weapon selected for Google is katana which has a range of 4 to 6
    // For this test, the value selected is 4.
    // for potential damage, 76 = 72(effective strength) +4(weapon damage)
    // if we have 72 as effective strength and 76 as potential damage, we are sure that
    // we have a weapon damage impact of 4 for Google.
    boolean validateTest = player1Description.contains("Effective Strength Value: 72")
            && matchSummary.contains("Potential Striking Damage for Player Google : 76");
    assertTrue("Damage not coming a specified range", validateTest);
  }

  /**
   * This function is used to test if invalid player description is generated or not.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGeneratePlayersDescription() {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGeneratorImpl();
    BattleArena battleArena = new BattleArenaImpl(randomNumberGenerator);
    battleArena.generatePlayersDescription(null);
  }
}