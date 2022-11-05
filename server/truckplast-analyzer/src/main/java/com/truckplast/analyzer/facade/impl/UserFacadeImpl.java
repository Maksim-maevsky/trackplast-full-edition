package com.truckplast.analyzer.facade.impl;

import com.truckplast.analyzer.dto.user.FullUserDto;
import com.truckplast.analyzer.facade.UserFacade;
import com.truckplast.analyzer.service.user.CompanyService;
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

    private final CompanyService companyService;


    @Override
    public List<FullUserDto> getAll() {

        return userService.getAll();
    }

    @Override
    public FullUserDto getById(Long id) {

        return userService.getById(id);
    }

    @Override
    public FullUserDto create(FullUserDto fullUserDto) {

        roleService.isRolesExist(fullUserDto.getRoles());

        positionService.isPositionExist(fullUserDto.getPosition());

        companyService.isCompanyExist(fullUserDto.getCompany());

        return userService.create(fullUserDto);
    }

    @Override
    public FullUserDto update(FullUserDto fullUserDto) {

        return userService.update(fullUserDto);
    }

    @Override
    public void delete(Long id) {

        userService.delete(id);
    }

}
