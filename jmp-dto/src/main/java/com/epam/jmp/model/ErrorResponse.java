package com.epam.jmp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel("Error response")
public class ErrorResponse {

    @ApiModelProperty(example = "RESOURCE_NOT_FOUND", value = "Error code")
    private String code;

    @ApiModelProperty(example = "Error description", value = "Error description")
    private String message;

    @ApiModelProperty(example = "AppName", value = "Error source")
    private String source;
}
