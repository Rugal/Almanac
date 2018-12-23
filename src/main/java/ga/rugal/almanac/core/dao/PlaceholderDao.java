package ga.rugal.almanac.core.dao;

import java.util.Set;

import ga.rugal.almanac.core.entity.Placeholder;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PlaceholderDao extends CrudRepository<Placeholder, Integer> {

  @Query("SELECT DISTINCT category FROM Placeholder")
  Set<Integer> findDistinctCategory();
}
