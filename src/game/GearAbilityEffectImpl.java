package game;

/**
 * This class acts as a data structure to store all the information with respect
 * to the effects of a gear on an ability of the player, when the gear is equipped.
 */
public class GearAbilityEffectImpl implements GearAbilityEffect {

  private final int minEffectiveDamageValue;
  private final int maxEffectiveDamageValue;
  private final Player.Ability abilityAffected;

  /**
   * This function is used to create instance for gear ability effect with provided
   * effect ranges and ability.
   *
   * @param minEffectiveDamageValue min. effect on the ability
   * @param maxEffectiveDamageValue max. effect on the ability
   * @param abilityAffected         ability that will be affected
   * @throws IllegalArgumentException if the ability is null
   */
  public GearAbilityEffectImpl(int minEffectiveDamageValue, int maxEffectiveDamageValue,
                               Player.Ability abilityAffected) throws IllegalArgumentException {
    if (abilityAffected == null) {
      throw new IllegalArgumentException("Invalid ability provided");
    }
    this.minEffectiveDamageValue = minEffectiveDamageValue;
    this.maxEffectiveDamageValue = maxEffectiveDamageValue;
    this.abilityAffected = abilityAffected;
  }

  @Override
  public Player.Ability getGearAbility() {
    return abilityAffected;
  }

  @Override
  public int getEffectiveMaxDamage() {
    return maxEffectiveDamageValue;
  }

  @Override
  public int getEffectiveMinDamage() {
    return minEffectiveDamageValue;
  }
}
