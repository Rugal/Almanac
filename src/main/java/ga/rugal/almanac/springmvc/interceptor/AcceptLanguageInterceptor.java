package ga.rugal.almanac.springmvc.interceptor;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.Constant;
import config.SystemDefaultProperty;

import ga.rugal.almanac.core.entity.Locale;
import ga.rugal.almanac.core.service.LocaleService;
import ga.rugal.almanac.util.LocaleUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * This interceptor is to detect accept-language header and preset content-language properly.
 *
 * @author Rugal Bernstein
 */
@Component
@Slf4j
public class AcceptLanguageInterceptor implements HandlerInterceptor {

  private static final String ACCEPT_LANGUAGE = "accept-language";

  private static final String CONTENT_LANGUAGE = "content-language";

  private static final String DASH = "-";

  @Autowired
  private LocaleService localeService;

  /**
   * Set locale attribute accordingly.<BR>
   * 1. Return locale from query parameter if found, otherwise<BR>
   * 2. Return locale from header if found, otherwise<BR>
   * 3. Return {@link SystemDefaultProperty#DEFAULT_LOCALE}
   *
   * @param request  Request
   * @param response Response
   * @param handler  Handler
   *
   * @return Always pass this interceptor
   *
   * @throws Exception Never throw exception from here
   */
  @Override
  public boolean preHandle(final HttpServletRequest request,
                           final HttpServletResponse response,
                           final Object handler) throws Exception {
    //The default locale
    request.setAttribute(Constant.LOCALE, SystemDefaultProperty.DEFAULT_LOCALE);

    //first by query parameter
    final String queryLocale = this.matchLocale(request.getParameter(Constant.LOCALE));
    if (!StringUtils.isEmpty(queryLocale)) {
      request.setAttribute(Constant.LOCALE, queryLocale);
      LOG.debug(String.format("Use locale %s from query parameter",
                              request.getAttribute(Constant.LOCALE)));
      return true;
    }

    //then by header
    final String headerLocale = this.getLocaleByHeader(request);
    if (!StringUtils.isEmpty(headerLocale)) {
      request.setAttribute(Constant.LOCALE, headerLocale);
      LOG.debug(String.format("Use locale %s from header", request.getAttribute(Constant.LOCALE)));
      return true;
    }

    //lastly use default locale
    LOG.debug(String.format("Use default locale %s", request.getAttribute(Constant.LOCALE)));
    return true;
  }

  /**
   * Find locale from request header.<BR>
   * 1. If no `accept-language` header found, return {@code null}<BR>
   * 2. Parse `accept-language` into {@code language/country} and {@code language} format, namely
   * potential language list<BR>
   * 3. Loop through potential language list to see if any fields matched<BR>
   * 4. Return first matched field if matched, otherwise return {@link null}
   *
   * @param request
   *
   * @return
   */
  private String getLocaleByHeader(final HttpServletRequest request) {
    final String acceptLanguage = request.getHeader(ACCEPT_LANGUAGE);
    if (StringUtils.isEmpty(acceptLanguage)) {
      //Use default locale
      return null;
    }

    for (String s : acceptLanguage.split(",")) {
      final String locale = this.matchLocale(s.trim());
      if (!StringUtils.isEmpty(locale)) {
        return locale;
      }
    }

    return null;
  }

  /**
   * Try to match locale string with system predefined language from database.
   *
   * @param localeString in RFC format, either [language]-[country], or [language]
   *
   * @return matched locale
   */
  private String matchLocale(final String localeString) {
    //Either match language or locale, or even null
    if (StringUtils.isEmpty(localeString)) {
      return null;
    }
    final String language = LocaleUtil.getLanguage(localeString);
    final String country = localeString.contains(DASH) ? LocaleUtil.getCountry(localeString) : "";
    if (this.localeService.getDao().findByLanguageAndCountry(language, country).isPresent()) {
      return localeString;
    }
    final List<Locale> findByLanguage = this.localeService.getDao().findByLanguage(language);
    if (!findByLanguage.isEmpty()) {
      final Locale locale = findByLanguage.get(0);
      return LocaleUtil.toRfcLocaleFormat(locale.getLanguage(), locale.getCountry());
    }
    //after all, use this as default
    return null;
  }

  /**
   * Set `content-language` response header properly.
   *
   * @param request  The request to get attribute from
   * @param response The response to set header to
   * @param handler  Won't use here
   * @param mav      The view
   *
   * @throws Exception No exception
   */
  @Override
  public void postHandle(final HttpServletRequest request,
                         final HttpServletResponse response,
                         final Object handler,
                         final ModelAndView mav) throws Exception {
    response.setHeader(CONTENT_LANGUAGE, (String) request.getAttribute(Constant.LOCALE));
  }

  @Override
  public void afterCompletion(final HttpServletRequest hsr,
                              final HttpServletResponse hsr1,
                              final Object handler,
                              final Exception excptn) throws Exception {
  }
}
