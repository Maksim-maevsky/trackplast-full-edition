package com.truckplast.analyzer.facade;

import com.truckplast.analyzer.dto.UserDto;

import java.util.List;

public interface UserFacade {

    List<UserDto> getAll();

    UserDto getById(Long id);

    UserDto create(UserDto userDto);

    UserDto update(UserDto userDto);

    void delete(Long id);
}
