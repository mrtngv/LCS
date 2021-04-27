package com.example.offices.controllers;

import com.example.offices.entities.Office;
import com.example.offices.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
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
/*
    @GetMapping("/offices/count")
    public int getOfficesCount() {
        return officeService.getOfficesCount();
    }

    @GetMapping("/offices/sort")
    public List<Office> getSortByCityNameOffices() {
        return officeService.getSortByCityNameOffices();
    }

    @GetMapping("/offices/sortDescending")
    public List<Office> getSortByCityNameDescendingOffices() {
        return officeService.getSortByCityNameDescendingOffices();
    }
    @GetMapping("/offices/showCitiesWithOffices")
    public List<String> showInWhichCitiesWeHaveOffices() {
        return officeService.showInWhichCitiesWeHaveOffices();
    }
    @GetMapping("/offices/showStreets")
        public List<String> showStreets(){
            return officeService.showStreets();
        }
*/
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
