package game;

/**
 * This interface represents a gear which a player can equip during the battle. A gear can have
 * a positive or negative effect on the overall health of the player.
 */
public interface Gear extends Comparable<Gear> {

  /**
   * This enum is used to represent the gear type for different gears.
   */
  enum GearType {
    FOOTWEAR(4),
    HEADGEAR(1),
    BELTS(3),
    POTIONS(2);

    private final int priority;

    GearType(int priority) {
      this.priority = priority;
    }

    int getPriority() {
      return priority;
    }
  }

  /**
   * This function is used to get the gear name for the gear.
   *
   * @return name of the gear
   */
  String getGearName();

  /**
   * This function is used to get the gear type of the current gear.
   *
   * @return gear type data instance of the gear
   */
  GearTypeData getGearTypeData();

  /**
   * This function is used to get the subtype of belt gear.
   *
   * @return Belt gear type
   * @throws UnsupportedOperationException if the operation is called by a
   *                                       gear which is not belt type
   */
  GearTypeData.BeltType getBeltType() throws UnsupportedOperationException;

  /**
   * This function is used to get belt unit type.
   *
   * @return belt units associated to the belt gear
   * @throws UnsupportedOperationException if this function is called for gear type other than belt
   */
  int getBeltUnits() throws UnsupportedOperationException;

  /**
   * This function is used to get effective ability value for given ability.
   *
   * @param ability ability for which the effective value has to be provided
   * @return effective value
   * @throws IllegalArgumentException if the ability is null.
   */
  int getEffectiveAbilityValue(Player.Ability ability) throws IllegalArgumentException;

}
