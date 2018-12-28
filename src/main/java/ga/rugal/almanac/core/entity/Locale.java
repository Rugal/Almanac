package ga.rugal.almanac.core.entity;

import config.SystemDefaultProperty;

import lombok.Data;

/**
 * For holding localized data.
 *
 * @author Rugal Bernstein
 */
@Data
public class Locale {

  private String en;

  private String zh;

  public String getByLanguage(final String language) {
    return language.startsWith(SystemDefaultProperty.DEFAULT_LANGUAGE) ? this.en : this.zh;
  }
}
