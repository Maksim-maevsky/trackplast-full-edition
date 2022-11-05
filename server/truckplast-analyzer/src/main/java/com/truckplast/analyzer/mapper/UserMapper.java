package com.truckplast.analyzer.mapper;

import com.truckplast.analyzer.dto.user.FullUserDto;
import com.truckplast.analyzer.entity.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Named(value = "userDto")
    User toUser(FullUserDto fullUserDto);

    @Named(value = "userEntity")
    FullUserDto toUserDto(User user);

    @IterableMapping(qualifiedByName = "userDto")
    List<User> mapToUserList(List<FullUserDto> fullUserDtoList);

    @IterableMapping(qualifiedByName = "userEntity")
    List<FullUserDto> mapToUserDtoList(List<User> userList);
}
