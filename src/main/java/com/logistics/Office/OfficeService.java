package com.logistics.Office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfficeService {

    private final OfficeRepository officeRepository;

    @Autowired
    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public List<Office> getOffices() {
        return officeRepository.findAll();
    }


    public void deleteById(Long id) {
        if (officeRepository.existsById(id)) {
            officeRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Office does not exist");
        }
    }


    public Office addOffice(Office office) {
        Optional<Office> foundOffice = officeRepository.findByLocation(office.getLocation());
        if (foundOffice.isPresent()) {
            throw new IllegalStateException("Office at this location already exists");
        } else {
            return
                    officeRepository.save(office);
        }
    }

    public ResponseEntity<Office> updateOffice(Office officeDetails) {
        Office office = officeRepository.findById(officeDetails.getId())
                .orElseThrow(() -> new IllegalStateException("Office with id: " + officeDetails.getId() + " does not exist."));
        office.setName(officeDetails.getName());
        office.setCity(officeDetails.getCity());
        office.setLocation(officeDetails.getLocation());
        office.setWeekdayHours(officeDetails.getWeekdayHours());
        office.setSaturdayHours(officeDetails.getSaturdayHours());
        office.setSundayHours(officeDetails.getSundayHours());
        final Office updatedOffice = officeRepository.save(office);
        return ResponseEntity.ok(updatedOffice);
    }


    public List<Office> findOfficesByLocation(String searchFor) {
        List<Office> offices = officeRepository.findAll();
        List<Office> specificOffices = offices.stream().filter(specName -> specName.getCity().contains(searchFor)).collect(Collectors.toList());
        return specificOffices;
    }

    public List<String> cities() {
        return officeRepository
                .findAll()
                .stream()
                .map(Office::getCity)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Office> getSortByCityNameOffices() {
        return officeRepository
                .findAll()
                .stream()
                .sorted(Office.compareByCityName)
                .collect(Collectors.toList());
    }
}

