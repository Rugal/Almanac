package ga.rugal.almanac.springmvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/**
 *
 * @author Rugal Bernstein
 */
@WebMvcTest(IndexController.class)
public class IndexControllerTest extends UnitTestControllerBase {

  //@MockBean
  //private Dependency d;
  @Autowired
  private MockMvc mockMvc;

  @Before
  public void setUp() {
  }

  @Test
  public void index_200() throws Exception {
    this.mockMvc.perform(get("/")
      .accept(MediaType.APPLICATION_JSON_UTF8))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
  }
}
