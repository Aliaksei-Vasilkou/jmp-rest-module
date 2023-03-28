package com.epam.jmp.service;

import com.epam.jmp.model.dto.request.SubscriptionRequestDto;
import com.epam.jmp.model.dto.response.SubscriptionResponseDto;

import java.util.List;

public interface SubscriptionService {

    SubscriptionResponseDto getSubscription(Long id);

    List<SubscriptionResponseDto> getAllSubscriptions();

    SubscriptionResponseDto createSubscription(SubscriptionRequestDto requestDto);

    SubscriptionResponseDto updateSubscription(Long id, SubscriptionRequestDto requestDto);
}
