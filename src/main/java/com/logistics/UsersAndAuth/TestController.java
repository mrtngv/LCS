package com.logistics.UsersAndAuth;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")

public class TestController {

    @GetMapping("/all")
    public String allAccess() {
        return "new Public Content.";
    }

    @GetMapping("/signed")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('OFFICE_EMPLOYEE') or hasRole('DELIVERY') or hasRole('CLIENT')")
    public String signedAccess() {
        return "All signed users Content.";
    }

    @GetMapping("/employees")
    @PreAuthorize("hasRole('OFFICE_EMPLOYEE') or hasRole('DELIVERY')")
    public String allEmployeesAccess() {
        return "All employees Content.";
    }

    @GetMapping("/office")
    @PreAuthorize("hasRole('OFFICE_EMPLOYEE')")
    public String officeEmployeeAccess() {
        return "All office employees Content.";
    }

    @GetMapping("/delivery")
    @PreAuthorize("hasRole('DELIVERY')")
    public String deliveryAccess() {
        return "All delivery employees Content.";
    }

    @GetMapping("/moderator")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator content.";
    }
}