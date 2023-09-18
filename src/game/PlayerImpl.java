package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents a player entity in the battle arena. It holds all the different
 * ability values of the player. Apart from that, it consists of the information about the
 * weapons and gears picked up by the player.
 */
public class PlayerImpl implements Player {
  private final String playerName;
  private final Map<Ability, Integer> abilityBasicValueHashMap;
  private final Map<Ability, Integer> abilityEffectiveValueHashMap;
  private List<Weapon> acquiredWeapons;
  private final List<Gear> acquiredGears;
  private int beltUnitCount;
  private final RandomNumberGenerator randomizer;

  /**
   * This function is used to create a player instance with the given player name.
   *
   * @param playerName name of the player
   * @param randomizer randomizer instance
   * @throws IllegalArgumentException if the player name is null or empty or randomizer is null
   */
  public PlayerImpl(String playerName, RandomNumberGenerator randomizer)
          throws IllegalArgumentException {
    if (playerName == null || randomizer == null) {
      throw new IllegalArgumentException("player name cannot be null");
    }
    if (playerName.isEmpty()) {
      throw new IllegalArgumentException("player name cannot be empty");
    }
    this.randomizer = randomizer;
    this.playerName = playerName;
    this.acquiredWeapons = new ArrayList<>();
    this.acquiredGears = new ArrayList<>();
    this.abilityBasicValueHashMap = new HashMap<>();
    this.abilityEffectiveValueHashMap = new HashMap<>();
    beltUnitCount = 0;
    generateRandomValuesForPlayerAbility();
    createDefaultWeapon();
  }

  /**
   * This function is used to generate the random value for each ability.
   */
  private void generateRandomValuesForPlayerAbility() {
    for (Ability ability : Ability.values()) {
      //for each ability
      // generate four numbers in the range 1-6
      List<Integer> randomNumbersFromDice = new ArrayList<>();
      for (int counter = 0; counter < 4; counter++) {
        int randomNumber = randomizer.generateRandomValueForRange(1, 7);
        while (true) {
          if (randomNumber != 1) {
            break;
          } else {
            randomNumber = randomizer.generateRandomValueForRange(1, 7);
          }
        }

        randomNumbersFromDice.add(randomNumber);
      }
      // take the max. three and sum the values
      int totalAbilityValue = 0;
      randomNumbersFromDice.sort(Collections.reverseOrder());
      for (int counter = 0; counter < 3; counter++) {
        totalAbilityValue += randomNumbersFromDice.get(counter);
      }
      // store that value for the respective ability
      abilityBasicValueHashMap.put(ability, totalAbilityValue);
      abilityEffectiveValueHashMap.put(ability, totalAbilityValue);
    }
  }

  /**
   * This function is used to create a default weapon for the player.
   */
  private void createDefaultWeapon() {
    WeaponTypeData weaponTypeData = new WeaponTypeDataImpl(WeaponTypeData.WeaponType.BARE_HANDS,
            "Bare Hands", 0, 4);
    Weapon defaultWeapon = new WeaponImpl("Hands", weaponTypeData, randomizer);
    acquiredWeapons.add(defaultWeapon);
  }

  @Override
  public String getPlayerName() {
    return playerName;
  }

  @Override
  public int getEffectiveStrengthValue() {
    return abilityEffectiveValueHashMap.get(Ability.STRENGTH);
  }

  @Override
  public int getEffectiveConstitutionValue() {
    return abilityEffectiveValueHashMap.get(Ability.CONSTITUTION);
  }

  @Override
  public int getEffectiveDexterityValue() {
    return abilityEffectiveValueHashMap.get(Ability.DEXTERITY);
  }

  @Override
  public int getEffectiveCharismaValue() {
    return abilityEffectiveValueHashMap.get(Ability.CHARISMA);
  }

  @Override
  public int getBasicStrengthValue() {
    return abilityBasicValueHashMap.get(Ability.STRENGTH);
  }

