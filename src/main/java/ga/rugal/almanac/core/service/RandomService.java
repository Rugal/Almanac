package ga.rugal.almanac.core.service;

/**
 * Service to generate random number.
 *
 * @author Rugal Bernstein
 */
public interface RandomService {

  /**
   * Randomize number.
   *
   * @param dayseed   seed of day
   * @param indexseed seed of index
   *
   * @return
   */
  int random(int dayseed, int indexseed);
}
