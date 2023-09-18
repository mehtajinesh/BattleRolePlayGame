## About/Overview
Battle Game is a role-playing game (abbreviated RPG) in which two players assume the roles of characters in a fictional setting. By default, both these players are having basic abilities and no weapons. Once these players come to the arena, they are provided an equipment room where they gather their gears and weapons for the battle. Next, before starting the battle, they gear up i.e. consume potions, put on headwear, footwear and belts. Finally, they start battling. Turn by turn attack on each other and the player with the least damage acquired, becomes the winner. Also, characters are allowed to play a rematch, in which case they would be allowed to rest to regain their full health and they would enter the arena for a fresh battle with the same gear and weapons.

## List of features
1. User can create players (two of this example. However, the implementation is done in such a way that it is scalable).
2. User can move already created players to arena. (two max for this example.)
3. User can move the players to equipment room for choosing gears and weapons.
   1. Information on generation of bag of gears and selection of gear:
      1. It contains a minimum of 5 items of headgear, 5 items of footwear, 15 belts, and 15 potions. 
      2. When players equip themselves from the bag, they are randomly assigned 20 items from the bag.
      3. Any item that is randomly assigned must be used unless it cannot be combined with what the player is already using. 
      4. 25% of the items that are in the bag will diminish the player's ability rather than enhance it.
   2. Information on generation of bag of weapons and selection of weapons:
      1. Bag of weapons is generated with random number of weapons making sure at least 1 of each type of weapon is available.
      2. Requests for a weapon are satisfied by randomly selecting one of the many weapons that are available.
4. User can generate complete description of players that will enter the arena including the player's temporary ability values (based on the affects of the potions that they may have consumed) along with any and all the gear they are wearing, and what weapon they are using.  
   1. Gear Sorting order: Gear will be printed in order of top to bottom, then alphabetically: thus any headgear will come before potions which come before any belts which will come before any footwear.
5. User can make two players battle in the arena. As players enter the arena, the player with the higher charisma dazzles their opponent and gets in the first strike. Turn by turn, as each player takes strike and damage, a match summary will be generated in the end with a winner whose health will be more than 0 (only one player will have a non-negative health in the end for two player game).

## How To Run
1. Run the "BattleRolePlayGame.jar" file to test the program with the following command:
```console
   java -jar BattleRolePlayGame.jar
```

## Examples
1. Battle With Player 1 Winner Example:
  
   1. Create Player 1 and Player 2 with name Google and Apple respectively.
   2. Create battle arena for battle.
   3. Add both the players to battle arena
   4. Move both the players to equipment room to gear some weapons and gears.
   5. Gear up both the players for battle.
   6. Generate a complete description of the abilities and weapons for Google.
      1. Basic Strength Value of player - 12
      2. Basic Constitution Value of player - 13
      3. Basic Dexterity Value of player - 18
      4. Basic Charisma Value of player - 17
      5. Effective Strength Value of player - 77
      6. Effective Constitution Value of player - 19
      7. Effective Dexterity Value of player - 10
      8. Effective Charisma Value of player - 30
      9. Gears Taken - 20
      10. Gears Name - Headgear-13, Potion-16, Potion-18, Potion-2, Potion-21, Potion-22, Potion-26, Potion-32, Potion-36, Potion-41, Potion-47, Potion-50, Potion-58, Potion-67, Potion-9, Belt-1(Small), Belt-12 (Small), Belt-21 (Medium), Belt-3 (Large), Footwear-2.
      11. Weapons Taken - 1
      12. Weapons Name - Two Handed Sword-4
   7. Generate a complete description of the abilities and weapons for Apple.
      1. Basic Strength Value of player - 14
      2. Basic Constitution Value of player - 14
      3. Basic Dexterity Value of player - 12
      4. Basic Charisma Value of player - 16
      5. Effective Strength Value of player - 68
      6. Effective Constitution Value of player - 18
      7. Effective Dexterity Value of player - 2
      8. Effective Charisma Value of player - 31
      9. Gears Taken - 20
      10. Gears Name - Headgear-14, Potion-12, Potion-19, Potion-27, Potion-28, Potion-3, Potion-43, Potion-46, Potion-6, Potion-64, Potion-66, Potion-70, Potion-73, Potion-77, Belt-10 (Small), Belt-14 (Medium),Belt-5 (Medium), Belt-6 (Small),Belt-9 (Large), Footwear-5.
      11. Weapons Taken - 1
      12. Weapons Name - Flails-6 
   8. Apple has higher charisma value, so strikes first.
   9. Total health of Google is 136.
   10. Total health of Apple is 119.
   11. In Turn 1, Player Apple strikes
   12. Apple's Striking Power is 76 units.
   13. Google's Avoidance Ability is 12 units.
   14. Apple successfully hit Player Google as 76 > 12.
   15. Potential Striking Damage for Apple is 77 units. 
   16. Actual Damage done by Apple is 58 units.
   17. Updating Google's health value to 78 units. 
   18. In Turn 2, Player Google strikes
   19. Google's Striking Power is 87 units.
   20. Apple's Avoidance Ability is 5 units.
   21. Google successfully hits Apple as 87 > 5.
   22. Potential Striking Damage for Google is 88 units.
   23. Actual Damage done by Google is 70 units.
   24. Apple's updated health value is 49 units. 
   25. In Turn 3, Player Apple strikes
   27. Apple's Striking Power is 70 units.
   28. Google's Avoidance Ability is 16.
   29. Apple successfully hit Google as 70 > 16;
   30. Potential Striking Damage for Apple is 77.
   31. Actual Damage done by Apple is 58. 
   32. Google's updated health value is 20.
   33. In Turn 4, Player Google strikes
   34. Google's Striking Power is 84 units.
   35. Apple's Avoidance Ability is 7.
   36. Google successfully hit Apple as 84 > 7;
   37. Potential Striking Damage for Google is 85.
   38. Actual Damage done by Google is 67. 
   39. Apple's updated health value is -18.
   40. As Apple's health is less than zero, battle is over.
   41. We have battle result which show that Google is the winner.
   42. We ask the user if they want to rematch with the same gear and weapons or not.
   43. For this example, we say no and application exits successfully.

