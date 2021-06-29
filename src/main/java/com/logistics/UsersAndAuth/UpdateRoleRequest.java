package com.logistics.UsersAndAuth;

import javax.validation.constraints.NotBlank;

public class UpdateRoleRequest {

    @NotBlank
    private ERoles role;

    @NotBlank
    private String action;

    public ERoles getRole() {
        return role;
    }

    @NotBlank
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setRole(ERoles role) {
        this.role = role;
    }
}
