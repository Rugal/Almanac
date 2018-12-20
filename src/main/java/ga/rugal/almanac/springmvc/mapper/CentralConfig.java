package ga.rugal.almanac.springmvc.mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

/**
 * Central configuration for data mapper.
 *
 * @author Rugal Bernstein
 */
@MapperConfig(
  unmappedTargetPolicy = ReportingPolicy.IGNORE,
  nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface CentralConfig {
}
