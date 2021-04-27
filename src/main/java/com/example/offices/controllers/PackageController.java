package com.example.offices.controllers;

import com.example.offices.entities.Package;
import com.example.offices.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api")
public class PackageController {
    private final OfficeService officeService;
    @Autowired
    public PackageController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping("/packages")
    public List<Package> getPackages() {
        return officeService.getPackages();
    }
    @GetMapping("/packages/clientsReceiving")
    public List<String> getReceivingClients(){
        return officeService.getReceivingClients();
    }
    @GetMapping("/packages/clientsSending")
    public List<String> getClientsSending(){
        return officeService.getClientsSending();
    }
    @GetMapping("/packages/allSendingAndReceivingClients")
    public List<String> allSendingAndReceivingClients(){ return officeService.getAllSendingAndReceivingClients(); }
    @GetMapping("/packages/compareByClientSendingName")
    public List<Package> compareByClientSendingName() { return officeService.getCompareByClientSendingName(); }
    @GetMapping("/packages/officeEmployees")
    public List<String> getOfficeEmployees(){ return officeService.getOfficeEmployees(); }
    @GetMapping("/packages/deliveryEmployees")
    public List<String> getDeliveryEmployees(){ return officeService.getDeliveryEmployees(); }
    @GetMapping("/packages/allWorkingEmployees")
    public List<String> getAllWorkingEmployees() { return officeService.getAllWorkingEmployees(); }
}


