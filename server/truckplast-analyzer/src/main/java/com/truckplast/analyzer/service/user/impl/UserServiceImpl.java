package com.truckplast.analyzer.service.user.impl;

import com.truckplast.analyzer.dto.user.FullUserDto;
import com.truckplast.analyzer.entity.user.User;
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
    public FullUserDto getById(Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not founded."));

        return mapper.toUserDto(user);
    }

    @Override
    public List<FullUserDto> getAll() {

        List<User> users = userRepository.findAll();

        return mapper.mapToUserDtoList(users);
    }

    @Override
    public FullUserDto create(FullUserDto fullUserDto) {

        User user = mapper.toUser(fullUserDto);

        User savedUser = userRepository.save(user);

        return mapper.toUserDto(savedUser);
    }

    @Override
    public FullUserDto update(FullUserDto fullUserDto) {

        User user = mapper.toUser(fullUserDto);

        User savedUser = userRepository.save(user);

        return mapper.toUserDto(savedUser);
    }

    @Override
    public void delete(Long id) {

        userRepository.deleteById(id);
    }
}
