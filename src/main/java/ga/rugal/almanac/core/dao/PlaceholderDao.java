package ga.rugal.almanac.core.dao;

import ga.rugal.almanac.core.entity.Placeholder;

import org.springframework.data.repository.CrudRepository;

public interface PlaceholderDao extends CrudRepository<Placeholder, Integer> {
}
