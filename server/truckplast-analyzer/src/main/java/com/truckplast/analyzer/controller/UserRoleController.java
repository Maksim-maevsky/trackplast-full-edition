package com.truckplast.analyzer.controller;

import com.truckplast.analyzer.dto.UserRoleDto;
import com.truckplast.analyzer.service.user.UserRoleService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-role")
@Data
@RequiredArgsConstructor
public class UserRoleController {

    private final UserRoleService userRoleService;

    @GetMapping
    public List<UserRoleDto> getAll(){

        return userRoleService.getAll();
    }

    @GetMapping("/get/{id}")
    public UserRoleDto get(@PathVariable Long id){

        return userRoleService.get(id);
    }

    @PostMapping("/create")
    public UserRoleDto create(@RequestBody UserRoleDto userRoleDto){

        return userRoleService.create(userRoleDto);
    }

    @PutMapping("/update")
    public UserRoleDto update(@RequestBody UserRoleDto userRoleDto){

        return userRoleService.update(userRoleDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){

        userRoleService.delete(id);
    }
}
