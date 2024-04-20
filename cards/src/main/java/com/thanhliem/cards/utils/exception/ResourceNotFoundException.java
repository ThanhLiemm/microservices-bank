package com.thanhliem.cards.utils.exception;

import com.thanhliem.cards.utils.constants.ExceptionMsg;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(ExceptionMsg.RESOURCE_NOT_FOUND.getMessage(resourceName, fieldName, fieldValue));
    }
}
