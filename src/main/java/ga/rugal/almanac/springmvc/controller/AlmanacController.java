package ga.rugal.almanac.springmvc.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import ga.rugal.almanac.swagger.api.AlmanacApi;
import ga.rugal.almanac.swagger.request.AlmanacDto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

/**
 * Almanac controller.
 *
 * @author Rugal Bernstein
 */
@Controller
public class AlmanacController implements AlmanacApi {

  @Override
  public ResponseEntity<AlmanacDto> getDailyAlmanac() {
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public Optional<ObjectMapper> getObjectMapper() {
    return AlmanacApi.super.getObjectMapper();
  }

  @Override
  public Optional<HttpServletRequest> getRequest() {
    return AlmanacApi.super.getRequest();
  }

  @Override
  public Optional<String> getAcceptHeader() {
    return AlmanacApi.super.getAcceptHeader();
  }
}
