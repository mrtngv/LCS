package com.example.offices.services;

import com.example.offices.entities.Office;
import com.example.offices.repositories.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OfficeService {

    private final OfficeRepository officeRepo;
    @Autowired
    public OfficeService(OfficeRepository officeRepo) {
        this.officeRepo = officeRepo;
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
    public void updateOffice(Long id, String location, String city) {
        Office office = officeRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException("Office does not exist"));

        if (location != null && location.length()>0 & !Objects.equals(office.getLocation(), location)) {
            Optional<Office> locationFound = officeRepo.findByLocation(location);

            if (locationFound.isPresent()) {
                throw new IllegalStateException("An office with that location already exists");
            }
            office.setLocation(location);
        }

        if (city != null && city.length()>0) {
            office.setCity(city);
        }
    }
}