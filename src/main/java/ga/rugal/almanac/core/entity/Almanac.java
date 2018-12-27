package ga.rugal.almanac.core.entity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import ga.rugal.almanac.core.entity.localized.LocalizedAlmanac;
import ga.rugal.almanac.util.DateUtil;

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

  /**
   * Range is [0, 10].
   */
  private int approachability;

  private List<Hexagram> auspicious;

  private List<Locale> beverage;

  private Date date;

  private Locale direction;

  private List<Hexagram> inauspicious;

  /**
   * Generate localized almanac object.
   *
   * @param language target language to localize
   *
   * @return
   */
  public LocalizedAlmanac localize(final String language) {
    return LocalizedAlmanac.builder()
      .approachability(this.approachability)
      .auspicious(this.auspicious.stream()
        .map(h -> h.getByLanguage(true, language))
        .collect(Collectors.toList()))
      .beverage(this.beverage.stream()
        .map(l -> l.getByLanguage(language))
        .collect(Collectors.toList()))
      .date(DateUtil.getDateString(this.date))
      .direction(this.direction.getByLanguage(language))
      .inauspicious(this.inauspicious.stream()
        .map(h -> h.getByLanguage(false, language))
        .collect(Collectors.toList()))
      .language(language)
      .build();
  }
}
