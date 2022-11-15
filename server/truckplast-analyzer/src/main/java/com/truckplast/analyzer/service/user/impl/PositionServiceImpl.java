package com.truckplast.analyzer.service.user.impl;


import com.truckplast.analyzer.dto.PositionDto;
import com.truckplast.analyzer.entity.user.Position;
import com.truckplast.analyzer.exeption_handler.exception.NoSuchPositionException;
import com.truckplast.analyzer.exeption_handler.exception.PositionNotFoundException;
import com.truckplast.analyzer.mapper.PositionMapper;
import com.truckplast.analyzer.repository.PositionRepository;
import com.truckplast.analyzer.service.user.PositionService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    private final PositionMapper mapper;


    @Override
    public PositionDto getById(Long id) {

        Position position = positionRepository.findById(id).orElseThrow(() -> new PositionNotFoundException("Position no founded."));

        return mapper.toPositionDto(position);
    }

    @Override
    public List<PositionDto> getAll() {

        return mapper.mapToPositionDtoList(positionRepository.findAll());
    }

    @Override
    public PositionDto create(PositionDto positionDto) {

        Position position = mapper.toPosition(positionDto);

        Position savedPosition = positionRepository.save(position);

        return mapper.toPositionDto(savedPosition);
    }

    @Override
    public PositionDto update(PositionDto positionDto) {

        Position position = mapper.toPosition(positionDto);

        Position savedPosition = positionRepository.save(position);

        return mapper.toPositionDto(savedPosition);
    }

    @Override
    public void delete(Long id) {

        positionRepository.deleteById(id);
    }

    public boolean isPositionExist(PositionDto positionDto){

        if (positionRepository.findByName(positionDto.getName()).isPresent()) {

            return true;
        }

        throw new NoSuchPositionException("You entered wrong position.");
    }
}
