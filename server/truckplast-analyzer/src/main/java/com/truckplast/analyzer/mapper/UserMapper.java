package com.truckplast.analyzer.mapper;

import com.truckplast.analyzer.dto.UserDto;
import com.truckplast.analyzer.entity.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Named(value = "userDto")
    User toUser(UserDto userDto);

    @Named(value = "userEntity")
    UserDto toUserDto(User user);

    @IterableMapping(qualifiedByName = "userDto")
    List<User> mapToUserList(List<UserDto> userDtoList);

    @IterableMapping(qualifiedByName = "userEntity")
    List<UserDto> mapToUserDtoList(List<User> userList);
}
