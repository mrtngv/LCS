package com.logistics.Util;

public enum ValidationConstants {
    NULL("не може да бъде празно!"),
    INVALID_CHARACTERS("не може да съдържа невалидни символи!"),
    EMPTY("не може да бъде празно!"),
    TOО_LONG("е прекалено дълго!"),
    TOO_SHORT("е прекалено късо!"),
    INVALID_EMAIL("е невалиден емайл!")
    ;


    private String errorMessage;

    ValidationConstants(String errorMessage) {
            this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
