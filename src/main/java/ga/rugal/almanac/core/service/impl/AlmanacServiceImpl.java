package ga.rugal.almanac.core.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import ga.rugal.almanac.core.entity.AlmanacDatabase;
import ga.rugal.almanac.core.entity.Hexagram;
import ga.rugal.almanac.core.entity.Locale;
import ga.rugal.almanac.core.service.AlmanacService;
import ga.rugal.almanac.core.service.RandomService;
import ga.rugal.almanac.springmvc.mapper.almanac.Almanac;

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
public class AlmanacServiceImpl implements AlmanacService {

  @Autowired
  private AlmanacDatabase database;

  @Autowired
  private RandomService randomService;

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
      dest.remove(this.randomService.random(daySeed, i) % dest.size());
    }
    return dest;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Almanac getAlmanac(final Date date) {
    final int daySeed = this.randomService.getCurrentDateNumber(date);
    final int numGood = this.randomService.random(daySeed, 98) % 3 + 2;
    final int numBad = this.randomService.random(daySeed, 87) % 3 + 1;

    final Locale beverage = this.database.getBeverage()
      .get(this.randomService.random(daySeed, 19) % this.database.getBeverage().size());
    final Locale direction = this.database.getDirection()
      .get(this.randomService.random(daySeed, 23) % this.database.getDirection().size());
    final List<Hexagram> hexagrams = this.pickTotalHexagrams(
      this.database.getHexagram(), daySeed, numBad + numGood);
    //fill placeholder

    Collections.shuffle(hexagrams);

    return Almanac.builder()
      .auspicious(hexagrams.subList(0, numGood))
      .inauspicious(hexagrams.subList(numGood, numBad + numGood))
      .approachability(this.randomService.random(daySeed, 13) % 11)
      .beverage(beverage)
      .direction(direction)
      .build();
  }
}
