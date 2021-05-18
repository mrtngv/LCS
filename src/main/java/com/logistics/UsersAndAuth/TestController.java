package com.logistics.UsersAndAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")

public class TestController {

    private final UserDetailsServiceImplementation userDetailsServiceImplementation;

    @Autowired
    public TestController(UserDetailsServiceImplementation userDetailsServiceImplementation) {
        this.userDetailsServiceImplementation = userDetailsServiceImplementation;
    }

    @GetMapping("/all")
    public String allAccess() {
        return "new Public Content.";
    }

    @GetMapping("/getuser")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('OFFICE_EMPLOYEE') or hasRole('DELIVERY') or hasRole('CLIENT')")
    public ResponseEntity<String> getUser() {
        UserDetailsImplementation userDetails = (UserDetailsImplementation) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nema takuv imeil bratlence");
        //return ResponseEntity.ok(userDetails.getEmail());
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