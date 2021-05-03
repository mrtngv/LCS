package com.example.offices.controllers;

import com.example.offices.entities.Office;
import com.example.offices.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{officeID}")
    public Optional<Office> getOfficeById(@PathVariable("officeID") Long id) {
        return officeService.getOfficeById(id);
    }

    @PostMapping
    public void addOffice(@RequestBody Office office) {
        officeService.addOffice(office);
    }

    @DeleteMapping("/{officeID}")
    public void deleteOffice(@PathVariable("officeID") Long id) {
        officeService.deleteOffice(id);
    }

    @PutMapping("/{officeID}")
    public void updateOffice(@PathVariable("officeID") Long id, @RequestBody String location) {
        officeService.updateOffice(id, location);
    }
}
