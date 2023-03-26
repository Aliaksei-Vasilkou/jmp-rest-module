package com.epam.jmp.model.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("User request")
public class UserRequestDto {

    @ApiModelProperty(example = "1", value = "Unique identifier")
    private Long id;

    @NotBlank
    @ApiModelProperty(example = "John", value = "User name", required = true, position = 1)
    private String name;

    @NotBlank
    @ApiModelProperty(example = "Brown", value = "User surname", required = true, position = 2)
    private String surname;

    @NotBlank
    @ApiModelProperty(example = "26-03-2000", value = "User birthday", required = true, position = 3)
    private String birthday;
}
