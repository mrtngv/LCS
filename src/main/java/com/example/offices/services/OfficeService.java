package com.example.offices.services;

import com.example.offices.entities.Office;
import com.example.offices.entities.Package;
import com.example.offices.repositories.OfficeRepository;
import com.example.offices.repositories.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OfficeService {
    private final OfficeRepository officeRepo;
    private final PackageRepository packageRepository;

    @Autowired
    public OfficeService(OfficeRepository officeRepo, PackageRepository packageRepository) {
        this.officeRepo = officeRepo;
        this.packageRepository = packageRepository;
    }


    public List<Office> getOffices() {
        return officeRepo.findAll();
    }

    public void addOffice(Office office) {
        Optional<Office> foundOffice = officeRepo.findByLocation(office.getLocation());
        if (foundOffice.isPresent()) {
            throw new IllegalStateException("Office already exists");
        }
        officeRepo.save(office);
    }

    public void deleteOffice(Long id) {
        if (officeRepo.existsById(id)) {
            officeRepo.deleteById(id);
        } else {
            throw new IllegalStateException("Office does not exist");
        }
    }

    @Transactional
    public void updateOffice(Long id, String location) {
        Office office = officeRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException("Office does not exist"));

        if (location != null && location.length()>0 && !Objects.equals(office.getLocation(), location)) {
            office.setLocation(location);
            officeRepo.save(office);
        }
        else {
            throw new IllegalStateException("Requested values are wrong! Location:" + location);
        }
    }



/*
    public int getOfficesCount() {
        return (int) this.officeRepo.findAll().stream().count();
    }

    public List<Office> getSortByCityNameOffices() {
        return officeRepo
                .findAll()
                .stream()
                .sorted(Office.compareByCityName)
                .collect(Collectors.toList());
    }

    public List<Office> getSortByCityNameDescendingOffices() {
        return officeRepo
                .findAll()
                .stream()
                .sorted(Office.compareByCityNameDescending)
                .collect(Collectors.toList());
    }

    public List<String> showInWhichCitiesWeHaveOffices() {
        return officeRepo
                .findAll()
                .stream()
                .map(Office::getCity)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> showStreets() {
        return officeRepo
                .findAll()
                .stream()
                .map(Office::getLocation)
                .collect(Collectors.toList());
    }*/
    public List<Package> getPackages() {
        return packageRepository.findAll();
    }

    public List<String> getReceivingClients() {
        return packageRepository
                .findAll()
                .stream()
                .map(Package::getClientReceiving)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Package> getCompareByClientSendingName() {
        return packageRepository
                .findAll()
                .stream()
                .sorted(Package.compareByClientSendingName)
                .collect(Collectors.toList());
    }

    public List<String> getClientsSending() {
        return packageRepository
                .findAll()
                .stream()
                .map(Package::getClientSending)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> getOfficeEmployees() {
        return packageRepository
                .findAll()
                .stream()
                .map(Package::getOfficeEmployee)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> getDeliveryEmployees() {
        return packageRepository
                .findAll()
                .stream()
                .map(Package::getDeliveryEmployee)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> getAllSendingAndReceivingClients()  {
        List<String> clientsReceiving =
                packageRepository
                .findAll()
                .stream()
                .map(m -> m.getClientReceiving())
                .collect(Collectors.toList());
        List<String> clientsSending =
                packageRepository
                        .findAll()
                        .stream()
                        .map(m -> m.getClientSending())
                        .collect(Collectors.toList());
        clientsReceiving.addAll(clientsSending);
        return clientsReceiving.stream().distinct().collect(Collectors.toList());
    }


    public List<String> getAllWorkingEmployees() {
        List<String> officeEmployees =
                packageRepository
                        .findAll()
                        .stream()
                        .map(m -> m.getOfficeEmployee())
                        .collect(Collectors.toList());
        List<String> deliveryEmployees =
                packageRepository
                        .findAll()
                        .stream()
                        .map(m -> m.getDeliveryEmployee())
                        .collect(Collectors.toList());
        officeEmployees.addAll(deliveryEmployees);
        return officeEmployees.stream().distinct().collect(Collectors.toList());
    }
}

