package ga.rugal.almanac.core.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ga.rugal.almanac.core.entity.Hexagram;
import ga.rugal.almanac.core.service.HexagramService;
import ga.rugal.almanac.core.service.LocaleService;
import ga.rugal.almanac.core.service.TranslationService;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation for almanac service.
 *
 * @author Rugal Bernstein
 */
@Getter
@Service
@Setter
public class AlmanacServiceImpl {

  @Autowired
  private TranslationService translationService;

  @Autowired
  private HexagramService hexagramService;

  @Autowired
  private LocaleService localeService;

  /**
   * Randomize number.
   *
   * @param dayseed   seed of day
   * @param indexseed seed of index
   *
   * @return
   */
  private int random(final int dayseed, final int indexseed) {
    int n = dayseed % 11117;
    for (int i = 0; i < 100 + indexseed; i++) {
      n = n * n;
      n = n % 11117;
    }
    return n;
  }

  /**
   * Pick total hexagrams from all available from DB.
   *
   * @param hexagrams source hexagrams that come from DB
   * @param daySeed   Day seed
   * @param size      size of hexagram going to pick
   *
   * @return picked hexagrams
   */
  private List<Hexagram> pickTotalHexagrams(final List<Hexagram> hexagrams,
                                            final int daySeed,
                                            final int size) {
    final List<Hexagram> dest = new ArrayList<>(hexagrams.size());
    Collections.copy(dest, hexagrams);
    for (int i = 0; i < hexagrams.size() - size; i++) {
      dest.remove(this.random(daySeed, i) % dest.size());
    }
    return dest;
  }

  /**
   * Get I18N almanac object.
   *
   * @param daySeed day seed to generate almanac
   */
  public void getAlmanac(final int daySeed) {
    final int numGood = this.random(daySeed, 98) % 3 + 2;
    final int numBad = this.random(daySeed, 87) % 3 + 2;
    this.pickTotalHexagrams(Lists.newArrayList(this.hexagramService.getDao().findAll()),
                            daySeed,
                            numBad + numGood);
  }
}
