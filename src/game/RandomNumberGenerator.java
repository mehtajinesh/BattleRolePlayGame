package game;

/**
 * This interface represents the random number generator which
 * dispatches a random number on demand.
 */
public interface RandomNumberGenerator {

  /**
   * This function is used to generate random values for the given range.
   * Note that the maximum value is excluded when generating a random number.
   *
   * @param minimumRangeValue minimum value for the random number
   * @param maximumRangeValue maximum value for the random number
   * @return random number generated for the given range
   * @throws IllegalStateException if the predefined list is exhausted
   */
  int generateRandomValueForRange(int minimumRangeValue, int maximumRangeValue)
          throws IllegalStateException;
}
