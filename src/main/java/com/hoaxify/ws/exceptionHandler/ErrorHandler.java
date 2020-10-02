package com.hoaxify.ws.exceptionHandler;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ErrorHandler implements ErrorController {

    private final ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    ApiErrorResponse handleError(WebRequest request) {
        Map<String, Object> attributes = this.errorAttributes.getErrorAttributes(request, true);
        String message = (String) attributes.get("message");
        String path = (String) attributes.get("path");
        Integer status = (Integer) attributes.get("status");
        ApiErrorResponse errorResponse = new ApiErrorResponse(status, message, path);
        if (attributes.containsKey("errors")){
            List<FieldError> fieldErrors = (List<FieldError>) attributes.get("errors");
            Map<String, String> validationErrors = fieldErrors.stream()
                    .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage, (existing, replacement) -> existing));
            errorResponse.setValidationErrors(validationErrors);
        }
        return errorResponse;
    }

    @Override
    public String getErrorPath() {
        return "error";
    }
}
