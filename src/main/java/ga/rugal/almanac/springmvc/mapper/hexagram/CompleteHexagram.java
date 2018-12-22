package ga.rugal.almanac.springmvc.mapper.hexagram;

import ga.rugal.almanac.core.entity.Translation;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * Full hexagram with title and explanation.
 *
 * @author Rugal Bernstein
 */
@AllArgsConstructor
@Value
public class CompleteHexagram {

  @NotNull
  private Translation title;

  @NotNull
  private List<Translation> explanations;

  public CompleteHexagram(final List<Translation> translations) {
    this(translations.stream()
            .filter(a -> Objects.isNull(a.getAspicious()))
            .findFirst().get(),
         translations.stream()
            .filter(a -> Objects.nonNull(a.getAspicious()))
            .collect(Collectors.toList()));
  }
}
