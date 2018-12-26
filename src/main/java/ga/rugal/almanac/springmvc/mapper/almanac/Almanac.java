package ga.rugal.almanac.springmvc.mapper.almanac;

import java.util.Date;
import java.util.List;

import ga.rugal.almanac.core.entity.Hexagram;
import ga.rugal.almanac.core.entity.Locale;

import lombok.Builder;
import lombok.Value;

/**
 * Almanac object.
 *
 * @author Rugal Bernstein
 */
@Builder
@Value
public class Almanac {

  private Date date;

  private List<Hexagram> auspicious;

  private List<Hexagram> inauspicious;

  /**
   * Range is [0, 10].
   */
  private int approachability;

  private Locale beverage;

  private Locale direction;
}
