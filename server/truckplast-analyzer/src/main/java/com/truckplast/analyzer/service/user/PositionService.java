package com.truckplast.analyzer.service.user;

import com.truckplast.analyzer.dto.PositionDto;

import java.util.List;

public interface PositionService {

    PositionDto getById(Long id);

    List<PositionDto> getAll();

    PositionDto create(PositionDto positionDto);

    PositionDto update(PositionDto positionDto);

    void delete(Long id);
}
