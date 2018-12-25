package ga.rugal.almanac.springmvc.mapper.almanac;

import ga.rugal.almanac.springmvc.mapper.CentralConfig;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * The Data Mapper For Student.
 *
 * @author Rugal Bernstein
 */
@Mapper(config = CentralConfig.class)
public interface AlmanacMapper {

  AlmanacMapper INSTANCE = Mappers.getMapper(AlmanacMapper.class);
}
