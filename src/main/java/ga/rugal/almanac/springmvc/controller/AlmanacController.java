package ga.rugal.almanac.springmvc.controller;

import java.util.Date;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

import config.Constant;

import ga.rugal.almanac.core.entity.localized.LocalizedAlmanac;
import ga.rugal.almanac.core.service.AlmanacService;
import ga.rugal.almanac.swagger.api.AlmanacApi;
import ga.rugal.almanac.swagger.request.AlmanacDto;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Almanac controller.
 *
 * @author Rugal Bernstein
 */
@Controller
@Slf4j
public class AlmanacController implements AlmanacApi {

  @Autowired
  private HttpServletRequest request;

  @Autowired
  private AlmanacService almanacService;

  @ModelAttribute
  public String getLocale(final HttpServletRequest request) {
    return (String) request.getAttribute(Constant.LOCALE);
  }

  /**
   * Get daily almanac.<BR>
   * 1. Get internationalization almanac object from system<BR>
   * 2. Pick corresponding language based on locale from request<BR>
   * 3. Transform data to DTO<BR>
   * 4. Return
   *
   * @param headerLocale possible header locale
   * @param queryLocale  possible query locale
   *
   * @return
   */
  @Override
  public ResponseEntity<AlmanacDto> getDailyAlmanac(final String headerLocale,
                                                    final String queryLocale) {
    final LocalizedAlmanac localize = this.almanacService
      .getAlmanac(new Date())
      .localize(this.getLocale(this.request));
    return new ResponseEntity(HttpStatus.OK);
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
