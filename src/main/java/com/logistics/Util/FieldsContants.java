package com.logistics.Util;

public enum FieldsContants {
    FIRSTNAME("Име на изпращач"),
    LASTNAME("Фамилия на изпращач"),
    FIRSTNAME2("Име на получател"),
    LASTNAME2("Фамилия на получател"),
    SENDERNUMBER("Телефонен номер на изпращач"),
    RECEIVERNUMBER("Телефонен номер на получател"),
    SENDEREMAIL("Емайл на изпращач"),
    RECEIVEREMAIL("Емайл на получател")
    ;


    private String field;

    FieldsContants(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
