package com.truckplast.analyzer.service.user.impl;

import com.truckplast.analyzer.dto.RoleDto;
import com.truckplast.analyzer.entity.Role;
import com.truckplast.analyzer.exeption_handler.exception.RoleNotFoundException;
import com.truckplast.analyzer.mapper.RoleMapper;
import com.truckplast.analyzer.repository.RoleRepository;
import com.truckplast.analyzer.service.user.RoleService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Data
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    private final RoleMapper mapper;

    @Override
    public RoleDto getById(Long id) {

        Role role = roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException("Role not founded."));

        return mapper.toRoleDto(role);
    }

    @Override
    public List<RoleDto> getAll() {

        return mapper.mapToRoleDtoList(roleRepository.findAll());
    }

    @Override
    public RoleDto create(RoleDto roleDto) {

        Role role = mapper.toRole(roleDto);

        Role savedRole = roleRepository.save(role);

        return mapper.toRoleDto(savedRole);
    }

    @Override
    public RoleDto update(RoleDto roleDto) {

        Role role = mapper.toRole(roleDto);

        Role savedRole = roleRepository.save(role);

        return mapper.toRoleDto(savedRole);
    }

    @Override
    public void delete(Long id) {

        roleRepository.deleteById(id);
    }

    public boolean isRolesExist(Set<RoleDto> roleDtoSet){

        for (RoleDto role : roleDtoSet) {

            if (roleRepository.findByName(role.getName()).isEmpty()){

                return false;
            }
        }

        return true;
    }

}
