package ga.rugal.almanac.core.service;

import java.util.List;

import ga.rugal.almanac.core.dao.PlaceholderDao;
import ga.rugal.almanac.core.entity.Translation;

/**
 * Service to to fill placeholder.
 *
 * @author Rugal Bernstein
 */
public interface PlaceholderService extends BaseService<PlaceholderDao> {

  /**
   * Fill translation placeholder. Only work on explanation.
   *
   * @param translation target translation sentence
   * @param daySeed     seed for generating number
   *
   * @return update translation object
   */
  Translation fillPlaceholder(Translation translation, int daySeed);

  /**
   * Fill placeholder across all translations. Only work on explanation.
   *
   * @param explanations list of translations
   * @param daySeed      seed for generating number
   *
   * @return update translations
   */
  List<Translation> fillPlaceholders(List<Translation> explanations, int daySeed);
}
