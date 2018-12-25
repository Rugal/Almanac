package ga.rugal.almanac.core.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import ga.rugal.almanac.core.entity.Hexagram;
import ga.rugal.almanac.core.service.HexagramService;
import ga.rugal.almanac.core.service.LocaleService;
import ga.rugal.almanac.core.service.PlaceholderService;
import ga.rugal.almanac.core.service.RandomService;
import ga.rugal.almanac.core.service.TranslationService;
import ga.rugal.almanac.springmvc.mapper.almanac.Almanac;
import ga.rugal.almanac.springmvc.mapper.hexagram.CompleteHexagram;

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
  private RandomService randomService;

  @Autowired
  private PlaceholderService placeholderService;

  @Autowired
  private TranslationService translationService;

  @Autowired
  private HexagramService hexagramService;

  @Autowired
  private LocaleService localeService;

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
   * Get complete hexagrams. If contains language, naming or editor related category, fill them.
   *
   * @param hexagrams random hexagram selected by random seed
   * @param daySeed   random seed to enable random nature
   *
   * @return filled completed hexagrams
   */
  private List<CompleteHexagram> getCompleteHexagrams(final List<Hexagram> hexagrams,
                                                      final int daySeed) {
    final Set<Integer> cids = this.placeholderService.getDao().findDistinctCategory();

    return hexagrams.stream().map((hexagram) -> {
      final CompleteHexagram complete = this.translationService.getDao()
        .findCompleteByHexagram(hexagram);
      if (cids.contains(hexagram.getCategory().getCid())) {
        //need to fill placeholder
        this.placeholderService.fillPlaceholders(complete.getExplanations(), daySeed);
      }
      return complete;
    }).collect(Collectors.toList());
  }

  /**
   * Get I18N almanac object.
   *
   * @param daySeed day seed to generate almanac
   *
   * @return completed, filled I18N almanac object
   */
  public Almanac getAlmanac(final int daySeed) {
    final int numGood = this.randomService.random(daySeed, 98) % 3 + 2;
    final int numBad = this.randomService.random(daySeed, 87) % 3 + 1;
    final List<Hexagram> hexagrams = this.pickTotalHexagrams(
      Lists.newArrayList(this.hexagramService.getDao().findAll()),
      daySeed,
      numBad + numGood);
    final List<CompleteHexagram> completeHexagrams = this.getCompleteHexagrams(hexagrams, daySeed);
    Collections.shuffle(completeHexagrams);
    return Almanac.builder()
      .auspicious(completeHexagrams.subList(0, numGood))
      .inauspicious(completeHexagrams.subList(numGood, numBad + numGood))
      .approachability(this.randomService.random(daySeed, 13) % 11)
      .build();
  }
}
