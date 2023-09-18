package game;

/**
 * This class represents a weapon that can be used by any player as part of the battle.
 * It contains the type of the weapon, name and also the damage range.
 */
public class WeaponImpl implements Weapon {

  private final String weaponName;
  private final WeaponTypeData weaponTypeData;
  private final RandomNumberGenerator randomizer;

  /**
   * This function is used to create a weapon based on the parameters provided.
   *
   * @param weaponName     name of the weapon
   * @param weaponTypeData type data of the weapon
   * @param randomizer     randomizer instance
   * @throws IllegalArgumentException if the weapon name or weapon type data is null
   */
  public WeaponImpl(String weaponName, WeaponTypeData weaponTypeData,
                    RandomNumberGenerator randomizer)
          throws IllegalArgumentException {
    if (weaponName == null || weaponTypeData == null || randomizer == null) {
      throw new IllegalArgumentException("Invalid weapon name or weapon type data or randomizer");
    }
    this.weaponName = weaponName;
    this.weaponTypeData = weaponTypeData;
    this.randomizer = randomizer;
  }

  @Override
  public int getEffectiveDamage() {
    return randomizer
            .generateRandomValueForRange(weaponTypeData.getMinimumDamageValue(),
                    weaponTypeData.getMaximumDamageValue() + 1);
  }

  @Override
  public String getWeaponName() {
    return weaponName;
  }

  @Override
  public WeaponTypeData getWeaponTypeData() {
    return new WeaponTypeDataImpl(weaponTypeData);
  }

}
