package com.logistics.Office;

import com.logistics.UsersAndAuth.UserDetailsImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"https://logistic-company-cscb025.herokuapp.com", "http://localhost:3000"})
@RestController
@RequestMapping("/api/offices")
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping
    public List<Office> getOffices() {
        return officeService.getOffices();
    }

    @GetMapping("/test/test")
    public List<Object> bram() {
        UserDetailsImplementation userDetails = (UserDetailsImplementation) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
    }

    @PreAuthorize("hasRole('MODERATOR')")
    @PostMapping
    public void addOffice(@RequestBody Office office) {
        officeService.addOffice(office);
    }

    @PreAuthorize("hasRole('MODERATOR')")
    @PutMapping
    public ResponseEntity<Office> updateOffice(@RequestBody Office officeDetails) {
        return officeService.updateOffice(officeDetails);
    }

    @PreAuthorize("hasRole('MODERATOR')")
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        officeService.deleteById(id);
    }

    @GetMapping("/{city}")
    public List<Office> findOfficesByLocation(@PathVariable(value = "city") String searchFor){
        return officeService.findOfficesByLocation(searchFor);
    }

    @GetMapping("/cities")
    public List<String> cities(){
        return officeService.cities();
    }

    @GetMapping("/sort")
    public List<Office> getSortByCityNameOffices() {
        return officeService.getSortByCityNameOffices();
    }

}
