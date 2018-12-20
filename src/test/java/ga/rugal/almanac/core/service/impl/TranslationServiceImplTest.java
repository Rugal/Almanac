package ga.rugal.almanac.core.service.impl;

import ga.rugal.UnitTestBase;
import ga.rugal.almanac.core.dao.TranslationDao;
import ga.rugal.almanac.core.entity.Translation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 *
 * @author Rugal Bernstein
 */
public class TranslationServiceImplTest extends UnitTestBase {

  @Autowired
  private Translation title;

  private final TranslationServiceImpl translationService = new TranslationServiceImpl();

  @MockBean
  private TranslationDao translationDao;

  @Before
  public void before() {
    this.translationService.setDao(this.translationDao);
  }

  @Test
  public void test() {
    Assert.assertNotNull(this.title);
  }
}
