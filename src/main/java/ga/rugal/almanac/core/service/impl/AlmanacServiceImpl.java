package ga.rugal.almanac.core.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import ga.rugal.almanac.core.entity.Almanac;
import ga.rugal.almanac.core.entity.AlmanacDatabase;
import ga.rugal.almanac.core.entity.Hexagram;
import ga.rugal.almanac.core.entity.Locale;
import ga.rugal.almanac.core.service.AlmanacService;
import ga.rugal.almanac.core.service.PlaceholderService;
import ga.rugal.almanac.core.service.RandomService;

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
public class AlmanacServiceImpl implements AlmanacService {

  @Autowired
  private AlmanacDatabase database;

  @Autowired
  private RandomService randomService;

  @Autowired
  private PlaceholderService placeholderService;

  private Almanac cache = null;

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
    final List<Hexagram> dest = new ArrayList<>(hexagrams);
    for (int i = 0; i < hexagrams.size() - size; i++) {
      dest.remove(this.randomService.random(daySeed, i) % dest.size());
    }
    return dest;
  }

  private Locale getDirection(final int daySeed) {
    return this.database.getDirection()
      .get(this.randomService.random(daySeed, 23) % this.database.getDirection().size());
  }

  private List<Hexagram> getHexagrams(final int numGood, final int numBad, final int daySeed) {
    return this.pickTotalHexagrams(this.database.getHexagram(), daySeed, numBad + numGood);
  }

  private List<Locale> getBeverages(final int numBeverage, final int daySeed) {
    final List<Locale> beverages = Lists.newArrayList();
    for (int i = 0; i < numBeverage; ++i) {
      final Locale beverage = this.database.getBeverage()
        .get(this.randomService.random(daySeed, i) % this.database.getBeverage().size());
      beverages.add(beverage);
    }
    return beverages;
  }

  /**
   * Calculate day difference between current time and cached date.
   *
   * @param date current date
   *
   * @return day difference
   */
  private int dayDifference(final Date date) {
    return (int) ((date.getTime() - this.cache.getDate().getTime()) / (1000 * 60 * 60 * 24));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Almanac getAlmanac(final Date date) {
    if (null != this.cache && this.dayDifference(date) < 1) {
      return this.cache;
    }

    final int daySeed = this.randomService.getCurrentDateNumber(date);
    final int numGood = this.randomService.random(daySeed, 98) % 4 + 1;
    final int numBad = this.randomService.random(daySeed, 87) % 3;
    final int numBeverage = this.randomService.random(daySeed, 113) % 4;

    final List<Hexagram> hexagrams = this.getHexagrams(numGood, numBad, daySeed);
    //fill placeholder
    this.placeholderService.fillPlaceholders(hexagrams, daySeed);
    Collections.shuffle(hexagrams);

    this.cache = Almanac.builder()
      .date(date)
      .auspicious(hexagrams.subList(0, numGood))
      .inauspicious(hexagrams.subList(numGood, numBad + numGood))
      .approachability(this.randomService.random(daySeed, 13) % 11)
      .beverage(this.getBeverages(numBeverage, daySeed))
      .direction(this.getDirection(daySeed))
      .build();

    return this.cache;
  }
}
