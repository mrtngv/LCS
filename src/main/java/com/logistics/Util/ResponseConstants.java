package com.logistics.Util;

public enum ResponseConstants {
    PACKAGE_NOT_FOUND("Упс, пратка с такъв номер не съществува.");

    private String responseMessage;

    ResponseConstants(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
