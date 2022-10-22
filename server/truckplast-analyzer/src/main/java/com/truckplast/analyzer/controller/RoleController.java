package com.truckplast.analyzer.controller;

import com.truckplast.analyzer.dto.RoleDto;
import com.truckplast.analyzer.service.user.RoleService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@Data
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public List<RoleDto> getAll(){

        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public RoleDto getById(@PathVariable Long id){

        return roleService.getById(id);
    }

    @PostMapping
    public RoleDto create(@RequestBody RoleDto roleDto){

        return roleService.create(roleDto);
    }

    @PutMapping
    public RoleDto update(@RequestBody RoleDto roleDto){

        return roleService.update(roleDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        roleService.delete(id);
    }




}
