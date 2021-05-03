package com.example.offices.controllers;

import com.example.offices.entities.Package;
import com.example.offices.services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<Package> getPackages() {
        return packageService.getPackages();
    }

    @GetMapping("/{packageID}")
    public Optional<Package> getPackagesById(@PathVariable("packageID") Long id) {
        return packageService.getPackagesById(id);
    }

    @PostMapping
    public void addPackage(@RequestBody Package item) {
        packageService.addPackage(item);
    }

    @DeleteMapping("/{packageID}")
    public void deletePackage(@PathVariable("packageID") Long id) {
        packageService.deletePackage(id);
    }

    @PutMapping("/{packageID}")
    public void updatePackage(@PathVariable("packageID") Long id, @RequestBody String state) {
        packageService.updatePackage(id, state);
    }
}
