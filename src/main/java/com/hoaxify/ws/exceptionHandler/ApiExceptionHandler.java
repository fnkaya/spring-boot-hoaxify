package com.hoaxify.ws.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiExceptionHandler {

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler({MethodArgumentNotValidException.class})
//    public ApiErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException exception, WebRequest request){
//        ApiErrorResponse errorResponse = new ApiErrorResponse(400, "Validation error", request.getDescription(true));
//        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
//        Map<String, String> validationErrors = fieldErrors.stream()
//                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage, (existing, replacement) -> existing));
//        errorResponse.setValidationErrors(validationErrors);
//        return errorResponse;
//    }
}

