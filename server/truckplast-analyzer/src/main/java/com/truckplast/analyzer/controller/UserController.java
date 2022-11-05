package com.truckplast.analyzer.controller;

import com.truckplast.analyzer.dto.user.FullUserDto;
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
    public List<FullUserDto> getAll(){

        return userService.getAll();
    }

    @GetMapping("/{id}")
    public FullUserDto getById(@PathVariable Long id){

        return userService.getById(id);
    }

    @PostMapping
    public FullUserDto create(@RequestBody FullUserDto fullUserDto){

        return userFacade.create(fullUserDto);
    }

    @PutMapping
    public FullUserDto update(@RequestBody FullUserDto fullUserDto){
        
        return userService.update(fullUserDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        userService.delete(id);
    }
}
