package com.saber.springbootwebdemo.dto;

import lombok.Data;
import java.util.List;

@Data
public class ErrorResponseDto {
    private Integer code;
    private String message;
    private Object originalMessage;
    private List<ValidationErrorDto> validations;
}