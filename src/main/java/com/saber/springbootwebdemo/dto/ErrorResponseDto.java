package com.saber.springbootwebdemo.dto;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Data;
import java.util.List;

@Data
public class ErrorResponseDto {
    private Integer code;
    private String message;
    @JsonRawValue
    private Object originalMessage;
    private List<ValidationErrorDto> validations;
}