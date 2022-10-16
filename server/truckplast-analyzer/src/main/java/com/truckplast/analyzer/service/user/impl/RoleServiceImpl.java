package com.truckplast.analyzer.service.user.impl;

import com.truckplast.analyzer.dto.RoleDto;
import com.truckplast.analyzer.entity.part.Role;
import com.truckplast.analyzer.exeption_handler.exception.RoleNotFoundException;
import com.truckplast.analyzer.mapper.RoleMapper;
import com.truckplast.analyzer.repository.RoleRepository;
import com.truckplast.analyzer.service.user.RoleService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    private final RoleMapper mapper;

    @Override
    public RoleDto get(Long id) {

        Role role = roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException("Role not found."));

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
}
