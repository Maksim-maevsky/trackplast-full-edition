package com.truckplast.analyzer.mapper;

import com.truckplast.analyzer.dto.PositionDto;
import com.truckplast.analyzer.entity.part.Position;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PositionMapper {

    @Named(value = "positionDto")
    Position toPosition(PositionDto positionDto);

    @Named(value = "positionEntity")
    PositionDto toPositionDto(Position position);

    @IterableMapping(qualifiedByName = "positionDto")
    List<Position> mapToPositionList(List<PositionDto> positionsDto);

    @IterableMapping(qualifiedByName = "positionEntity")
    List<PositionDto> mapToPositionDtoList(List<Position> positions);
}
