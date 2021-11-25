package grsu.lection.service.mapper;

import grsu.lection.model.Beetle;
import grsu.lection.service.dto.GetBeetleDto;
import grsu.lection.service.dto.UpdateBeetleDto;
import org.mapstruct.Mapper;

@Mapper
public interface BeetleMapper {
    GetBeetleDto entityToDto(Beetle beetle);
    Beetle dtoToEntity(UpdateBeetleDto dto);
}
