package ga.rugal.almanac.core.dao.impl;

import ga.rugal.almanac.core.dao.TranslationDao;
import ga.rugal.almanac.core.dao.TranslationRepositoryCustom;
import ga.rugal.almanac.core.entity.Hexagram;
import ga.rugal.almanac.core.entity.Locale;
import ga.rugal.almanac.springmvc.mapper.hexagram.CompleteHexagram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation for Translation custom.
 *
 * @author Rugal Bernstein
 */
@Repository
@Transactional(readOnly = true)
public class TranslationRepositoryCustomImpl implements TranslationRepositoryCustom {

  @Autowired
  private TranslationDao dao;

  @Override
  public CompleteHexagram findCompleteByHexagram(final Hexagram hexagram) {
    return new CompleteHexagram(this.dao.findByHexagram(hexagram));
  }

  @Override
  public CompleteHexagram findCompleteByHexagramAndLocale(final Hexagram hexagram,
                                                          final Locale locale) {
    return new CompleteHexagram(this.dao.findByHexagramAndLocale(hexagram, locale));
  }
}
