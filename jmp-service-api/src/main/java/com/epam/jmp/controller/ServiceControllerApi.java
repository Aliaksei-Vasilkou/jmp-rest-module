package com.epam.jmp.controller;

import com.epam.jmp.model.ErrorResponse;
import com.epam.jmp.model.dto.request.SubscriptionRequestDto;
import com.epam.jmp.model.dto.response.SubscriptionResponseDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("v1/subscriptions")
public interface ServiceControllerApi {

    @ApiOperation(value = "Retrieve subscription by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = SubscriptionResponseDto.class),
            @ApiResponse(code = 404, message = "Not Found Error", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class)
    })
    @GetMapping("/{id}")
    ResponseEntity<SubscriptionResponseDto> getSubscription(@PathVariable Long id);

    @ApiOperation(value = "Retrieve all subscriptions")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = SubscriptionResponseDto.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Not Found Error", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class)
    })
    @GetMapping
    ResponseEntity<List<SubscriptionResponseDto>> getAllSubscriptions();

    @ApiOperation(value = "Create subscription")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = SubscriptionResponseDto.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class)
    })
    @PostMapping
    ResponseEntity<SubscriptionResponseDto> createSubscription(@RequestBody @Valid SubscriptionRequestDto subscription);

    @ApiOperation(value = "Update subscription")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = SubscriptionResponseDto.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class)
    })
    @PutMapping
    ResponseEntity<SubscriptionResponseDto> updateSubscription(@RequestBody @Valid SubscriptionRequestDto subscription);
}
