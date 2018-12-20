package ga.rugal.almanac.springmvc.controller;

import ga.rugal.IntegrationTestBase;

import org.junit.Before;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author rugal
 */
@ContextConfiguration(classes = config.SpringMvcApplicationContext.class)
@Ignore
@SpringBootTest
@WebAppConfiguration
public abstract class ControllerClientSideTestBase extends IntegrationTestBase {

  @Autowired
  public WebApplicationContext wac;

  public MockMvc mockMvc;

  @Before
  public void setup() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
  }
}
