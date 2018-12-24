package config;

import ga.rugal.almanac.core.dao.CategoryDao;
import ga.rugal.almanac.core.dao.LocaleDao;
import ga.rugal.almanac.core.dao.HexagramDao;
import ga.rugal.almanac.core.dao.PlaceholderDao;
import ga.rugal.almanac.core.dao.TranslationDao;
import ga.rugal.almanac.core.service.CategoryService;
import ga.rugal.almanac.core.service.LocaleService;
import ga.rugal.almanac.core.service.HexagramService;
import ga.rugal.almanac.core.service.PlaceholderService;
import ga.rugal.almanac.core.service.TranslationService;

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
  public CategoryDao categoryDao() {
    return Mockito.mock(CategoryDao.class);
  }

  @Bean
  public HexagramDao hexagramDao() {
    return Mockito.mock(HexagramDao.class);
  }

  @Bean
  public LocaleDao localeDao() {
    return Mockito.mock(LocaleDao.class);
  }

  @Bean
  public TranslationDao translationDao() {
    return Mockito.mock(TranslationDao.class);
  }

  @Bean
  public PlaceholderDao placeholderDao() {
    return Mockito.mock(PlaceholderDao.class);
  }

  @Bean
  public CategoryService categoryService() {
    return Mockito.mock(CategoryService.class);
  }

  @Bean
  public LocaleService localeService() {
    return Mockito.mock(LocaleService.class);
  }

  @Bean
  public HexagramService hexagramService() {
    return Mockito.mock(HexagramService.class);
  }

  @Bean
  public TranslationService translationService() {
    return Mockito.mock(TranslationService.class);
  }

  @Bean
  public PlaceholderService placeholderService() {
    return Mockito.mock(PlaceholderService.class);
  }
}
