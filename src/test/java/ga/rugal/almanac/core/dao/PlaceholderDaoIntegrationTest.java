package ga.rugal.almanac.core.dao;

import java.util.Set;

import ga.rugal.IntegrationTestBase;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Rugal Bernstein
 */
public class PlaceholderDaoIntegrationTest extends IntegrationTestBase {

  @Autowired
  private PlaceholderDao dao;

  @Test
  public void findDistinctCategory() {
    final Set<Integer> result = this.dao.findDistinctCategory();
    Assert.assertThat(result.size(), Matchers.is(Matchers.greaterThan(2)));
  }
}
