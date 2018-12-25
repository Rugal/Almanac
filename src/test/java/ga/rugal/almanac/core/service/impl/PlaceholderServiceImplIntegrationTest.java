package ga.rugal.almanac.core.service.impl;

import java.util.Optional;

import javax.annotation.Resource;

import ga.rugal.IntegrationTestBase;
import ga.rugal.almanac.core.entity.Translation;
import ga.rugal.almanac.core.service.PlaceholderService;
import ga.rugal.almanac.core.service.TranslationService;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Rugal Bernstein
 */
public class PlaceholderServiceImplIntegrationTest extends IntegrationTestBase {

  private static final String LANGUAGE = "language";

  private static final String LANGUAGE_PLACEHOLDE = "$" + LANGUAGE + "$";

  @Autowired
  private PlaceholderService service;

  @Autowired
  private TranslationService translationService;

  @Resource(name = "title")
  private Translation title;

  @Before
  public void before() {
    final Optional<Translation> findById = this.translationService.getDao().findById(3);
    Assert.assertTrue(findById.isPresent());
    this.title = findById.get();
  }

  @Test
  public void fillPlaceholder_isExplanation() {
    this.title.setAuspicious(true);
    Assert.assertNotNull(this.title.getAuspicious());
    final Translation result = this.service.fillPlaceholder(this.title, 0);
    Assert.assertNotNull(result.getAuspicious());
    Assert.assertThat(result.getContent(), Matchers.is(Matchers.containsString(LANGUAGE_PLACEHOLDE)));
  }

  @Test
  public void fillPlaceholder_noCategoryFound() {
    this.title = this.translationService.getDao().findById(5).get();
    Assert.assertNull(this.title.getAuspicious());
    Assert.assertThat(this.title.getContent(), Matchers.not(Matchers.containsString(LANGUAGE_PLACEHOLDE)));
    final Translation result = this.service.fillPlaceholder(this.title, 0);
    Assert.assertThat(result.getContent(), Matchers.not(Matchers.containsString(LANGUAGE_PLACEHOLDE)));
  }

  @Test
  public void fillPlaceholder_isNotEmpty() {
    Assert.assertNull(this.title.getAuspicious());
    Assert.assertThat(this.title.getContent(), Matchers.is(Matchers.containsString(LANGUAGE_PLACEHOLDE)));
    final Translation result = this.service.fillPlaceholder(this.title, 10);
    System.out.println(result.getContent());
    Assert.assertThat(result.getContent(), Matchers.not(Matchers.containsString(LANGUAGE_PLACEHOLDE)));
  }
}
