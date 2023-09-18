package game;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the gear type data which is associated to each gear. It also includes
 * information on the max and min effective damage for the respective ability.
 */
public class GearTypeDataImpl implements GearTypeData {

  private final String gearTypeName;
  private final Gear.GearType gearType;
  private final List<GearAbilityEffect> gearAbilityEffectList;

  /**
   * This function is used to create a gear type for a given type along with
   * min and max damage value.
   *
   * @param gearTypeName gear type name
   * @param gearType     type of the gear
   */
  public GearTypeDataImpl(Gear.GearType gearType, String gearTypeName) {
    this.gearTypeName = gearTypeName;
    this.gearType = gearType;
    this.gearAbilityEffectList = new ArrayList<>();
  }

  /**
   * This function is used to copy values from instance to another.
   *
   * @param existingGearTypeData existing instance of gearTypeData
   * @throws IllegalArgumentException if the parameter passed is null
   */
  public GearTypeDataImpl(GearTypeData existingGearTypeData) throws IllegalArgumentException {
    if (existingGearTypeData == null) {
      throw new IllegalArgumentException("Invalid Gear type data passed.");
    }
    this.gearTypeName = existingGearTypeData.getGearTypeName();
    this.gearType = existingGearTypeData.getGearType();
    this.gearAbilityEffectList = new ArrayList<>();
    List<GearAbilityEffect> existingList = existingGearTypeData.getEffectiveAbilities();
    this.gearAbilityEffectList.addAll(existingList);
  }

  @Override
  public String getGearTypeName() {
    return gearTypeName;
  }

  @Override
  public Gear.GearType getGearType() {
    return gearType;
  }

  @Override
  public void addAbilityEffectToGearType(GearAbilityEffect gearAbilityEffect)
          throws IllegalArgumentException {
    if (gearAbilityEffect == null) {
      throw new IllegalArgumentException("Ability effect cannot be null");
    }
    gearAbilityEffectList.add(gearAbilityEffect);
  }

  @Override
  public List<GearAbilityEffect> getEffectiveAbilities() {
    return new ArrayList<>(gearAbilityEffectList);
  }
}
