package ga.rugal.almanac.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ga.rugal.UnitTestBase;
import ga.rugal.almanac.core.dao.PlaceholderDao;
import ga.rugal.almanac.core.entity.Placeholder;
import ga.rugal.almanac.core.entity.Translation;
import ga.rugal.almanac.core.service.RandomService;

import com.google.common.collect.Lists;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;

/**
 *
 * @author Rugal Bernstein
 */
public class PlaceholderServiceImplTest extends UnitTestBase {

  private static final String LANGUAGE = "language";

  private static final String LANGUAGE_PLACEHOLDE = "$" + LANGUAGE + "$";

  private final PlaceholderServiceImpl service = new PlaceholderServiceImpl();

  @Autowired
  private Placeholder placeholder;

  @Resource(name = "explanation")
  private Translation explanation;

  @MockBean
  private PlaceholderDao dao;

  @MockBean
  private RandomService randomService;

  private List<Placeholder> list;

  @MockBean
  private Page<Placeholder> page;

  @Before
  public void setUp() {
    this.service.setDao(this.dao);
    this.service.setRandomService(this.randomService);
    //data
    this.list = Lists.newArrayList(this.placeholder);
    this.explanation.getHexagram().getCategory().setName(LANGUAGE);
    this.explanation.setContent(String.format("TEST %s TEST", LANGUAGE_PLACEHOLDE));
    //random service
    BDDMockito.given(this.randomService.random(BDDMockito.anyInt(), BDDMockito.anyInt()))
      .willReturn(9);
    //placeholder dao
    BDDMockito.given(this.dao.countByCategory(BDDMockito.any())).willReturn(5);
    BDDMockito.given(this.dao.findByCategory(BDDMockito.any(), BDDMockito.any()))
      .willReturn(this.page);
    //page
    BDDMockito.given(this.page.isEmpty()).willReturn(false);
    BDDMockito.given(this.page.getContent()).willReturn(this.list);

  }

  @Test
  public void fillPlaceholder_null() {
    this.explanation.setAuspicious(null);
    Assert.assertNull(this.explanation.getAuspicious());
    final Translation result = this.service.fillPlaceholder(this.explanation, 0);
    Assert.assertNull(result.getAuspicious());
  }

  @Test
  public void fillPlaceholder_isEmpty() {
    BDDMockito.given(this.page.isEmpty()).willReturn(true);
    Assert.assertNotNull(this.explanation.getAuspicious());
    Assert.assertThat(this.explanation.getContent(),
                      Matchers.is(Matchers.containsString(LANGUAGE_PLACEHOLDE)));
    final Translation result = this.service.fillPlaceholder(this.explanation, 0);
    Assert.assertThat(result.getContent(), Matchers.is(Matchers.containsString(LANGUAGE_PLACEHOLDE)));
  }

  @Test
  public void fillPlaceholder_notEmpty() {
    Assert.assertNotNull(this.explanation.getAuspicious());
    Assert.assertThat(this.explanation.getContent(),
                      Matchers.is(Matchers.containsString(LANGUAGE_PLACEHOLDE)));
    final Translation result = this.service.fillPlaceholder(this.explanation, 0);
    Assert.assertThat(result.getContent(),
                      Matchers.not(Matchers.containsString(LANGUAGE_PLACEHOLDE)));
    Assert.assertThat(result.getContent(),
                      Matchers.is(Matchers.containsString(this.placeholder.getName())));
  }
}
