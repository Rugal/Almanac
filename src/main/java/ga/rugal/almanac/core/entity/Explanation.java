package ga.rugal.almanac.core.entity;

import lombok.Data;

/**
 * Class for holding localized explanation.
 *
 * @author Rugal Bernstein
 */
@Data
public class Explanation {

  private Locale auspicious;

  private Locale inauspicious;
}
