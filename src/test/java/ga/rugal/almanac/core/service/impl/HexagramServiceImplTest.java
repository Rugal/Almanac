package ga.rugal.almanac.core.service.impl;

import ga.rugal.UnitTestBase;
import ga.rugal.almanac.core.dao.HexagramDao;
import ga.rugal.almanac.core.entity.Hexagram;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 *
 * @author Rugal Bernstein
 */
public class HexagramServiceImplTest extends UnitTestBase {

  @Autowired
  private Hexagram hexagram;

  private final HexagramServiceImpl hexagramService = new HexagramServiceImpl();

  /**
   * @MockBean will automatically be injected into service.
   */
  @MockBean
  private HexagramDao hexagramDao;

  @Before
  public void before() {
    //We do it here for covering setter
    this.hexagramService.setDao(this.hexagramDao);
  }

  @Test
  public void test() {
    Assert.assertNotNull(this.hexagram);
  }
}
