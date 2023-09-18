package game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents the gear implementation which a player can equip during the battle.
 * A gear can have a positive or negative effect on the overall health of the player.
 */
public class GearImpl implements Gear {

  private final String gearName;
  private final GearTypeData gearTypeData;
  private final Map<Player.Ability, Integer> gearAbilityValueMap;
  private GearTypeData.BeltType beltType;
  private final RandomNumberGenerator randomizer;

  /**
   * This function is used to create a gear instance for the player with given name and type.
   *
   * @param gearName     name of the gear
   * @param gearTypeData gear type data of the gear
   * @param randomizer   randomizer instance
   * @throws IllegalArgumentException if any of the parameters are null
   */
  public GearImpl(String gearName, GearTypeData gearTypeData, RandomNumberGenerator randomizer)
          throws IllegalArgumentException {
    if (gearName == null || gearTypeData == null || randomizer == null) {
      throw new IllegalStateException("Gear name or gear type data or randomizer cannot be null.");
    }
    this.gearName = gearName;
    this.gearTypeData = gearTypeData;
    this.gearAbilityValueMap = new HashMap<>();
    this.randomizer = randomizer;
    updateAbilityValueMap();
    if (gearTypeData.getGearType() == GearType.BELTS) {
      updateBeltType();
    } else {
      beltType = GearTypeData.BeltType.BELT_INVALID;
    }
  }

  @Override
  public String getGearName() {
    return gearName;
  }

  @Override
  public GearTypeData getGearTypeData() {
    return new GearTypeDataImpl(gearTypeData);
  }

  @Override
  public GearTypeData.BeltType getBeltType() throws UnsupportedOperationException {
    if (gearTypeData.getGearType() != Gear.GearType.BELTS) {
      throw new UnsupportedOperationException("Getting the belt type is only "
              + "supported in belts gear type");
    }
    return beltType;
  }

  @Override
  public int getBeltUnits() throws UnsupportedOperationException {
    if (gearTypeData.getGearType() != Gear.GearType.BELTS) {
      throw new UnsupportedOperationException("Getting the belt units is only "
              + "supported in belts gear type");
    }
    return beltType.getUnitValue();
  }

  private void updateAbilityValueMap() {
    List<GearAbilityEffect> gearAbilityEffectList = gearTypeData.getEffectiveAbilities();
    for (GearAbilityEffect gearAbilityEffect : gearAbilityEffectList) {
      int generatedAbilityEffectValue = randomizer
              .generateRandomValueForRange(gearAbilityEffect.getEffectiveMinDamage(),
                      gearAbilityEffect.getEffectiveMaxDamage() + 1);
      Player.Ability ability = gearAbilityEffect.getGearAbility();
      gearAbilityValueMap.put(ability, generatedAbilityEffectValue);
    }
  }

  private void updateBeltType() {
    List<GearTypeData.BeltType> beltTypeList = List.of(GearTypeData.BeltType.values());
    beltType = beltTypeList.get(randomizer
            .generateRandomValueForRange(1, beltTypeList.size()));
  }

  @Override
  public int getEffectiveAbilityValue(Player.Ability ability) throws IllegalArgumentException {
    if (ability == null) {
      throw new IllegalArgumentException("Ability cannot be null");
    }
    return gearAbilityValueMap.get(ability);
  }

  @Override
  public int compareTo(Gear o) {
    int thisPriority = this.gearTypeData.getGearType().getPriority();
    int otherPriority = o.getGearTypeData().getGearType().getPriority();
    if (thisPriority > otherPriority) {
      return 1;
    } else if (thisPriority < otherPriority) {
      return -1;
    } else {
      String thisGearName = this.getGearName();
      String otherGearName = o.getGearName();
      return thisGearName.compareTo(otherGearName);
    }
  }
}
