package ga.rugal.almanac.core.dao;

import java.util.List;
import java.util.Optional;

import ga.rugal.almanac.core.entity.Locale;

import org.springframework.data.repository.CrudRepository;

public interface LocaleDao extends CrudRepository<Locale, Integer> {

  List<Locale> findByLanguage(String language);

  Optional<Locale> findByLanguageAndCountry(String language, String country);
}
