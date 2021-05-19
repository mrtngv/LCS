package com.logistics.Util;

public enum FieldsContants {
    FIRSTNAME("Име на изпращач");

    private String field;

    FieldsContants(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
