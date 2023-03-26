package com.epam.jmp.model.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Subscription response")
public class SubscriptionResponseDto {

    @ApiModelProperty(example = "1", value = "Unique identifier")
    private Long id;

    @ApiModelProperty(example = "1", value = "User id", position = 1)
    private Long userId;

    @ApiModelProperty(example = "01-12-2002", value = "Subscription start date", position = 2)
    private String startDate;
}
