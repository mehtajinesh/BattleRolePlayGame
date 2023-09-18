package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents the battle arena where the battle is performed.
 * All the players equip themselves for battle here and also gear up here
 * before going to battle.
 */
public class BattleArenaImpl implements BattleArena {

  private final List<Player> listPlayers;
  private final RandomNumberGenerator randomizer;

  /**
   * his function is used to create battle arena instance.
   *
   * @param randomizer randomizer instance
   * @throws IllegalArgumentException if randomizer is null
   */
  public BattleArenaImpl(RandomNumberGenerator randomizer) throws IllegalArgumentException {
    if (randomizer == null) {
      throw new IllegalArgumentException("Randomizer cannot be null");
    }
    this.listPlayers = new ArrayList<>();
    this.randomizer = randomizer;
  }

  @Override
  public void addPlayerToArena(Player player)
          throws IllegalArgumentException {
    if (player == null) {
      throw new IllegalArgumentException("Player cannot be null");
    }
    listPlayers.add(player);
  }

  @Override
  public void equipPlayersForBattle() {
    EquipmentRoom equipmentRoom = new EquipmentRoomImpl(randomizer);
    for (Player player : listPlayers) {
      equipmentRoom.chooseGearForPlayer(player);
      equipmentRoom.chooseWeaponForPlayer(player);
    }
  }

  @Override
  public void gearUpPlayersForBattle() {
    for (Player player : listPlayers) {
      player.gearUp();
    }
  }

  @Override
  public String generatePlayersDescription(Player player) throws IllegalArgumentException {
    if (player == null) {
      throw new IllegalArgumentException("Player cannot be null");
    }
    StringBuilder playerDescription = new StringBuilder();
    //add player name information
    String playerName = player.getPlayerName();
    playerDescription.append(String.format("\nPlayer Name: %s \n", playerName));
    //add abilities with values information
    playerDescription.append(String.format("Basic Strength Value: %s \n",
            player.getBasicStrengthValue()));
    playerDescription.append(String.format("Basic Constitution Value: %s \n",
            player.getBasicConstitutionValue()));
    playerDescription.append(String.format("Basic Dexterity Value: %s \n",
            player.getBasicDexterityValue()));
    playerDescription.append(String.format("Basic Charisma Value: %s \n",
            player.getBasicCharismaValue()));
    playerDescription.append(String.format("Effective Strength Value: %s \n",
            player.getEffectiveStrengthValue()));
    playerDescription.append(String.format("Effective Constitution Value: %s \n",
            player.getEffectiveConstitutionValue()));
    playerDescription.append(String.format("Effective Dexterity Value: %s \n",
            player.getEffectiveDexterityValue()));
    playerDescription.append(String.format("Effective Charisma Value: %s \n",
            player.getEffectiveCharismaValue()));
    // add gear information
    playerDescription.append("Gears equipped: \n");
    List<Gear> equippedGears = player.getEquippedGears();
    playerDescription.append(String.format("Total Gears: %s\n", equippedGears.size()));
    //sort gears
    Collections.sort(equippedGears);
    for (Gear gear : equippedGears) {
      //for each gear
      //add gear name
      playerDescription.append(String.format("Gear name: %s\n", gear.getGearName()));
      GearTypeData gearTypeData = gear.getGearTypeData();
      //add gear type
      playerDescription.append(String.format("Gear type: %s\n",
              gearTypeData.getGearTypeName()));
      if (gearTypeData.getGearType() == Gear.GearType.BELTS) {
        playerDescription.append(String.format("Belt type: %s\n",
                gear.getBeltType().name()));
      }
      List<GearAbilityEffect> gearAbilityEffectList = gearTypeData.getEffectiveAbilities();
      for (GearAbilityEffect gearAbilityEffect : gearAbilityEffectList) {
        Player.Ability ability = gearAbilityEffect.getGearAbility();
        //add ability and the affected value
        playerDescription.append(String.format("Ability Affected: %s, by Value: %s\n",
                ability.name(), gear.getEffectiveAbilityValue(ability)));
      }
    }
    // add weapon information
    playerDescription.append("Weapon(s) carried: \n");
    List<Weapon> weaponsList = player.getEquippedWeapons();
    playerDescription.append(String.format("Total Weapons: %s\n", weaponsList.size()));
    for (Weapon weapon : weaponsList) {
      playerDescription.append(weapon.getWeaponName()).append("\n");
    }
    return playerDescription.toString();
  }

