package com.truckplast.analyzer.service.user;

import com.truckplast.analyzer.dto.UserRoleDto;

import java.util.List;

public interface UserRoleService {

    UserRoleDto get(Long id);

    List<UserRoleDto> getAll();

    UserRoleDto create(UserRoleDto userRoleDto);

    UserRoleDto update(UserRoleDto userRoleDto);

    void delete(Long id);
}
