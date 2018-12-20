package ga.rugal.almanac.core.service.impl;

import ga.rugal.UnitTestBase;
import ga.rugal.almanac.core.dao.LocaleDao;
import ga.rugal.almanac.core.entity.Locale;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 *
 * @author Rugal Bernstein
 */
public class LocaleServiceImplTest extends UnitTestBase {

  @Autowired
  private Locale locale;

  private final LocaleServiceImpl localeService = new LocaleServiceImpl();

  @MockBean
  private LocaleDao localeDao;

  @Before
  public void before() {
    this.localeService.setDao(this.localeDao);
  }

  @Test
  public void test() {
    Assert.assertNotNull(this.locale);
  }
}
