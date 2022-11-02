package com.truckplast.analyzer.facade;

import com.truckplast.analyzer.dto.user.FullUserDto;

import java.util.List;

public interface UserFacade {

    List<FullUserDto> getAll();

    FullUserDto getById(Long id);

    FullUserDto create(FullUserDto fullUserDto);

    FullUserDto update(FullUserDto fullUserDto);

    void delete(Long id);
}
