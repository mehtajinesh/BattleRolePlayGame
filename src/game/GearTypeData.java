package game;

import java.util.List;

/**
 * This interface is used to represent the gear type data for the different gear types.
 */
public interface GearTypeData {

  /**
   * This enum is used to represent the belt type along with the unit value associated to it.
   */
  enum BeltType {
    BELT_INVALID(-1),
    BELT_SMALL(1),
    BELT_MEDIUM(2),
    BELT_LARGE(4);

    private final int unitValue;

    BeltType(int value) {
      this.unitValue = value;
    }

    int getUnitValue() {
      return unitValue;
    }
  }

  /**
   * This function is used to get the gear type name.
   *
   * @return name of the gear type
   */
  String getGearTypeName();

  /**
   * This function is used to get the gear type.
   *
   * @return gear type enum data
   */
  Gear.GearType getGearType();

  /**
   * This function is used to add ability to the gear type.
   *
   * @param gearAbilityEffect ability effect to be added to the gear type
   * @throws IllegalArgumentException if the ability effect is null
   */
  void addAbilityEffectToGearType(GearAbilityEffect gearAbilityEffect)
          throws IllegalArgumentException;

  /**
   * This function is used to get all the abilities affecting due to this gear type.
   *
   * @return list of all affecting abilities
   */
  List<GearAbilityEffect> getEffectiveAbilities();
}
