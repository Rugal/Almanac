package config;

/**
 * Some system level property.
 *
 * @author Rugal Bernstein
 */
public interface SystemDefaultProperty {

  String ENCODING = "UTF-8";

  String DEFAULT_LANGUAGE = "en";

  String DEFAULT_COUNTRY = "us";

  String DEFAULT_LOCALE = DEFAULT_LANGUAGE + "-" + DEFAULT_COUNTRY;

  String DATA_FILE = "data.yml";
}
