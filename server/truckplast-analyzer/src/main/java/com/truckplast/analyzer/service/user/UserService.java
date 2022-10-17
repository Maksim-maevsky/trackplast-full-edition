package com.truckplast.analyzer.service.user;


import com.truckplast.analyzer.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto getById(Long id);

    List<UserDto> getAll();

    UserDto create(UserDto userDto);

    UserDto update(UserDto userDto);

    void delete(Long id);

}
