package com.logistics.Package;

import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"https://logistic-company-cscb025.herokuapp.com", "http://localhost:3000"})
@RestController
@RequestMapping("/api/packages")
public class PackageController {

    private final PackageService packageService;

    @Autowired
    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @PostMapping
    public ResponseEntity<String> addPackage(@RequestBody AddPackageRequest addPackageRequest) throws MessagingException {
        return packageService.addPackage(addPackageRequest);
    }

    @PostMapping("/specific")
    public ResponseEntity<Object> getPackageByPrivateCode(@RequestBody PrivateCodeRequest privateCodeRequest) {
        return packageService.getPackageByPrivateCode(privateCodeRequest.getCode());
    }

    @PreAuthorize("hasRole('MODERATOR') or hasRole('OFFICE_EMPLOYEE') or hasRole('DELIVERY')")
    @GetMapping("/{packageID}")
    public ResponseEntity<Object> getPackageById(@PathVariable("packageID") Long id) {
        return packageService.getPackageById(id);
    }

    @PreAuthorize("hasRole('MODERATOR')")
    @PostMapping("/revenue")
    public double getRevenue(@RequestBody RevenueRequest revenueRequest){
        return packageService.getRevenue(revenueRequest);
    }

    @GetMapping
    public List<Package> getPackages() {
        return packageService.getPackages();
    }
//
//    @GetMapping("/{packageID}")
//    public Optional<Package> getPackagesById(@PathVariable("packageID") Long id) {
//        return packageService.getPackagesById(id);
//    }
//
//    @PostMapping
//    public void addPackage(@RequestBody Package item) {
//        packageService.addPackage(item);
//    }
//
//    @DeleteMapping("/{packageID}")
//    public void deletePackage(@PathVariable("packageID") Long id) {
//        packageService.deletePackage(id);
//    }
//
//    @PutMapping("/{packageID}")
//    public void updatePackage(@PathVariable("packageID") Long id, @RequestBody String state) {
//        packageService.updatePackage(id, state);
//    }
}
