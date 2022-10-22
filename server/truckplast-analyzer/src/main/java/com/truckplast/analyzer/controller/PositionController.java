package com.truckplast.analyzer.controller;


import com.truckplast.analyzer.dto.PositionDto;
import com.truckplast.analyzer.service.user.PositionService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/positions")
@Data
@RequiredArgsConstructor
public class PositionController {

    private final PositionService positionService;

    @GetMapping
    public List<PositionDto> getAll(){

        return positionService.getAll();
    }

    @GetMapping("/{id}")
    public PositionDto getById(@PathVariable Long id){

        return positionService.getById(id);
    }

    @PostMapping
    public PositionDto create(@RequestBody PositionDto positionDto){

        return positionService.create(positionDto);
    }

    @PutMapping
    public PositionDto update(@RequestBody PositionDto positionDto){

        return positionService.update(positionDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        positionService.delete(id);
    }
}
