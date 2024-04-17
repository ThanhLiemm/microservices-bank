package com.thanhliem.accounts.utils.exception;

import com.thanhliem.accounts.utils.constants.ExceptionMsg;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerAlreadyExistsException extends RuntimeException {
    public CustomerAlreadyExistsException(String mobileNumber) {
        super(ExceptionMsg.ALREADY_EXIST.getMessage(mobileNumber));
    }
}
