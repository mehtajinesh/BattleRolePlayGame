package game;

/**
 * This interface represents the equipment room used by the players to grab the necessary
 * gears and weapons before battle.
 */
public interface EquipmentRoom {

  /**
   * This function is used to choose weapon for the player from the pool of available weapons.
   *
   * @param player player for which weapon is to be chosen
   * @throws  IllegalArgumentException if player is null
   */
  void chooseWeaponForPlayer(Player player) throws IllegalArgumentException;

  /**
   * This function is used to choose gear for the player from the pool of available gears.
   *
   * @param player player for which gear is to be chosen
   * @throws  IllegalArgumentException if player is null
   */
  void chooseGearForPlayer(Player player) throws IllegalArgumentException;
}
