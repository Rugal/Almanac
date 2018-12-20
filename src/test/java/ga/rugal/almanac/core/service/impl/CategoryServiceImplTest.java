package ga.rugal.almanac.core.service.impl;

import ga.rugal.UnitTestBase;
import ga.rugal.almanac.core.dao.CategoryDao;
import ga.rugal.almanac.core.entity.Category;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 *
 * @author Rugal Bernstein
 */
public class CategoryServiceImplTest extends UnitTestBase {

  @Autowired
  private Category category;

  private final CategoryServiceImpl categoryService = new CategoryServiceImpl();

  @MockBean
  private CategoryDao categoryDao;

  @Before
  public void before() {
    this.categoryService.setDao(this.categoryDao);
  }

  @Test
  public void test() {
    Assert.assertNotNull(this.category);
  }
}
