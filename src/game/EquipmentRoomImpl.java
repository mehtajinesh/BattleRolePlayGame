package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class represents equipment room which is used by the player to pick up weapons and gears.
 */
public class EquipmentRoomImpl implements EquipmentRoom {

  private final List<Gear> generatedGearsList;
  private final List<Weapon> generatedWeaponsList;
  private final List<GearTypeData> gearTypeDataList;
  private final List<WeaponTypeData> weaponTypeDataList;
  private final RandomNumberGenerator randomizer;

  /**
   * This function is used to create equipment room instance
   * for the players to acquire weapons and gears.
   *
   * @param randomizer randomizer instance
   * @throws IllegalArgumentException if randomizer is null
   */
  public EquipmentRoomImpl(RandomNumberGenerator randomizer) throws IllegalArgumentException {
    if (randomizer == null) {
      throw new IllegalArgumentException("Invalid randomizer");
    }
    this.generatedGearsList = new ArrayList<>();
    this.generatedWeaponsList = new ArrayList<>();
    this.gearTypeDataList = new ArrayList<>();
    this.weaponTypeDataList = new ArrayList<>();
    this.randomizer = randomizer;
    setupGearTypeData();
    setupWeaponTypeData();
    generateBagOfGears();
    generateBagOfWeapons();
  }

  /**
   * This function is used to set up gear type data for all the gears available.
   */
  private void setupGearTypeData() {
    //create constitution gear ability effect for headgear - ability and their ranges
    GearAbilityEffect gearAbilityConstitutionEffect = new GearAbilityEffectImpl(
            4, 6, Player.Ability.CONSTITUTION);
    //create gear type for headgear and associate the created ability effect to headgear
    GearTypeData headgearTypeData = new GearTypeDataImpl(Gear.GearType.HEADGEAR, "Headgear");
    headgearTypeData.addAbilityEffectToGearType(gearAbilityConstitutionEffect);
    //save the gear type in map for later use
    gearTypeDataList.add(headgearTypeData);

    //create strength gear ability effect for potion - ability and their ranges
    GearAbilityEffect gearAbilityStrengthEffect = new GearAbilityEffectImpl(
            3, 6, Player.Ability.STRENGTH);
    //create gear type for potion and associate the created ability effect to potion
    GearTypeData potionTypeData = new GearTypeDataImpl(Gear.GearType.POTIONS, "Potion");
    potionTypeData.addAbilityEffectToGearType(gearAbilityStrengthEffect);
    //save the gear type in map for later use
    gearTypeDataList.add(potionTypeData);

    //create charisma gear ability effect for belt - ability and their ranges
    GearAbilityEffect gearAbilityCharismaEffect = new GearAbilityEffectImpl(
            2, 4, Player.Ability.CHARISMA);
    //create dexterity gear ability effect for belt - ability and their ranges
    GearAbilityEffect gearAbilityDexterityBeltEffect = new GearAbilityEffectImpl(
            -2, -1, Player.Ability.DEXTERITY);
    //create gear type for belt and associate the created ability effect to potion
    GearTypeData beltTypeData = new GearTypeDataImpl(Gear.GearType.BELTS, "Belt");
    beltTypeData.addAbilityEffectToGearType(gearAbilityCharismaEffect);
    beltTypeData.addAbilityEffectToGearType(gearAbilityDexterityBeltEffect);
    //save the gear type in map for later use
    gearTypeDataList.add(beltTypeData);

    //create dexterity gear ability effect for footwear - ability and their ranges
    GearAbilityEffect gearAbilityDexterityFootwearEffect = new GearAbilityEffectImpl(
            -4, -2, Player.Ability.DEXTERITY);
    //create gear type for footwear and associate the created ability effect to potion
    GearTypeData footwearTypeData = new GearTypeDataImpl(Gear.GearType.FOOTWEAR, "Footwear");
    footwearTypeData.addAbilityEffectToGearType(gearAbilityDexterityFootwearEffect);
    //save the gear type in map for later use
    gearTypeDataList.add(footwearTypeData);
  }

  /**
   * This function is used to set up weapon type data for all the weapons available.
   */
  private void setupWeaponTypeData() {
    //create katana sword weapon type
    WeaponTypeData katanaTypeData = new WeaponTypeDataImpl(WeaponTypeData.WeaponType.KATANAS,
            "Katanas", 4, 6);
    //save the weapon type in list for later use
    weaponTypeDataList.add(katanaTypeData);

    //create broadswords sword weapon type
    WeaponTypeData broadswordsTypeData = new WeaponTypeDataImpl(
            WeaponTypeData.WeaponType.BROADSWORDS,
            "Broadswords", 6, 10);
    //save the weapon type in list for later use
    weaponTypeDataList.add(broadswordsTypeData);

    //create two handed sword weapon type
    WeaponTypeData twoHandedTypeData = new WeaponTypeDataImpl(
            WeaponTypeData.WeaponType.TWO_HANDED_SWORDS,
            "Two Handed Sword",
            8, 12);
    //save the weapon type in list for later use
    weaponTypeDataList.add(twoHandedTypeData);

    //create axes weapon type
    WeaponTypeData axesTypeData = new WeaponTypeDataImpl(WeaponTypeData.WeaponType.AXES,
            "Axes", 6, 10);
    //save the weapon type in list for later use
    weaponTypeDataList.add(axesTypeData);

    //create flails weapon type
    WeaponTypeData flailsTypeData = new WeaponTypeDataImpl(WeaponTypeData.WeaponType.FLAILS,
            "Flails", 8, 12);
    //save the weapon type in list for later use
    weaponTypeDataList.add(flailsTypeData);
  }

