package game;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the weapon type data which is associated to each weapon. It also includes
 * information on the max and min effective damage for the respective weapon.
 */
public class WeaponTypeDataImpl implements WeaponTypeData {

  private final List<Integer> effectiveDamageRange;
  private final String weaponTypeName;
  private final WeaponType weaponType;

  /**
   * This function is used to create weapon type data for a given weapon type with damage range.
   *
   * @param weaponType         type of the weapon
   * @param weaponTypeName     name of the type of the weapon
   * @param minimumDamageRange minimum damage range of the weapon
   * @param maxDamageRange     maximum damage range of the weapon
   * @throws IllegalArgumentException if weapon type or weapon type name is null
   */
  public WeaponTypeDataImpl(WeaponType weaponType, String weaponTypeName, int minimumDamageRange,
                            int maxDamageRange) throws IllegalArgumentException {
    if (weaponType == null || weaponTypeName == null) {
      throw new IllegalArgumentException("Invalid weapon type or weapon type name");
    }
    this.weaponTypeName = weaponTypeName;
    this.weaponType = weaponType;
    this.effectiveDamageRange = new ArrayList<>();
    this.effectiveDamageRange.add(minimumDamageRange);
    this.effectiveDamageRange.add(maxDamageRange);
  }

  /**
   * This function is used to copy values from instance to another.
   *
   * @param existingWeaponTypeData existing instance of WeaponTypeData
   * @throws IllegalArgumentException if the parameter passed is null
   */
  public WeaponTypeDataImpl(WeaponTypeData existingWeaponTypeData) throws IllegalArgumentException {
    if (existingWeaponTypeData == null) {
      throw new IllegalArgumentException("Invalid weapon type data passed.");
    }
    this.weaponTypeName = existingWeaponTypeData.getWeaponTypeName();
    this.weaponType = existingWeaponTypeData.getWeaponType();
    this.effectiveDamageRange = new ArrayList<>();
    this.effectiveDamageRange.add(existingWeaponTypeData.getMinimumDamageValue());
    this.effectiveDamageRange.add(existingWeaponTypeData.getMaximumDamageValue());
  }

  @Override
  public String getWeaponTypeName() {
    return weaponTypeName;
  }

  @Override
  public WeaponType getWeaponType() {
    return weaponType;
  }

  @Override
  public int getMinimumDamageValue() {
    return effectiveDamageRange.get(0);
  }

  @Override
  public void updateMinimumDamageValue(int updatedMinDamageValue) {
    effectiveDamageRange.set(0, updatedMinDamageValue);
  }

  @Override
  public int getMaximumDamageValue() {
    return effectiveDamageRange.get(1);
  }

  @Override
  public void updateMaximumDamageValue(int updatedMaxDamageValue) {
    effectiveDamageRange.set(1, updatedMaxDamageValue);
  }
}
