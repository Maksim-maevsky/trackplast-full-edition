package com.truckplast.analyzer.service.user;


import com.truckplast.analyzer.dto.user.FullUserDto;

import java.util.List;

public interface UserService {

    FullUserDto getById(Long id);

    List<FullUserDto> getAll();

    FullUserDto create(FullUserDto fullUserDto);

    FullUserDto update(FullUserDto fullUserDto);

    void delete(Long id);

}
