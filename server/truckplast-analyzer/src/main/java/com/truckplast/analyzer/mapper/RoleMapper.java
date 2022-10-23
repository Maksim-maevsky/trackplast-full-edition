package com.truckplast.analyzer.mapper;

import com.truckplast.analyzer.dto.RoleDto;
import com.truckplast.analyzer.entity.Role;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Named(value = "roleDto")
    Role toRole(RoleDto roleDto);

    @Named(value = "roleEntity")
    RoleDto toRoleDto(Role role);

    @IterableMapping(qualifiedByName = "roleDto")
    List<Role> mapToRoleList(List<RoleDto> roleDtoList);

    @IterableMapping(qualifiedByName = "roleEntity")
    List<RoleDto> mapToRoleDtoList(List<Role> roleList);
}
