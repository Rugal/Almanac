package ga.rugal.almanac.core.service.impl;

import ga.rugal.almanac.core.service.RandomService;

import org.springframework.stereotype.Service;

/**
 * Implementation for Random service to generate random number.
 *
 * @author Rugal Bernstein
 */
@Service
public class RandomServiceImpl implements RandomService {

  /**
   * Randomize number.
   *
   * @param dayseed   seed of day
   * @param indexseed seed of index
   *
   * @return
   */
  @Override
  public int random(final int dayseed, final int indexseed) {
    int n = dayseed % 11117;
    for (int i = 0; i < 100 + indexseed; i++) {
      n = n * n;
      n = n % 11117;
    }
    return n;
  }
}
