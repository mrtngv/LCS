package com.logistics.Office;

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

    public Optional<Office> getOfficeById(Long id) {
       return officeRepo
               .findAll()
               .stream()
               .filter(s -> s.getId() == id)
               .findFirst();
    }
}
