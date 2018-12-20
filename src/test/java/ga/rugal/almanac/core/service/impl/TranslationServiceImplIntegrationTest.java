package ga.rugal.almanac.core.service.impl;

import ga.rugal.IntegrationTestBase;
import ga.rugal.almanac.core.service.TranslationService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Rugal Bernstein
 */
public class TranslationServiceImplIntegrationTest extends IntegrationTestBase {

  @Autowired
  private TranslationService translationService;

  @Before
  public void before() {
  }

  @Test
  public void test() {
    Assert.assertNotNull(this.translationService.getDao());
  }
}
