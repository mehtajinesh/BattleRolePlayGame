package game;

/**
 * This interface is used to represent the weapon type data for the different weapon types.
 */
public interface WeaponTypeData {
  /**
   * This enum is used to represent the weapon type.
   */
  enum WeaponType {
    BARE_HANDS,
    KATANAS,
    BROADSWORDS,
    TWO_HANDED_SWORDS,
    AXES,
    FLAILS
  }

  /**
   * This function is used to get the weapon type.
   * @return type of the weapon
   */
  WeaponType getWeaponType();

  /**
   * This function is used to get the weapon type name.
   * @return name of the weapon type
   */
  String getWeaponTypeName();

  /**
   * This function is used to get minimum damage value.
   *
   * @return the minimum damage value
   */
  int getMinimumDamageValue();

  /**
   * This function is used to update minimum damage value.
   *
   * @param updatedMinDamageValue updated minimum damage value
   */
  void updateMinimumDamageValue(int updatedMinDamageValue);

  /**
   * This function is used to get maximum damage value.
   *
   * @return maximum damage value.
   */
  int getMaximumDamageValue();

  /**
   * This function is used to get the updated maximum damage value.
   *
   * @param updatedMaxDamageValue updated maximum damage value
   */
  void updateMaximumDamageValue(int updatedMaxDamageValue);

}
