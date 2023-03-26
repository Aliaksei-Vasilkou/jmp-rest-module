package com.epam.jmp.service;

import com.epam.jmp.entity.Subscription;
import com.epam.jmp.entity.User;
import com.epam.jmp.exception.ResourceNotFoundException;
import com.epam.jmp.mapper.SubscriptionMapper;
import com.epam.jmp.model.dto.request.SubscriptionRequestDto;
import com.epam.jmp.model.dto.response.SubscriptionResponseDto;
import com.epam.jmp.repository.SubscriptionRepository;
import com.epam.jmp.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;
    private final SubscriptionMapper mapper;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository,
                                   UserRepository userRepository,
                                   SubscriptionMapper mapper) {
        this.subscriptionRepository = subscriptionRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public SubscriptionResponseDto getSubscription(Long id) {

        return mapper.toDto(subscriptionRepository.getById(id));
    }

    @Override
    public List<SubscriptionResponseDto> getAllSubscriptions() {

        return subscriptionRepository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public SubscriptionResponseDto createSubscription(SubscriptionRequestDto requestDto) {
        Long userId = requestDto.getUserId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found by id=" + userId));

        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setStartDate(LocalDate.now());

        return mapper.toDto(subscriptionRepository.save(subscription));
    }

    @Override
    @Transactional
    public SubscriptionResponseDto updateSubscription(SubscriptionRequestDto requestDto) {
        Long userId = requestDto.getUserId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found by id=" + userId));

        Long subscriptionId = requestDto.getId();
        Subscription subscription = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new ResourceNotFoundException("Subscription not found by id=" + subscriptionId));
        subscription.setUser(user);
        subscription.setStartDate(LocalDate.now());

        return mapper.toDto(subscription);
    }
}
