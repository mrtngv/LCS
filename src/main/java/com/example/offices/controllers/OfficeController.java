package com.example.offices.controllers;

import com.example.offices.entities.Office;
import com.example.offices.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class OfficeController {
    private final OfficeService officeService;
    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping("/offices")
    public List<Office> getOffices() {
        return officeService.getOffices();
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
    public void updateOffice(@PathVariable("officeID") Long id, @RequestParam(required = false) String location,@RequestParam(required = false) String city) {
        officeService.updateOffice(id, location, city);
    }
}
