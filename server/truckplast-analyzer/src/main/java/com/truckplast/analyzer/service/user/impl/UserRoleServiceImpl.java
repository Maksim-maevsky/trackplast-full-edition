package com.truckplast.analyzer.service.user.impl;

import com.truckplast.analyzer.dto.UserRoleDto;
import com.truckplast.analyzer.entity.user.UserRole;
import com.truckplast.analyzer.exeption_handler.exception.UserRoleNotFoundException;
import com.truckplast.analyzer.mapper.UserRoleMapper;
import com.truckplast.analyzer.repository.UserRoleRepository;
import com.truckplast.analyzer.service.user.UserRoleService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    private final UserRoleMapper mapper;


    @Override
    public UserRoleDto getById(Long id) {

        UserRole userRole = userRoleRepository.findById(id).orElseThrow(() -> new UserRoleNotFoundException("User role not founded."));

        return mapper.toUserRoleDto(userRole);
    }

    @Override
    public List<UserRoleDto> getAll() {

        return mapper.mapToUserRoleDtoList(userRoleRepository.findAll());
    }

    @Override
    public UserRoleDto create(UserRoleDto userRoleDto) {

        UserRole userRole = mapper.toUserRole(userRoleDto);

        UserRole savedUserRole = userRoleRepository.save(userRole);

        return mapper.toUserRoleDto(savedUserRole);
    }

    @Override
    public UserRoleDto update(UserRoleDto userRoleDto) {

        UserRole userRole = mapper.toUserRole(userRoleDto);

        UserRole savedUserRole = userRoleRepository.save(userRole);

        return mapper.toUserRoleDto(savedUserRole);
    }

    @Override
    public void delete(Long id) {

        userRoleRepository.deleteById(id);
    }
}
