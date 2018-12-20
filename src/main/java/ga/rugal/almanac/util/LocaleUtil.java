package ga.rugal.almanac.util;

import java.util.Locale;

/**
 * Class of Locale related utilities.<BR>
 * Refer to https://tools.ietf.org/html/rfc5646
 *
 * @author Rugal Bernstein
 */
public class LocaleUtil {

  private LocaleUtil() {
  }

  public static String toRfcLocaleFormat(final String language, final String country) {
    return String.format("%s-%s", language, country.toUpperCase(Locale.ENGLISH));
  }

  /**
   * Get language code from RFC formatted locale.
   *
   * @param rfcLocale [language]-[country]
   *
   * @return the first two characters of RFC formatted locale
   */
  public static String getLanguage(final String rfcLocale) {
    return rfcLocale.toLowerCase(Locale.ENGLISH).substring(0, 2);
  }

  /**
   * Get country code from RFC formatted locale.
   *
   * @param rfcLocale [language]-[country]
   *
   * @return the last two characters of RFC formatted locale
   */
  public static String getCountry(final String rfcLocale) {
    return rfcLocale.toLowerCase(Locale.ENGLISH).substring(3);
  }
}
