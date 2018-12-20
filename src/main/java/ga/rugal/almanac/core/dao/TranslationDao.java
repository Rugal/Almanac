package ga.rugal.almanac.core.dao;

import java.util.List;

import ga.rugal.almanac.core.entity.Hexagram;
import ga.rugal.almanac.core.entity.Locale;
import ga.rugal.almanac.core.entity.Translation;

import org.springframework.data.repository.CrudRepository;

public interface TranslationDao extends CrudRepository<Translation, Integer> {

  List<Translation> findByHexagram(Hexagram hexagram);

  List<Translation> findByHexagramAndLocale(Hexagram hexagram, Locale locale);
}
