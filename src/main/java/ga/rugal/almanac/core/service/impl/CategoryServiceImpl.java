package ga.rugal.almanac.core.service.impl;

import ga.rugal.almanac.core.dao.CategoryDao;
import ga.rugal.almanac.core.service.CategoryService;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  @Getter
  @Setter
  private CategoryDao dao;
}
