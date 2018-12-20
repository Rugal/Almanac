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

  /**
   * Randomize number.
   *
   * @param dayseed   seed of day
   * @param indexseed seed of index
   *
   * @return
   */
  public static int random(final int dayseed, final int indexseed) {
    int n = dayseed % 11117;
    for (int i = 0; i < 100 + indexseed; i++) {
      n = n * n;
      n = n % 11117;
    }
    return n;
  }
}