2. Battle With Player 2 Winner Example:

   1. Create Player 1 and Player 2 with name Google and Apple respectively.
   2. Create battle arena for battle.
   3. Add both the players to battle arena
   4. Move both the players to equipment room to gear some weapons and gears.
   5. Gear up both the players for battle.
   6. Generate a complete description of the abilities and weapons for Google.
      1. Basic Strength Value of player - 11
      2. Basic Constitution Value of player - 16
      3. Basic Dexterity Value of player - 14
      4. Basic Charisma Value of player - 18
      5. Effective Strength Value of player - 64
      6. Effective Constitution Value of player - 20
      7. Effective Dexterity Value of player - 4
      8. Effective Charisma Value of player - 31
      9. Gears Taken - 20
      10. Gears Name - Headgear-21, Potion-11, Potion-19, Potion-21, Potion-24, Potion-26, Potion-27, Potion-31, Potion-32, Potion-37, Potion-4, Potion-42, Potion-44, Potion-47, Bell-11(Medium), Belt-12(Medium), Belt-17 (Small), Belt-19 (Large), Belt-3 (Small), Footwear-1.
      11. Weapons Taken - 1
      12. Weapons Name - Katanas-11
   7. Generate a complete description of the abilities and weapons for Apple.
      1. Basic Strength Value of player - 13
      2. Basic Constitution Value of player - 14
      3. Basic Dexterity Value of player - 8
      4. Basic Charisma Value of player - 14
      5. Effective Strength Value of player - 73
      6. Effective Constitution Value of player - 19
      7. Effective Dexterity Value of player - 1
      8. Effective Charisma Value of player - 26
      9. Gears Taken - 20
      10. Gears Name - Headgear-5, Potion-1, Potion-15, Potion-17, Potion-25, Potion-29, Potion-3, Potion-34, Potion-36, Potion-38, Potion-58, Potion-6, Potion-60, Potion-61, Potion-8, Belt-20 (Medium), Belt-22 (Medium), Belt-7 (Medium), Belt-8 (Large), Footwear-7.
      11. Weapons Taken - 1
      12. Weapons Name - Two handed sword - 1. 
   8. Google has higher charisma value, so strikes first.
   9. Total health of Google is 119.
   10. Total health of Apple is 119.
   11. In Turn 1, Player Google strikes
   12. Google's Striking Power is 65 units.
   13. Apple's Avoidance Ability is 2 units.
   14. Google successfully hit Player Apple as 65 > 2.
   15. Potential Striking Damage for Google is 69 units. 
   16. Actual Damage done by Google is 50 units.
   17. Updating Apple's health value to 69 units. 
   18. In Turn 2, Player Apple strikes
   19. Apple's Striking Power is 74 units.
   20. Google's Avoidance Ability is 6 units.
   21. Apple successfully hits Google as 74 > 6.
   22. Potential Striking Damage for Apple is 85 units.
   23. Actual Damage done by Apple is 65 units.
   24. Google's updated health value is 54 units. 
   25. In Turn 3, Player Google strikes
   27. Google's Striking Power is 69 units.
   28. Apple's Avoidance Ability is 2.
   29. Google successfully hit Apple as 69 > 2;
   30. Potential Striking Damage for Google is 70.
   31. Actual Damage done by Google is 51. 
   32. Apple's updated health value is 18.
   33. In Turn 4, Player Apple strikes
   34. Apple's Striking Power is 77 units.
   35. Google's Avoidance Ability is 6.
   36. Apple successfully hit Google as 77 > 6;
   37. Potential Striking Damage for Apple is 83.
   38. Actual Damage done by Apple is 63. 
   39. Google's updated health value is -9.
   40. As Google's health is less than zero, battle is over.
   41. We have battle result which show that Apple is the winner.
   42. We ask the user if they want to rematch with the same gear and weapons or not.
   43. For this example, we say no and application exits successfully.

## Design/Model Changes
1. No major design changes done from the initial design
2. Added two copy constructors.
3. Added private functions in class diagram for better understanding of the design.
4. Added second constructor for predefined testing.

## Assumptions
1. Default Weapon for player is Bare hands.
2. Generated bag of gears and weapons is common for both the players.
3. Damage Range for bare hands - [0,4]
4. Ability Range for Headgear - [+4,+6] for Constitution.
5. Ability Range for Footwear - [-4,-2] for Dexterity.
6. Ability Range for Potions - [+3,+6] for Strength.
7. Ability Range for Belts - [+2,+4] for Charisma and [-7,-3] for Dexterity.
8. Temporary effects of the gears last throughout the battle. Acceptable as per professor's comment here: https://piazza.com/class/kt0jcw0x7h955a?cid=584
9. Headgear and Potion have positive impact on player's abilities whereas Belts and Footwear will have negative impact on player's ability.
10. As informed by professor in piazza, we are not considering the case of match tied specifically in this application. However, the skeleton code is already placed.
Reference: https://piazza.com/class/kt0jcw0x7h955a?cid=587

## Limitations/Future Scope:
1. Temparory effects of the gears can be made based on smaller durations as well to make the game more interesting.
2. If we consider point 1., we may need to think about the tie case as well.

## Citations
1. https://www.baeldung.com/java-generating-random-numbers-in-range
2. https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Random.html

