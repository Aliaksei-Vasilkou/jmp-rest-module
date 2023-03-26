package com.epam.jmp.model.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("Subscription request")
public class SubscriptionRequestDto {

    @ApiModelProperty(example = "1", value = "Unique identifier")
    private Long id;

    @NotNull
    @Min(1)
    @ApiModelProperty(example = "1", value = "User id", required = true)
    private Long userId;
}
