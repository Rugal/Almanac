package ga.rugal.almanac.springmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Index controller.
 *
 * @author Rugal Bernstein
 */
@RestController
public class IndexController {

  /**
   * Index.
   *
   * @return response object
   */
  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> index() {
    return new ResponseEntity<>("running", HttpStatus.OK);
  }
}
