package ga.rugal;

import config.TestApplicationContext;
import config.UnitTestApplicationContext;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This is a base test class for any unit test in testing stage<BR>
 * with the assistance of this test base class, there is no need to redeploy web server over and
 * over again, which is too time wastage.<BR>
 * Any classes that extends this class could have the capability to test without web server
 * deployment
 *
 * @author Rugal Bernstein
 */
@ContextConfiguration(classes = {TestApplicationContext.class, UnitTestApplicationContext.class})
@Ignore
@RunWith(SpringRunner.class)
public abstract class UnitTestBase {
}
