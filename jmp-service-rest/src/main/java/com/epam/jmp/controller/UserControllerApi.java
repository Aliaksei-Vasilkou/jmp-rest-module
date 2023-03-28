package com.epam.jmp.controller;

import com.epam.jmp.model.ErrorResponse;
import com.epam.jmp.model.dto.request.UserRequestDto;
import com.epam.jmp.model.dto.response.UserResponseDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("v1/users")
public interface UserControllerApi {

    @ApiOperation(value = "Retrieve user by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = UserResponseDto.class),
            @ApiResponse(code = 404, message = "Not Found Error", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class)
    })
    @GetMapping("/{id}")
    ResponseEntity<UserResponseDto> getUser(@PathVariable Long id);

    @ApiOperation(value = "Retrieve all users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = UserResponseDto.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Not Found Error", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class)
    })
    @GetMapping
    ResponseEntity<List<UserResponseDto>> getAllUsers();

    @ApiOperation(value = "Create user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = UserResponseDto.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class)
    })
    @PostMapping
    ResponseEntity<UserResponseDto> createUser(@RequestBody @Valid UserRequestDto user);

    @ApiOperation(value = "Update user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = UserResponseDto.class),
            @ApiResponse(code = 404, message = "Not Found Error", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class)
    })
    @PutMapping("/{id}")
    ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id, @RequestBody @Valid UserRequestDto user);

    @ApiOperation(value = "Delete user by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found Error", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class)
    })
    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id);
}
