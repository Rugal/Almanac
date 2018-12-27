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
    return SystemDefaultProperty.DEFAULT_LANGUAGE.equals(language) ? this.en : this.zh;
  }
}
