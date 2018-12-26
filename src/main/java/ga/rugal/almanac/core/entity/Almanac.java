package ga.rugal.almanac.core.entity;

import java.util.List;

import lombok.Data;

/**
 * Almanac class for storing overall application data.
 *
 * @author Rugal Bernstein
 */
@Data
public class Almanac {

  private List<Locale> beverage;

  private List<Locale> direction;

  private List<Hexagram> hexagram;
}
