package ga.rugal.almanac.core.service.impl;

import ga.rugal.IntegrationTestBase;
import ga.rugal.almanac.core.service.LocaleService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Rugal Bernstein
 */
public class LocaleServiceImplIntegrationTest extends IntegrationTestBase {

  @Autowired
  private LocaleService localeService;

  @Before
  public void before() {
  }

  @Test
  public void test() {
    Assert.assertNotNull(this.localeService.getDao());
  }
}
