package ga.rugal.almanac.springmvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;

/**
 *
 * @author Rugal Bernstein
 */
public class IndexControllerIntegrationTest extends ControllerClientSideTestBase {

  @Before
  public void setUp() {
  }

  @Test
  public void get_200() throws Exception {
    this.mockMvc.perform(get("/")
      .accept(MediaType.APPLICATION_JSON_UTF8))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
      .andDo(print());
  }
}
