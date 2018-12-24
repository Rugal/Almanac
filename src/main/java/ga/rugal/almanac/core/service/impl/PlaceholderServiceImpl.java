package ga.rugal.almanac.core.service.impl;

import java.util.List;
import java.util.Objects;

import ga.rugal.almanac.core.dao.PlaceholderDao;
import ga.rugal.almanac.core.entity.Category;
import ga.rugal.almanac.core.entity.Placeholder;
import ga.rugal.almanac.core.entity.Translation;
import ga.rugal.almanac.core.service.PlaceholderService;
import ga.rugal.almanac.core.service.RandomService;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Implementation for filling placeholder of explanation.
 *
 * @author Rugal Bernstein
 */
@Service
public class PlaceholderServiceImpl implements PlaceholderService {

  @Autowired
  @Getter
  @Setter
  private PlaceholderDao dao;

  @Autowired
  @Setter
  private RandomService randomService;

  /**
   * {@inheritDoc}
   */
  @Override
  public Translation fillPlaceholder(final Translation translation, final int daySeed) {
    if (Objects.isNull(translation.getAuspicious())) {
      return translation;
    }
    //Get category somehow
    final Category category = translation.getHexagram().getCategory();
    //Paginate with size 1 so as to get random page by the page number
    final int randomPage = this.randomService.random(daySeed, 119)
                           % this.dao.countByCategory(category);
    final Page<Placeholder> page = this.dao.findByCategory(category,
                                                           PageRequest.of(randomPage, 1));
    if (!page.isEmpty()) {
      final Placeholder placeholder = page.getContent().get(0);
      final String format = String.format("$%s$", category.getName());
      //Override content, we may need to change this
      translation.setContent(translation.getContent().replace(format, placeholder.getName()));
    }
    return translation;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Translation> fillPlaceholders(final List<Translation> explanations,
                                            final int daySeed) {
    explanations.forEach((e) -> {
      this.fillPlaceholder(e, daySeed);
    });
    return explanations;
  }
}
