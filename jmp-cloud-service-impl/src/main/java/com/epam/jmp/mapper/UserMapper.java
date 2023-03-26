package com.epam.jmp.mapper;

import com.epam.jmp.entity.User;
import com.epam.jmp.model.dto.request.UserRequestDto;
import com.epam.jmp.model.dto.response.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "birthday", dateFormat = "dd-MM-yyyy")
    UserResponseDto toDto(User entity);

    @Mapping(target = "birthday", dateFormat = "dd-MM-yyyy")
    User toEntity(UserRequestDto dto);
}
