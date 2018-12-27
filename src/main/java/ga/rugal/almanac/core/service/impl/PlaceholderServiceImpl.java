package ga.rugal.almanac.core.service.impl;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.List;
import javax.validation.constraints.NotNull;

import ga.rugal.almanac.core.entity.AlmanacDatabase;
import ga.rugal.almanac.core.entity.Hexagram;
import ga.rugal.almanac.core.entity.Locale;
import ga.rugal.almanac.core.service.PlaceholderService;
import ga.rugal.almanac.core.service.RandomService;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation for filling placeholder of explanation.
 *
 * @author Rugal Bernstein
 */
@Service
@Slf4j
public class PlaceholderServiceImpl implements PlaceholderService {

  private static final String[] PLACEHOLDERS = new String[]{"language", "naming", "editor"};

  @Autowired
  private AlmanacDatabase database;

  @Autowired
  private RandomService randomService;

  private List<String> findCandidate(final String text, final String pattern) {
    final List<String> result = Lists.newArrayList();
    if (!text.contains(String.format("$%s$", pattern))) {
      return result;
    }
    try {
      final Field field = AlmanacDatabase.class.getField(pattern);
      AccessController.doPrivileged((PrivilegedAction) () -> {
        field.setAccessible(true);
        return null;
      });
      return (List<String>) field.get(this.database);
    } catch (final NoSuchFieldException ex) {
      LOG.error("Unable to find field [{}] from AlmanacDatabase class", pattern);
    } catch (final SecurityException | IllegalArgumentException | IllegalAccessException ex) {
      LOG.error("Not likily to happen", ex);
    }
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Locale fillPlaceholder(final @NotNull Locale locale, final int daySeed) {
    for (String placeholder : PLACEHOLDERS) {
      final List<String> candidate = this.findCandidate(locale.getEn(), placeholder);
      if (!candidate.isEmpty()) {
        //get random index
        final int index = this.randomService.random(daySeed, 119) % candidate.size();
        LOG.debug("Get random index [{}]", index);
        //Get value by index from candidate list
        final String value = candidate.get(index);
        final String format = String.format("$%s$", placeholder);
        //Override content, we may need to change this
        LOG.debug("Replace placeholder [{}] with value [{}]", format, value);
        locale.setEn(locale.getEn().replace(format, value));
        locale.setZh(locale.getZh().replace(format, value));
        break;
      }
    }
    return locale;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Hexagram> fillPlaceholders(final List<Hexagram> hexagrams,
                                         final int daySeed) {
    hexagrams.stream().forEach(h -> this.fillPlaceholder(h.getTitle(), daySeed));
    return hexagrams;
  }
}
