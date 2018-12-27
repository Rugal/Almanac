package ga.rugal.almanac.core.entity.localized;

import lombok.Builder;
import lombok.Value;

/**
 * Class for localized hexagram.
 *
 * @author Rugal Bernstein
 */
@Builder
@Value
public class LocalizedHexagram {

  private String title;

  private String explanation;
}
