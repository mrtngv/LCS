package com.logistics.Office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public void addOffice(@RequestBody Office office) {
        officeService.addOffice(office);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Office> updateOffice(@PathVariable(value = "id") Long officeId,
                                               @RequestBody Office officeDetails) {
        return officeService.updateOffice(officeId, officeDetails);
    }

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
