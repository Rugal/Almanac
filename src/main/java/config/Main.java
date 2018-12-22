package config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entrance for micro service.
 *
 * @author Rugal Bernstein
 */
@SpringBootApplication
public class Main {

  public static void main(final String[] args) {
    SpringApplication.run(Main.class, args);
  }
}
