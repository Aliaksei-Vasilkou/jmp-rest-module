package com.epam.jmp.service;

import com.epam.jmp.model.dto.request.UserRequestDto;
import com.epam.jmp.model.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto getUser(Long id);

    List<UserResponseDto> getAllUsers();

    UserResponseDto createUser(UserRequestDto user);

    UserResponseDto updateUser(UserRequestDto user);

    void deleteUser(Long id);
}
