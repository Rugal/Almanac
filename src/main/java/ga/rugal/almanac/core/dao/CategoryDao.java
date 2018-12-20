package ga.rugal.almanac.core.dao;

import ga.rugal.almanac.core.entity.Category;

import org.springframework.data.repository.CrudRepository;

public interface CategoryDao extends CrudRepository<Category, Integer> {
}
