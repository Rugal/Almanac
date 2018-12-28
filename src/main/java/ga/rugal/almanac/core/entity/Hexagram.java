package ga.rugal.almanac.core.entity;

import ga.rugal.almanac.core.entity.localized.LocalizedHexagram;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class for single hexagram.
 *
 * @author Rugal Bernstein
 */
@Data
@NoArgsConstructor
public class Hexagram {

  private Locale title;

  private Explanation explanation;

  /**
   * Get localized object.
   *
   * @param auspicious target auspicious
   * @param language   target language to localize
   *
   * @return
   */
  public LocalizedHexagram getByLanguage(final boolean auspicious, final String language) {
    return LocalizedHexagram.builder()
      .title(this.title.getByLanguage(language))
      .explanation(auspicious
                   ? this.explanation.getAuspicious().getByLanguage(language)
                   : this.explanation.getInauspicious().getByLanguage(language))
      .build();
  }
}
