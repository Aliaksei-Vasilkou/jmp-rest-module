package com.epam.jmp.mapper;

import com.epam.jmp.entity.Subscription;
import com.epam.jmp.model.dto.request.SubscriptionRequestDto;
import com.epam.jmp.model.dto.response.SubscriptionResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    @Mapping(target = "startDate", dateFormat = "dd-MM-yyyy")
    @Mapping(source = "user.id", target = "userId")
    SubscriptionResponseDto toDto(Subscription entity);

    Subscription toEntity(SubscriptionRequestDto requestDto);
}
