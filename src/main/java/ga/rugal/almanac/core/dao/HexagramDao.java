package ga.rugal.almanac.core.dao;

import ga.rugal.almanac.core.entity.Hexagram;

import org.springframework.data.repository.CrudRepository;

public interface HexagramDao extends CrudRepository<Hexagram, Integer> {

  //findOne, delete, save, count, etc., are inherited from CruiRepository
}
