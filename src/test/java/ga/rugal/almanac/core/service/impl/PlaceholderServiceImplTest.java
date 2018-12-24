package ga.rugal.almanac.core.service.impl;

import javax.annotation.Resource;

import ga.rugal.UnitTestBase;

import org.junit.Before;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 *
 * @author Rugal Bernstein
 */
public class PlaceholderServiceImplTest extends UnitTestBase {

  private final PlaceholderServiceImpl service = new PlaceholderServiceImpl();

  @Resource(name = "explanation")
  private Translation explanation;

  @MockBean
  private PlaceholderDao dao;

  @MockBean
  private RandomService randomService;

  @Before
  public void setUp() {
  }
}
