package com.truckplast.analyzer.controller;

import com.truckplast.analyzer.dto.UserDto;
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

    @GetMapping
    public List<UserDto> getAll(){

        return userService.getAll();
    }

    @GetMapping("/get/{id}")
    public UserDto get(@PathVariable Long id){

        return userService.get(id);
    }

    @PostMapping("/create")
    public UserDto create(@RequestBody UserDto userDto){

        return userService.create(userDto);
    }

    @PutMapping("/update")
    public UserDto update(@RequestBody UserDto userDto){
        
        return userService.update(userDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){

        userService.delete(id);
    }
}
