package ga.rugal.almanac.core.entity.localized;

import java.util.List;

import lombok.Builder;
import lombok.Value;

/**
 * Localized Almanac object.
 *
 * @author Rugal Bernstein
 */
@Builder
@Value
public class LocalizedAlmanac {

  private String date;

  private String language;

  private String direction;

  /**
   * Range is [0, 10].
   */
  private int approachability;

  private List<LocalizedHexagram> auspicious;

  private List<LocalizedHexagram> inauspicious;

  private List<String> beverage;
}