  @Override
  public String performBattle() throws IllegalStateException {
    StringBuilder matchSummary = new StringBuilder();
    if (listPlayers.size() < 2) {
      throw new IllegalStateException("Cannot equip players ");
    }
    // decide the current player based on higher charisma
    Player currentPlayer = listPlayers.get(0);
    for (Player player : listPlayers) {
      if (player.getEffectiveCharismaValue() > currentPlayer.getEffectiveCharismaValue()) {
        currentPlayer = player;
      }
    }
    matchSummary.append(String.format("Player with higher charisma value: %s\n",
            currentPlayer.getPlayerName()));
    //calculate and store total health of both players
    Map<Player, Integer> playerTotalHealth = new HashMap<>();
    for (Player player : listPlayers) {
      int totalHealth = player.getEffectiveStrengthValue() + player.getEffectiveConstitutionValue()
              + player.getEffectiveDexterityValue() + player.getEffectiveCharismaValue();
      playerTotalHealth.put(player, totalHealth);
      matchSummary.append(String.format("Total health of Player %s: %s\n",
              player.getPlayerName(), totalHealth));
    }
    int turnCount = 0;
    //while either of the health is less than or equal to zero
    while (!checkForZeroOrLessHealthForPlayers(playerTotalHealth)) {
      matchSummary.append(String.format("Turn %s: Player %s strikes\n",
              turnCount + 1, currentPlayer.getPlayerName()));
      //calculate striking power of current player
      int strikingPower = currentPlayer.getEffectiveStrengthValue()
              + randomizer.generateRandomValueForRange(1, 11);
      matchSummary.append(String.format("Player %s's Striking Power: %s\n",
              currentPlayer.getPlayerName(), strikingPower));
      //calculate avoidance ability of other players
      for (Player player : listPlayers) {
        if (player == currentPlayer) {
          continue;
        }
        int avoidanceAbility = player.getEffectiveDexterityValue()
                + randomizer.generateRandomValueForRange(1, 7);
        matchSummary.append(String.format("Player %s's Avoidance Ability: %s\n",
                player.getPlayerName(), avoidanceAbility));
        //if SP > AA
        if (strikingPower > avoidanceAbility) {
          matchSummary.append(String.format("Player %s successfully hit Player %s \n",
                  currentPlayer.getPlayerName(), player.getPlayerName()));
          //calculate potential striking damage
          int potentialStrikingDamage = currentPlayer.getEffectiveStrengthValue()
                  + currentPlayer.getEquippedWeapons().get(0).getEffectiveDamage();
          matchSummary.append(String.format("Potential Striking Damage for Player %s : %s \n",
                  currentPlayer.getPlayerName(), potentialStrikingDamage));
          //calculate actual damage
          int actualStrikeDamage = potentialStrikingDamage - player.getEffectiveConstitutionValue();
          matchSummary.append(String.format("Actual Damage for Player %s : %s \n",
                  currentPlayer.getPlayerName(), actualStrikeDamage));
          // if actual damage > 0
          if (actualStrikeDamage > 0) {
            // update other player health by subtracting the actual damage from health
            int existingHealth = playerTotalHealth.get(player);
            int updatedHealth = existingHealth - actualStrikeDamage;
            playerTotalHealth.put(player, updatedHealth);
            matchSummary.append(String.format("Player %s's updated health value: %s \n",
                    player.getPlayerName(), updatedHealth));
          } else {
            matchSummary.append(String.format("Player %s avoided Player %s's "
                            + "strike without any damage\n",
                    player.getPlayerName(), currentPlayer.getPlayerName()));
          }
        }
      }
      // switch to next player randomly
      int currentPlayerIndex = listPlayers.indexOf(currentPlayer);
      int nextRandomPlayerIndex;
      do {
        nextRandomPlayerIndex = randomizer.generateRandomValueForRange(0, listPlayers.size());
      }
      while (currentPlayerIndex == nextRandomPlayerIndex);
      currentPlayer = listPlayers.get(nextRandomPlayerIndex);
      turnCount++;
    }

    matchSummary.append("Battle Result: \n");
    for (Player player : playerTotalHealth.keySet()) {
      if (playerTotalHealth.get(player) > 0) {
        matchSummary.append("Winner Player Name: ").append(player.getPlayerName()).append("\n");
      }
    }
    if (matchSummary.toString().length() == 0) {
      matchSummary.append("Match Tied");
    }
    return matchSummary.toString();
  }

  /**
   * This function is used to check for zero or less health for any player during battle.
   *
   * @param playerTotalHealth player along with their total health
   * @return true if any player has health less than zero
   */
  private boolean checkForZeroOrLessHealthForPlayers(Map<Player, Integer> playerTotalHealth) {
    for (Player player : playerTotalHealth.keySet()) {
      if (playerTotalHealth.get(player) <= 0) {
        return true;
      }
    }
    return false;
  }
}
