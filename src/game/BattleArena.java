package game;

/**
 * This interface is used to represent the battle arena of the game. It performs all the
 * major operations of the game like adding players to arena, equipping them with gears
 * and weapons.
 */
public interface BattleArena {

  /**
   * This function is used to add player to arena.
   *
   * @param player player to be added
   * @throws IllegalArgumentException if the player is null
   */
  void addPlayerToArena(Player player) throws IllegalArgumentException;

  /**
   * This function is used to equip player for battle based on the player id provided.
   *
   */
  void equipPlayersForBattle();

  /**
   * This function is used to gear up player for battle based on the player id provided.
   */
  void gearUpPlayersForBattle();

  /**
   * This function is used to generate player description based on the provided player id.
   * This includes weapons and gear information.
   *
   * @param player instance for which description has to be generated
   * @return description of both the players along with their gear and weapon info.
   * @throws IllegalArgumentException if player is null
   */
  String generatePlayersDescription(Player player) throws IllegalArgumentException;

  /**
   * This function is used to perform battle between two players.
   *
   * @return Match summary
   */
  String performBattle();
}
