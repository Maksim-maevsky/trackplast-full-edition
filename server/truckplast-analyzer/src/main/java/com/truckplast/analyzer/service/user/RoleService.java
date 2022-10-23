package com.truckplast.analyzer.service.user;

import com.truckplast.analyzer.dto.RoleDto;

import java.util.List;
import java.util.Set;

public interface RoleService {

    RoleDto getById(Long id);

    List<RoleDto> getAll();

    RoleDto create(RoleDto roleDto);

    RoleDto update(RoleDto roleDto);

    void delete(Long id);

    boolean isRolesExist(Set<RoleDto> roleDtoSet);
}
