package game;

/**
 * This interface represents a weapon which will be used in the battle to
 * make damage to the opponent.
 */
public interface Weapon {

  /**
   * This function is used to get the weapon name.
   *
   * @return name of the weapon
   */
  String getWeaponName();

  /**
   * This function is used to get the weapon type data for the current weapon.
   *
   * @return weapon type data for weapon
   */
  WeaponTypeData getWeaponTypeData();

  /**
   * This function is used to get the effective weapon damage.
   *
   * @return effective damage value
   */
  int getEffectiveDamage();
}
