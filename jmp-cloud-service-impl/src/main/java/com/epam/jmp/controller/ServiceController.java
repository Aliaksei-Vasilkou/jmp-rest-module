package com.epam.jmp.controller;

import com.epam.jmp.model.dto.request.SubscriptionRequestDto;
import com.epam.jmp.model.dto.response.SubscriptionResponseDto;
import com.epam.jmp.service.SubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceController implements ServiceControllerApi {

    private final SubscriptionService subscriptionService;

    public ServiceController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @Override
    public ResponseEntity<SubscriptionResponseDto> getSubscription(Long id) {

        return ResponseEntity.ok(subscriptionService.getSubscription(id));
    }

    @Override
    public ResponseEntity<List<SubscriptionResponseDto>> getAllSubscriptions() {

        return ResponseEntity.ok(subscriptionService.getAllSubscriptions());
    }

    @Override
    public ResponseEntity<SubscriptionResponseDto> createSubscription(SubscriptionRequestDto requestDto) {

        return new ResponseEntity<>(subscriptionService.createSubscription(requestDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<SubscriptionResponseDto> updateSubscription(Long id, SubscriptionRequestDto requestDto) {

        return ResponseEntity.ok(subscriptionService.updateSubscription(id, requestDto));
    }
}