  @Override
  public int getBasicConstitutionValue() {
    return abilityBasicValueHashMap.get(Ability.CONSTITUTION);
  }

  @Override
  public int getBasicDexterityValue() {
    return abilityBasicValueHashMap.get(Ability.DEXTERITY);
  }

  @Override
  public int getBasicCharismaValue() {
    return abilityBasicValueHashMap.get(Ability.CHARISMA);
  }

  @Override
  public void assignGear(Gear gear) throws IllegalArgumentException {
    if (gear == null) {
      throw new IllegalArgumentException("Gear cannot be null");
    }
    GearTypeData gearTypeData = gear.getGearTypeData();
    if (gearTypeData.getGearType() == Gear.GearType.BELTS) {
      int beltUnits = gear.getBeltUnits();
      beltUnitCount += beltUnits;
    }
    acquiredGears.add(gear);
  }

  @Override
  public void gearUp() {
    for (Gear gear : acquiredGears) {
      //get affecting abilities
      List<GearAbilityEffect> gearAbilityEffectList = gear.getGearTypeData()
              .getEffectiveAbilities();
      for (GearAbilityEffect gearAbilityEffect : gearAbilityEffectList) {
        Ability ability = gearAbilityEffect.getGearAbility();
        int existingAbilityValue = abilityEffectiveValueHashMap.get(ability);
        int temporaryEffectValue = gear.getEffectiveAbilityValue(ability);
        abilityEffectiveValueHashMap.put(ability, existingAbilityValue + temporaryEffectValue);
      }
    }
  }

  @Override
  public boolean validateGearSelection(Gear selectedGear) throws IllegalArgumentException {
    if (selectedGear == null) {
      throw new IllegalArgumentException("selected gear cannot be null");
    }
    GearTypeData selectedGearTypeData = selectedGear.getGearTypeData();
    for (Gear acquiredGear : acquiredGears) {
      GearTypeData acquiredGearTypeData = acquiredGear.getGearTypeData();
      // check if there is already on headgear assigned
      if ((acquiredGearTypeData.getGearType() == Gear.GearType.HEADGEAR)
              && (selectedGearTypeData.getGearType() == Gear.GearType.HEADGEAR)) {
        return false;
      }
      // check if there is already a footwear assigned
      if ((acquiredGearTypeData.getGearType() == Gear.GearType.FOOTWEAR)
              && (selectedGearTypeData.getGearType() == Gear.GearType.FOOTWEAR)) {
        return false;
      }
      // check if the belt unit upper limit is already reached or not
      if (selectedGearTypeData.getGearType() == Gear.GearType.BELTS) {
        if (beltUnitCount + selectedGear.getBeltUnits() > 10) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public void assignWeapons(List<Weapon> weaponList) throws IllegalArgumentException {
    if (weaponList == null) {
      throw new IllegalArgumentException("Weapon lists cannot be empty");
    }
    for (Weapon weapon : weaponList) {
      WeaponTypeData weaponTypeData = weapon.getWeaponTypeData();
      boolean twoHeadedSwordCondition = (weaponTypeData.getWeaponType()
              == WeaponTypeData.WeaponType.TWO_HANDED_SWORDS)
              && (getBasicStrengthValue() <= 14);
      boolean flailsCondition = (weaponTypeData.getWeaponType()
              == WeaponTypeData.WeaponType.FLAILS)
              && (getBasicDexterityValue() <= 14);
      if (flailsCondition || twoHeadedSwordCondition) {
        weaponTypeData.updateMinimumDamageValue(weaponTypeData.getMinimumDamageValue() / 2);
        weaponTypeData.updateMaximumDamageValue(weaponTypeData.getMaximumDamageValue() / 2);
      }
    }
    acquiredWeapons = weaponList;
  }

  @Override
  public List<Weapon> getEquippedWeapons() {
    return new ArrayList<>(acquiredWeapons);
  }

  @Override
  public List<Gear> getEquippedGears() {
    return new ArrayList<>(acquiredGears);
  }
}
