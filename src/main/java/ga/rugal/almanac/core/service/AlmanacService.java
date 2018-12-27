package ga.rugal.almanac.core.service;

import java.util.Date;

import ga.rugal.almanac.core.entity.Almanac;

/**
 * Almanac service interface.
 *
 * @author Rugal Bernstein
 */
public interface AlmanacService {

  /**
   * Get I18N almanac object.
   *
   * @param date date to generate almanac
   *
   * @return completed, filled I18N almanac object
   */
  Almanac getAlmanac(Date date);
}
