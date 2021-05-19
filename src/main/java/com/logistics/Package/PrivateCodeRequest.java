package com.logistics.Package;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PrivateCodeRequest {
    @NotBlank
    @Size(min = 10, max = 10)
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
