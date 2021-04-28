package com.example.offices.controllers;

import com.example.offices.entities.Package;
import com.example.offices.services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/packagesInfo")
public class PackageController {
    private final PackageService packageService;
    @Autowired
    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @GetMapping("/packages")
    public List<Package> getPackages() {
        return packageService.getPackages();
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
