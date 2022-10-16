package com.truckplast.analyzer.service.user;

import com.truckplast.analyzer.dto.RoleDto;

import java.util.List;

public interface RoleService {

    RoleDto get(Long id);

    List<RoleDto> getAll();

    RoleDto create(RoleDto roleDto);

    RoleDto update(RoleDto roleDto);

    void delete(Long id);
}
