package ga.rugal.almanac.springmvc.controller;

import java.util.Date;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import config.Constant;

import ga.rugal.almanac.core.entity.AlmanacDatabase;
import ga.rugal.almanac.core.service.AlmanacService;
import ga.rugal.almanac.springmvc.mapper.almanac.Almanac;
import ga.rugal.almanac.swagger.api.AlmanacApi;
import ga.rugal.almanac.swagger.request.AlmanacDto;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

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

  @Autowired
  private AlmanacDatabase database;

  @ModelAttribute
  public String getLocale(final HttpServletRequest request) {
    assert request != null;
    return (String) request.getAttribute(Constant.LOCALE);
  }

  @Override
  public ResponseEntity<AlmanacDto> getDailyAlmanac(final @RequestHeader(value = "Accept-Language",
                                                                         required = false)
                                                      String headerLocale,
                                                    final @Valid @RequestParam(value = "locale", 
                                                                               required = false)
                                                      String queryLocale) {
    //Get I18N almanac
    //Get translation by locale
    final String locale = this.getLocale(this.request);
    LOG.info(locale);
    final Almanac almanac = this.almanacService.getAlmanac(new Date());
    LOG.info("{}", almanac);
    LOG.info("{}", this.database);
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
