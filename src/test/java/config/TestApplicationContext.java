package config;

import ga.rugal.almanac.core.entity.Category;
import ga.rugal.almanac.core.entity.Hexagram;
import ga.rugal.almanac.core.entity.Locale;
import ga.rugal.almanac.core.entity.Translation;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Rugal Bernstein
 */
@Configuration
public class TestApplicationContext {

  @Bean
  public Faker faker() {
    return new Faker();
  }

  @Bean
  @Scope("prototype")
  public Category category(final Faker faker) {
    final Category category = new Category();
    category.setCid(0);
    category.setName(faker.name().username());
    return category;
  }

  @Bean
  @Scope("prototype")
  public Hexagram hexagram(final Category category, final Faker faker) {
    final Hexagram hexagram = new Hexagram();
    hexagram.setHid(0);
    hexagram.setCategory(category);
    hexagram.setWeekend(false);
    return hexagram;
  }

  @Bean
  @Scope("prototype")
  public Locale locale() {
    final Locale locale = new Locale();
    locale.setLid(0);
    locale.setLanguage("en");
    locale.setCountry("us");
    return locale;
  }

  @Bean
  @Scope("prototype")
  public Translation title(final Hexagram hexagram, final Locale locale, final Faker faker) {
    final Translation translation = new Translation();
    translation.setTid(0);
    translation.setContent(faker.funnyName().name());
    translation.setHexagram(hexagram);
    translation.setLocale(locale);
    translation.setAspicious(null);
    return translation;
  }

  @Bean
  @Scope("prototype")
  public Translation explanation(final Translation title) {
    title.setAspicious(true);
    return title;
  }
}
