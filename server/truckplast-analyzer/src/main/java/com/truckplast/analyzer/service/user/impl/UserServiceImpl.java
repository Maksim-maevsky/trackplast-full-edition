package com.truckplast.analyzer.service.user.impl;

import com.truckplast.analyzer.dto.UserDto;
import com.truckplast.analyzer.entity.part.User;
import com.truckplast.analyzer.exeption_handler.exception.UserNotFoundException;
import com.truckplast.analyzer.mapper.UserMapper;
import com.truckplast.analyzer.repository.UserRepository;
import com.truckplast.analyzer.service.user.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper mapper;

    @Override
    public UserDto get(Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found."));

        return mapper.toUserDto(user);
    }

    @Override
    public List<UserDto> getAll() {

        List<User> list = userRepository.findAll();

        return mapper.mapToUserDtoList(list);
    }

    @Override
    public UserDto create(UserDto userDto) {

        User user = mapper.toUser(userDto);

        User savedUser = userRepository.save(user);

        return mapper.toUserDto(savedUser);
    }

    @Override
    public UserDto update(UserDto userDto) {

        User user = mapper.toUser(userDto);

        User savedUser = userRepository.save(user);

        return mapper.toUserDto(savedUser);
    }

    @Override
    public void delete(Long id) {

        userRepository.deleteById(id);
    }
}
