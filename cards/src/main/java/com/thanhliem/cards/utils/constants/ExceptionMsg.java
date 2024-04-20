package com.thanhliem.cards.utils.constants;

public enum ExceptionMsg {
    ALREADY_EXIST("Cards already registered with given mobileNumber: %s"),
    RESOURCE_NOT_FOUND("%s not found with the given input data %s : '%s'");

    private String message;

    ExceptionMsg(String message) {
        this.message = message;
    }

    public String getMessage(String... messages) {
        return String.format(this.message, messages);
    }
}
