package ga.rugal.almanac.core.dao;

import ga.rugal.almanac.core.entity.Locale;

import org.springframework.data.repository.CrudRepository;

public interface LocaleDao extends CrudRepository<Locale, Integer> {

  //findOne, delete, save, count, etc., are inherited from CruiRepository
}
