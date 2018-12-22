package ga.rugal.almanac.springmvc.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

import config.Constant;

import ga.rugal.almanac.swagger.api.AlmanacApi;
import ga.rugal.almanac.swagger.request.AlmanacDto;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class AlmanacController implements AlmanacApi {

  @Autowired
  private HttpServletRequest request;

  /**
   * Get number of current date.
   *
   * @return
   */
  public int getCurrentDateNumber() {
    final Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    return cal.get(Calendar.YEAR) * 10000
           + (cal.get(Calendar.MONTH) + 1) * 100
           + cal.get(Calendar.DAY_OF_MONTH);
  }

  @ModelAttribute
  public String getLocale(final HttpServletRequest request) {
    return (String) request.getAttribute(Constant.LOCALE);
  }

  @Override
  public ResponseEntity<AlmanacDto> getDailyAlmanac(final String headerLocale,
                                                    final String queryLocale) {
    //Get I18N almanac
    //Get translation by locale
    final String locale = this.getLocale(this.request);
    System.out.println(locale);
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
