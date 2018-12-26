package config;

import java.io.InputStream;

import ga.rugal.almanac.core.entity.AlmanacDatabase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

/**
 * Read basic application context.
 *
 * @author Rugal Bernstein
 */
@Configuration
public class ApplicationContext {

  /**
   * Read almanac data from configuration file.
   *
   * @return
   */
  @Bean
  public AlmanacDatabase almanac() {
    final InputStream inputStream = this.getClass()
      .getClassLoader()
      .getResourceAsStream(SystemDefaultProperty.DATA_FILE);
    return new Yaml(new Constructor(AlmanacDatabase.class)).load(inputStream);
  }
}
