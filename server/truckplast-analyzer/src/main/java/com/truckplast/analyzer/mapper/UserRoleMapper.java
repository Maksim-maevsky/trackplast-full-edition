package com.truckplast.analyzer.mapper;


import com.truckplast.analyzer.dto.UserRoleDto;
import com.truckplast.analyzer.entity.user.UserRole;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {

    @Named(value = "userRoleDto")
    UserRole toUserRole(UserRoleDto userRoleDto);

    @Named(value = "userRoleEntity")
    UserRoleDto toUserRoleDto(UserRole userRole);

    @IterableMapping(qualifiedByName = "userRoleDto")
    List<UserRole> mapToUserRoleList(List<UserRoleDto> userRoleDtoList);

    @IterableMapping(qualifiedByName = "userRoleEntity")
    List<UserRoleDto> mapToUserRoleDtoList(List<UserRole> userRoleList);
}
