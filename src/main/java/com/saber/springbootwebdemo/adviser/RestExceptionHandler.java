package com.saber.springbootwebdemo.adviser;

import com.saber.springbootwebdemo.dto.BusinessException;
import com.saber.springbootwebdemo.dto.ErrorResponseDto;
import com.saber.springbootwebdemo.dto.ValidationErrorDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseDto> handleValidation(ConstraintViolationException ex,
                                                             HttpServletRequest request) {
        log.error("Error for request url {}", request.getRequestURL());
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        errorResponseDto.setCode(status.value());
        errorResponseDto.setMessage(status.getReasonPhrase());
        List<ValidationErrorDto> validations = new ArrayList<>();
        ex.getConstraintViolations().iterator().forEachRemaining(c -> {
            ValidationErrorDto validationErrorDto = new ValidationErrorDto();
            validationErrorDto.setFieldName(c.getPropertyPath().toString());
            validationErrorDto.setErrorMessage(c.getMessage());
            validations.add(validationErrorDto);
        });
        errorResponseDto.setValidations(validations);
        log.error("Error ==> {}", errorResponseDto);
        return ResponseEntity.status(status).body(errorResponseDto);
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ErrorResponseDto> handleBusinessException(BusinessException ex,
                                                                    HttpServletRequest request) {
        log.error("Error for request url {}", request.getRequestURL());
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
        errorResponseDto.setCode(status.value());
        errorResponseDto.setMessage(status.getReasonPhrase());
        errorResponseDto.setOriginalMessage(String.format("{\"code\":\"%s\",\"message\":\"%s\"}"
                , status.value(), ex.getMessage()));
        log.error("Error ==> {}", errorResponseDto);
        return ResponseEntity.status(status).body(errorResponseDto);
    }

}
