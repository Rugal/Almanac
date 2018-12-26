package ga.rugal.almanac.util;

import java.util.Locale;

/**
 * Class of Locale related utilities.<BR>
 * Refer to https://tools.ietf.org/html/rfc5646
 *
 * @author Rugal Bernstein
 */
public class LocaleUtil {

  private static final String DASH = "-";

  private LocaleUtil() {
  }

  /**
   * Generate RFC formatted locale from language and country.
   *
   * @param language language code
   * @param country  country code
   *
   * @return the first two characters of RFC formatted locale
   */
  public static String toRfcLocaleFormat(final String language, final String country) {
    return String.format("%s-%s",
                         language.toLowerCase(Locale.ENGLISH),
                         country.toUpperCase(Locale.ENGLISH));
  }

  /**
   * Get language code from RFC formatted locale.
   *
   * @param rfcLocale [language]-[COUNTRY]
   *
   * @return the first two characters of RFC formatted locale
   */
  public static String getLanguage(final String rfcLocale) {
    return rfcLocale.toLowerCase(Locale.ENGLISH).substring(0, 2);
  }

  /**
   * Get country code from RFC formatted locale.
   *
   * @param rfcLocale [language]-[COUNTRY]
   *
   * @return the last two characters of RFC formatted locale
   */
  public static String getCountry(final String rfcLocale) {
    return rfcLocale.contains(DASH)
           ? rfcLocale.toUpperCase(Locale.ENGLISH).substring(3)
           : "";
  }
}