  /**
   * This function is used to generate a bag of gears which satisfy the
   * criteria of 25% negative effect.
   *
   * @throws IllegalStateException if the gear type data is missing for a gear type
   */
  private void generateBagOfGears() throws IllegalStateException {
    //since we have to keep 25% negative affecting gears,
    //lets focus on that first. we are assuming belt and footwear have negative effects.
    //get random number of footwear to be created. (min. is 5 and max is assumed to be 20.)
    int randomNumberOfFootwear =
            randomizer.generateRandomValueForRange(5, 21);
    // create random number of footwear and add it to the bag
    GearTypeData footwearTypeData = getGearTypeDataForGearType(Gear.GearType.FOOTWEAR);
    if (footwearTypeData == null) {
      throw new IllegalStateException("Gear type data missing for footwear gear type");
    }
    for (int counter = 0; counter < randomNumberOfFootwear; counter++) {
      Gear gear = new GearImpl(String.format("%s-%s",
              footwearTypeData.getGearTypeName(), counter + 1), footwearTypeData, randomizer);
      generatedGearsList.add(gear);
    }
    //get random number of belts to be created. (min. is 15 and max is assumed to be 30.)
    int randomNumberOfBelts =
            randomizer.generateRandomValueForRange(15, 31);
    GearTypeData beltsTypeData = getGearTypeDataForGearType(Gear.GearType.BELTS);
    if (beltsTypeData == null) {
      throw new IllegalStateException("Gear type data missing for belts gear type");
    }
    for (int counter = 0; counter < randomNumberOfBelts; counter++) {
      Gear gear = new GearImpl(String.format("%s-%s",
              beltsTypeData.getGearTypeName(), counter + 1), beltsTypeData, randomizer);
      generatedGearsList.add(gear);
    }
    int totalPlayerDiminishingAbilityGearCount = randomNumberOfBelts + randomNumberOfFootwear;
    int maxTotalPlayerEnhancingAbilityGearCount = totalPlayerDiminishingAbilityGearCount * 3;
    //get random number of potions to be created. (min. is 40 and max is based on
    // (total positive - min. needed for headgear))
    int randomNumberOfPotions = randomizer
            .generateRandomValueForRange(40,
                    maxTotalPlayerEnhancingAbilityGearCount - 5 + 1);
    GearTypeData potionTypeData = getGearTypeDataForGearType(Gear.GearType.POTIONS);
    if (potionTypeData == null) {
      throw new IllegalStateException("Gear type data missing for potions gear type");
    }
    for (int counter = 0; counter < randomNumberOfPotions; counter++) {
      Gear gear = new GearImpl(String.format("%s-%s",
              potionTypeData.getGearTypeName(), counter + 1), potionTypeData, randomizer);
      generatedGearsList.add(gear);
    }
    //
    int numberOfHeadWears = maxTotalPlayerEnhancingAbilityGearCount - randomNumberOfPotions;
    GearTypeData headgearTypeData = getGearTypeDataForGearType(Gear.GearType.HEADGEAR);
    if (headgearTypeData == null) {
      throw new IllegalStateException("Gear type data missing for headgear gear type");
    }
    for (int counter = 0; counter < numberOfHeadWears; counter++) {
      Gear gear = new GearImpl(String.format("%s-%s",
              headgearTypeData.getGearTypeName(), counter + 1), headgearTypeData, randomizer);
      generatedGearsList.add(gear);
    }
  }

