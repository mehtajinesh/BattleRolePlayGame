package game;

import java.util.Random;

/**
 * This class is used to generate random numbers for the battle game.
 */
public class RandomNumberGeneratorImpl implements RandomNumberGenerator {

  private final Random javaRandom;
  private final int[] predefinedValues;
  private int countRandomValues;

  /**
   * This function is a constructor for creation of random number generator.(True random)
   */
  public RandomNumberGeneratorImpl() {
    javaRandom = new Random();
    this.predefinedValues = null;
  }

  /**
   * This function is a constructor for creation of random number generator.(Predefined random)
   *
   * @param predefinedValues predefined values of randomness
   * @throws IllegalArgumentException if the predefined values are null
   */
  public RandomNumberGeneratorImpl(int... predefinedValues) throws IllegalArgumentException {
    if (predefinedValues == null) {
      throw new IllegalArgumentException("Arguments cannot be null");
    }
    this.predefinedValues = predefinedValues;
    javaRandom = null;
    countRandomValues = 0;
  }

  @Override
  public int generateRandomValueForRange(int minimumRangeValue, int maximumRangeValue)
          throws IllegalStateException {
    if (javaRandom == null) {
      assert predefinedValues != null;
      if (predefinedValues.length == countRandomValues) {
        throw new IllegalStateException("Pre defined values are over.");
      }
      int value = predefinedValues[countRandomValues];
      countRandomValues++;
      return value;
    } else {
      return javaRandom.nextInt(maximumRangeValue - minimumRangeValue) + minimumRangeValue;
    }
  }
}