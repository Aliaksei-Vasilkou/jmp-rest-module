package com.epam.jmp.service;

import com.epam.jmp.entity.User;
import com.epam.jmp.exception.ResourceNotFoundException;
import com.epam.jmp.mapper.UserMapper;
import com.epam.jmp.model.dto.request.UserRequestDto;
import com.epam.jmp.model.dto.response.UserResponseDto;
import com.epam.jmp.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

    private static final String USER_NOT_FOUND_BY_ID_ERROR_MESSAGE = "User not found by id=";

    private final UserRepository userRepository;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public UserResponseDto getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND_BY_ID_ERROR_MESSAGE + id));

        return mapper.toDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {

        return userRepository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public UserResponseDto createUser(UserRequestDto requestDto) {
        User entity = mapper.toEntity(requestDto);

        return mapper.toDto(userRepository.save(entity));
    }

    @Override
    @Transactional
    public UserResponseDto updateUser(Long id, UserRequestDto requestDto) {
        User user = mapper.toEntity(requestDto);
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND_BY_ID_ERROR_MESSAGE + id));
        entity.setName(user.getName());
        entity.setSurname(user.getSurname());
        entity.setBirthday(user.getBirthday());

        return mapper.toDto(entity);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND_BY_ID_ERROR_MESSAGE + id));
        userRepository.delete(user);
    }
}
