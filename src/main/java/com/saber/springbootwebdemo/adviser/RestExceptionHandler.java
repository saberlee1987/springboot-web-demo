package com.saber.springbootwebdemo.adviser;

import com.saber.springbootwebdemo.dto.ErrorDto;
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
    public ResponseEntity<ErrorDto> handleValidation(ConstraintViolationException ex,
                                                     HttpServletRequest request) {
        log.error("Error for request url {}",request.getRequestURL());
        ErrorDto errorDto = new ErrorDto();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        errorDto.setCode(status.value());
        errorDto.setMessage(status.getReasonPhrase());
        List<ValidationErrorDto> validations = new ArrayList<>();
        ex.getConstraintViolations().iterator().forEachRemaining(c -> {
            ValidationErrorDto validationErrorDto = new ValidationErrorDto();
            validationErrorDto.setFieldName(c.getPropertyPath().toString());
            validationErrorDto.setErrorMessage(c.getMessage());
            validations.add(validationErrorDto);
        });
        errorDto.setValidations(validations);
        log.error("Error ==> {}", errorDto);
        return ResponseEntity.status(status).body(errorDto);
    }

}
