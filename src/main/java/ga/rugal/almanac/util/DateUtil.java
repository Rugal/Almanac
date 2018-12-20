package ga.rugal.almanac.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class of date related utilities.
 *
 * @author Rugal Bernstein
 */
public class DateUtil {

  private static final String DATE_FORMAT = "yyyy-MM-dd";

  private DateUtil() {}

  /**
   * Convert date to string.
   *
   * @param date Date to covert
   *
   * @return String representation
   */
  public static String getDateString(final Date date) {
    return new SimpleDateFormat(DATE_FORMAT).format(date);
  }
}
