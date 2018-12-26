package config;

import ga.rugal.almanac.core.service.RandomService;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Rugal Bernstein
 */
@Configuration
public class UnitTestApplicationContext {

  @Bean
  public RandomService randomService() {
    return Mockito.mock(RandomService.class);
  }
}
