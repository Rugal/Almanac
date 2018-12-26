package config;

import ga.rugal.almanac.springmvc.controller.PackageInfo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.AbstractHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * Java based Web context configuration class. Including argument resolution, message converter,
 * view resolution etc.,
 *
 * @author Rugal Bernstein
 * @since 0.2
 */
@ComponentScan(basePackageClasses = PackageInfo.class)
@Configuration
@EnableWebMvc
public class SpringMvcApplicationContext implements WebMvcConfigurer {

  @Override
  public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }

  @Override
  public void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {
    configurer.favorPathExtension(false).favorParameter(false);
    configurer.defaultContentType(MediaType.APPLICATION_JSON);
  }

  /**
   * Handler adapter.
   *
   * @return
   */
  @Bean
  public HandlerAdapter handlerAdapter() {
    return new RequestMappingHandlerAdapter();
  }

  /**
   * Handler mapping.
   *
   * @return
   */
  @Bean
  public AbstractHandlerMapping defaultAnnotationHandlerMapping() {
    final RequestMappingHandlerMapping mapping = new RequestMappingHandlerMapping();
    mapping.setUseSuffixPatternMatch(false);
    return mapping;
  }

  @Override
  public void addInterceptors(final InterceptorRegistry registry) {
    //    registry.addInterceptor(new AcceptLanguageInterceptor()).addPathPatterns("/");
  }

  @Override
  public void addCorsMappings(final CorsRegistry registry) {
    registry.addMapping("/**")
      .allowedOrigins("*")
      .allowedMethods("*")
      .allowedHeaders("*");
  }
}
