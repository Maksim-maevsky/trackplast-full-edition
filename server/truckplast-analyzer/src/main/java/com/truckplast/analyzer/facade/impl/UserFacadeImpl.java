package com.truckplast.analyzer.facade.impl;

import com.truckplast.analyzer.dto.UserDto;
import com.truckplast.analyzer.exeption_handler.exception.NoSuchPositionException;
import com.truckplast.analyzer.exeption_handler.exception.NoSuchRoleException;
import com.truckplast.analyzer.facade.UserFacade;
import com.truckplast.analyzer.service.user.PositionService;
import com.truckplast.analyzer.service.user.RoleService;
import com.truckplast.analyzer.service.user.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Data
@Slf4j
@RequiredArgsConstructor
@Service
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;

    private final RoleService roleService;

    private final PositionService positionService;


    @Override
    public List<UserDto> getAll() {

        return userService.getAll();
    }

    @Override
    public UserDto getById(Long id) {

        return userService.getById(id);
    }

    @Override
    public UserDto create(UserDto userDto) {

        if (!roleService.isRolesExist(userDto.getRoles())){

            throw new NoSuchRoleException("You entered wrong role(s).");
        }

        if (!positionService.isPositionExist(userDto.getPosition())){

            throw new NoSuchPositionException("You entered wrong position.");
        }

        return userService.create(userDto);
    }

    @Override
    public UserDto update(UserDto userDto) {

        return userService.update(userDto);
    }

    @Override
    public void delete(Long id) {

        userService.delete(id);
    }

}
