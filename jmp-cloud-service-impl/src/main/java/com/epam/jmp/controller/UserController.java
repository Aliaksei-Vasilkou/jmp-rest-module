package com.epam.jmp.controller;

import com.epam.jmp.model.dto.request.UserRequestDto;
import com.epam.jmp.model.dto.response.UserResponseDto;
import com.epam.jmp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserControllerApi {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long id) {

        return ResponseEntity.ok(userService.getUser(id));
    }

    @Override
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {

        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Override
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto) {

        return new ResponseEntity<>(userService.createUser(requestDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserResponseDto> updateUser(Long id, UserRequestDto requestDto) {

        return ResponseEntity.ok(userService.updateUser(id, requestDto));
    }

    @Override
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }
}
