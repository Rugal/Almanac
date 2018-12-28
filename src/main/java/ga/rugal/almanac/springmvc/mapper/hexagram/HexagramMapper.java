package ga.rugal.almanac.springmvc.mapper.hexagram;

import java.util.List;

import ga.rugal.almanac.core.entity.localized.LocalizedHexagram;
import ga.rugal.almanac.springmvc.mapper.CentralConfig;
import ga.rugal.almanac.swagger.request.LocalizedHexagramDto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author Rugal Bernstein
 */
@Mapper(config = CentralConfig.class)
public interface HexagramMapper {

  HexagramMapper INSTANCE = Mappers.getMapper(HexagramMapper.class);

  LocalizedHexagramDto from(LocalizedHexagram localizedHexagram);

  List<LocalizedHexagramDto> froms(List<LocalizedHexagram> localizedHexagrams);
}
