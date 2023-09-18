package game;

import java.util.List;

/**
 * This interface represents a player entity in the battle arena. It holds all the different
 * ability values of the player. Apart from that, it consists of the information about the
 * weapons and gears picked up by the player.
 */
public interface Player {

  /**
   * This enum is used to represent the player's different ability which is used
   * as part of the battle.
   */
  enum Ability {
    STRENGTH,
    CONSTITUTION,
    DEXTERITY,
    CHARISMA
  }

  /**
   * This function is used to get the player name.
   *
   * @return Name of the player.
   */
  String getPlayerName();

  /**
   * This function is used to get the effective strength value.
   *
   * @return strength value of the player
   */
  int getEffectiveStrengthValue();

  /**
   * This function is used to get the effective constitution value.
   *
   * @return constitution value of the player
   */
  int getEffectiveConstitutionValue();

  /**
   * This function is used to get the effective dexterity value.
   *
   * @return dexterity value of the player
   */
  int getEffectiveDexterityValue();

  /**
   * This function is used to get the effective charisma value.
   *
   * @return charisma value of the player
   */
  int getEffectiveCharismaValue();

  /**
   * This function is used to get the basic strength value.
   *
   * @return strength value of the player
   */
  int getBasicStrengthValue();

  /**
   * This function is used to get the basic constitution value.
   *
   * @return constitution value of the player
   */
  int getBasicConstitutionValue();

  /**
   * This function is used to get the basic dexterity value.
   *
   * @return dexterity value of the player
   */
  int getBasicDexterityValue();

  /**
   * This function is used to get the basic charisma value.
   *
   * @return charisma value of the player
   */
  int getBasicCharismaValue();

  /**
   * This function is used to assign gear to the player.
   *
   * @param gear gear to be assigned
   * @throws IllegalArgumentException if the gear is null
   */
  void assignGear(Gear gear) throws IllegalArgumentException;

  /**
   * This function is used to put all the gears on before battle.
   */
  void gearUp();

  /**
   * This function is used to assign weapons to the player.
   *
   * @param weaponList list of weapons to be assigned (mostly one weapon but
   *                   could be two for katana)
   * @throws IllegalArgumentException if the list of weapons is null
   */
  void assignWeapons(List<Weapon> weaponList) throws IllegalArgumentException;

  /**
   * This function is used to check if the given gear can be acquired by the player or not.
   *
   * @param gear to be validated
   * @return true if gear can be acquired else false
   * @throws IllegalArgumentException if the gear is null
   */
  boolean validateGearSelection(Gear gear) throws IllegalArgumentException;

  /**
   * This function is used to get the list of weapons equipped by the player.
   *
   * @return list of the weapons (mostly one weapon but two for katana)
   */
  List<Weapon> getEquippedWeapons();

  /**
   * This function is used to get equipped gear list for the player.
   *
   * @return list of equipped gear
   */
  List<Gear> getEquippedGears();
}
