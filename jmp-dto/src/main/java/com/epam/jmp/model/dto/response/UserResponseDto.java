package com.epam.jmp.model.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("User response")
public class UserResponseDto {

    @ApiModelProperty(example = "1", value = "Unique identifier")
    private Long id;

    @ApiModelProperty(example = "John", value = "User name", position = 1)
    private String name;

    @ApiModelProperty(example = "Brown", value = "User surname", position = 2)
    private String surname;

    @ApiModelProperty(example = "01-03-2003", value = "User birthday date", position = 3)
    private String birthday;
}
