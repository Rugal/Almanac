package ga.rugal.almanac.springmvc.mapper.almanac;

import ga.rugal.almanac.core.entity.localized.LocalizedAlmanac;
import ga.rugal.almanac.springmvc.mapper.CentralConfig;
import ga.rugal.almanac.springmvc.mapper.hexagram.HexagramMapper;
import ga.rugal.almanac.swagger.request.AlmanacDto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author Rugal Bernstein
 */
@Mapper(config = CentralConfig.class, uses = HexagramMapper.class)
public interface AlmanacMapper {

  AlmanacMapper INSTANCE = Mappers.getMapper(AlmanacMapper.class);

  AlmanacDto from(LocalizedAlmanac localizedAlmanac);
}
