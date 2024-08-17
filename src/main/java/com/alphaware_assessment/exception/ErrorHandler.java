package com.alphaware_assessment.exception;

import com.alphaware_assessment.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ContinentAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse exceptionHandler(ContinentAlreadyExistsException exception) {
        return new ErrorResponse(exception.getMessage());
    }
}
