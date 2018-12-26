package ga.rugal.almanac.core.service.impl;

import java.util.Calendar;
import java.util.Date;

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
   * {@inheritDoc}
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

  /**
   * {@inheritDoc}
   */
  @Override
  public int getCurrentDateNumber(final Date date) {
    final Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    return cal.get(Calendar.YEAR) * 10000
           + (cal.get(Calendar.MONTH) + 1) * 100
           + cal.get(Calendar.DAY_OF_MONTH);
  }
}
