package com.truckplast.analyzer.controller;

import com.truckplast.analyzer.dto.UserDto;
import com.truckplast.analyzer.facade.UserFacade;
import com.truckplast.analyzer.service.user.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Data
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final UserFacade userFacade;

    @GetMapping
    public List<UserDto> getAll(){

        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDto get(@PathVariable Long id){

        return userService.getById(id);
    }

    @PostMapping
    public UserDto create(@RequestBody UserDto userDto){

        return userFacade.create(userDto);
    }

    @PutMapping
    public UserDto update(@RequestBody UserDto userDto){
        
        return userService.update(userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        userService.delete(id);
    }
}
