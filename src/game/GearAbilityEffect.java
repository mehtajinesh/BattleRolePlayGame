package game;

/**
 * This interface is used to capture the gear ability data, including the max. and min. damage
 * incurred on an ability due to a specific gear.
 */
public interface GearAbilityEffect {

  /**
   * This function is used to the player ability for the gear effect.
   * @return ability which will be affected
   */
  Player.Ability getGearAbility();

  /**
   * This function is used to get the effective max damage for the ability.
   * @return max effective damage
   */
  int getEffectiveMaxDamage();

  /**
   * This function is used to get the effective min damage for the ability.
   * @return min effective damage
   */
  int getEffectiveMinDamage();
}
