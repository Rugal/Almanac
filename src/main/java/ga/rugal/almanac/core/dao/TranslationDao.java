package ga.rugal.almanac.core.dao;

import ga.rugal.almanac.core.entity.Translation;

import org.springframework.data.repository.CrudRepository;

public interface TranslationDao extends CrudRepository<Translation, Integer> {

  //findOne, delete, save, count, etc., are inherited from CruiRepository
}
