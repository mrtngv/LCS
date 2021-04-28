package com.example.offices.services;

import com.example.offices.entities.Package;
import com.example.offices.repositories.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PackageService {
    private final PackageRepository packageRepo;
    @Autowired
    public PackageService(PackageRepository packageRepo) {
        this.packageRepo = packageRepo;
    }

    public List<Package> getPackages() {
        return packageRepo.findAll();
    }

    public void addPackage(Package item) {
        packageRepo.save(item);
    }

    public void deletePackage(Long id) {
        if (packageRepo.existsById(id)) {
            packageRepo.deleteById(id);
        } else {
            throw new IllegalStateException("Package does not exist");
        }
    }

    //единственото, което може да се променя е нейния статус
    @Transactional
    public void updatePackage(Long id, String state) {
        Package item = packageRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException("No such package")) ;

        if (state != null && state.length()>0) {
            item.setState(state);
            packageRepo.save(item);
        }
    }
}
