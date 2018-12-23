package ga.rugal.almanac.core.dao;

import java.util.Set;

import ga.rugal.almanac.core.entity.Category;
import ga.rugal.almanac.core.entity.Placeholder;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PlaceholderDao extends CrudRepository<Placeholder, Integer> {

  @Query("SELECT DISTINCT category FROM #{#entityName}")
  Set<Integer> findDistinctCategory();

  Page<Placeholder> findByCategory(Category category, Pageable pageable);

  int countByCategory(Category category);
}
