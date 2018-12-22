package ga.rugal.almanac.core.dao;

import ga.rugal.almanac.core.entity.Hexagram;
import ga.rugal.almanac.core.entity.Locale;
import ga.rugal.almanac.springmvc.mapper.hexagram.CompleteHexagram;

/**
 * Translation customization.
 *
 * @author Rugal Bernstein
 */
public interface TranslationRepositoryCustom {

  CompleteHexagram findCompleteByHexagram(Hexagram hexagram);

  CompleteHexagram findCompleteByHexagramAndLocale(Hexagram hexagram, Locale locale);
}
