package ga.rugal;

import config.ApplicationContext;
import config.TestApplicationContext;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This is a base test class for any integration test in testing stage<BR>
 * With this class, we don't need to import configuration for each test class repeatedly.
 *
 * @author Rugal Bernstein
 */
@ContextConfiguration(classes = {TestApplicationContext.class, ApplicationContext.class})
@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class IntegrationTestBase {
}