  /**
   * This function is used to generate a bag of weapons which satisfy the
   * criteria of at least one weapon.
   *
   * @throws IllegalStateException if the weapon type data is missing for a weapon type
   */
  private void generateBagOfWeapons() throws IllegalStateException {
    List<WeaponTypeData.WeaponType> weaponTypeList = List.of(WeaponTypeData.WeaponType.values());
    for (WeaponTypeData.WeaponType weaponType : weaponTypeList) {
      // for every weapon type, get a random number of count
      int randomNumberOfWeapon;
      if (weaponType == WeaponTypeData.WeaponType.KATANAS) {
        randomNumberOfWeapon = randomizer
                .generateRandomValueForRange(4, 21);
      } else if (weaponType == WeaponTypeData.WeaponType.BARE_HANDS) {
        continue;
      } else {
        randomNumberOfWeapon = randomizer
                .generateRandomValueForRange(2, 11);
      }
      // create no. of weapons based on the random count
      for (int counter = 0; counter < randomNumberOfWeapon; counter++) {
        WeaponTypeData weaponTypeData = getWeaponTypeDataForWeaponType(weaponType);
        if (weaponTypeData == null) {
          throw new IllegalStateException("Weapon type data not found");
        }
        Weapon weapon = new WeaponImpl(String.format("%s-%s",
                weaponTypeData.getWeaponTypeName(), counter + 1), weaponTypeData, randomizer);
        generatedWeaponsList.add(weapon);
      }
    }
  }

  /**
   * This function is used to get gear type data for given gear type.
   *
   * @param gearType gear type for the gear
   * @return null if no such gear type exists else the gear type data
   */
  private GearTypeData getGearTypeDataForGearType(Gear.GearType gearType) {
    for (GearTypeData gearTypeData : gearTypeDataList) {
      if (gearType == gearTypeData.getGearType()) {
        return gearTypeData;
      }
    }
    return null;
  }

  /**
   * This function is used to get weapon type data for given weapon type.
   *
   * @param weaponType weapon type for the weapon
   * @return null if no such weapon type exists else the weapon type data
   */
  private WeaponTypeData getWeaponTypeDataForWeaponType(WeaponTypeData.WeaponType weaponType) {
    for (WeaponTypeData weaponTypeData : weaponTypeDataList) {
      if (weaponType == weaponTypeData.getWeaponType()) {
        return weaponTypeData;
      }
    }
    return null;
  }

  @Override
  public void chooseGearForPlayer(Player player) throws IllegalArgumentException {
    if (player == null) {
      throw new IllegalArgumentException("Player cannot be null");
    }
    // pick gear one by one from the bag and validate it. If validation successful,
    // assign it to the player and remove it from the bag.
    int selectedGearCount = 0;
    List<Integer> alreadyPickedItem = new ArrayList<>();
    Set<Integer> alreadyVisitedItems = new HashSet<>();
    while (selectedGearCount != 20) {
      if (alreadyVisitedItems.size() == generatedGearsList.size()) {
        System.out.println("Bag doesn't have minimum required items.");
        break;
      }
      //generate a random index that will be used to select a gear from bag
      int randomGearItemIndex = randomizer
              .generateRandomValueForRange(0, generatedGearsList.size());
      // if item is already taken, then move to the next one.
      if (alreadyPickedItem.contains(randomGearItemIndex)) {
        alreadyVisitedItems.add(randomGearItemIndex);
        continue;
      }
      // if item is not taken, check if the player can take it
      Gear selectedGear = generatedGearsList.get(randomGearItemIndex);
      boolean gearSelectedValid = player.validateGearSelection(selectedGear);
      if (gearSelectedValid) {
        player.assignGear(selectedGear);
        alreadyPickedItem.add(randomGearItemIndex);
        selectedGearCount++;
      }
      alreadyVisitedItems.add(randomGearItemIndex);
    }
    alreadyPickedItem.sort(Collections.reverseOrder());
    //remove selected items from the bag
    for (int index : alreadyPickedItem) {
      generatedGearsList.remove(index);
    }
  }

  @Override
  public void chooseWeaponForPlayer(Player player) throws IllegalArgumentException {
    if (player == null) {
      throw new IllegalArgumentException("Player cannot be null");
    }
    List<Weapon> selectedWeaponList = new ArrayList<>();
    //generate a random index that will be used to select a weapon from bag
    int randomWeaponItemIndex = randomizer
            .generateRandomValueForRange(0, generatedWeaponsList.size());
    Weapon selectedWeapon = generatedWeaponsList.get(randomWeaponItemIndex);
    selectedWeaponList.add(selectedWeapon);
    //remove weapon from bag
    generatedWeaponsList.remove(randomWeaponItemIndex);
    // check for weapon as katana or not, if yes then try to take another katana weapon
    if (selectedWeapon.getWeaponTypeData().getWeaponType() == WeaponTypeData.WeaponType.KATANAS) {
      // try to get another katana weapon
      int randomWeapon2ItemIndex = randomizer
              .generateRandomValueForRange(0, generatedWeaponsList.size());
      Weapon selectedWeapon2 = generatedWeaponsList.get(randomWeapon2ItemIndex);
      if (selectedWeapon2.getWeaponTypeData().getWeaponType()
              == WeaponTypeData.WeaponType.KATANAS) {
        selectedWeaponList.add(selectedWeapon2);
        generatedWeaponsList.remove(randomWeapon2ItemIndex);
      }
    }
    player.assignWeapons(selectedWeaponList);
  }
}
