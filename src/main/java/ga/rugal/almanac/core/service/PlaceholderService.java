package ga.rugal.almanac.core.service;

import java.util.List;
import javax.validation.constraints.NotNull;

import ga.rugal.almanac.core.entity.Hexagram;
import ga.rugal.almanac.core.entity.Locale;

/**
 * Service to to fill placeholder.
 *
 * @author Rugal Bernstein
 */
public interface PlaceholderService {

  /**
   * Fill translation placeholder.Only work on explanation.
   *
   * @param locale  target translation sentence
   * @param daySeed seed for generating number
   *
   * @return update locale object
   */
  Locale fillPlaceholder(@NotNull Locale locale, int daySeed);

  /**
   * Fill placeholder across all translations.Only work on explanation.
   *
   * @param hexagrams content to translate
   * @param daySeed   seed for generating number
   *
   * @return update translations
   */
  List<Hexagram> fillPlaceholders(List<Hexagram> hexagrams, int daySeed);
}
