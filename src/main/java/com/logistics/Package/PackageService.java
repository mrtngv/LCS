package com.logistics.Package;

import com.logistics.UsersAndAuth.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PackageService {

    private final PackageRepository packageRepo;
    private final UserDetailsServiceImplementation userDetailsServiceImplementation;
    private final UserRepository userRepository;

    @Autowired
    public PackageService(PackageRepository packageRepo, UserDetailsServiceImplementation userDetailsServiceImplementation, UserRepository userRepository) {
        this.packageRepo = packageRepo;
        this.userDetailsServiceImplementation = userDetailsServiceImplementation;
        this.userRepository = userRepository;
    }

    public List<Package> getPackages() {
        return packageRepo.findAll();
    }

    public void addPackage(AddPackageRequest addPackageRequest) {
        UserDetailsImplementation userDetails = (UserDetailsImplementation) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userDetails.getAuthorities().stream().forEach(s -> {
            System.out.println(s.toString());
        });

        Package p = new Package(
                addPackageRequest.getSenderFirstName(),
                addPackageRequest.getSenderLastName(),
                addPackageRequest.getSenderTelephoneNumber(),
                addPackageRequest.isFirm(),
                addPackageRequest.getFirmName(),
                addPackageRequest.isFromOffice(),
                addPackageRequest.getFromAddress(),
                addPackageRequest.getReceiverFirstName(),
                addPackageRequest.getReceiverLastName(),
                addPackageRequest.getReceiverTelephoneNumber(),
                addPackageRequest.isToOffice(),
                addPackageRequest.getToAddress(),
                addPackageRequest.getePackageType(),
                addPackageRequest.getePayMethod(),
                addPackageRequest.getWeight(),
                addPackageRequest.isFragile(),
                addPackageRequest.getComment(),
                addPackageRequest.isReturnToOffice(),
                addPackageRequest.getReturnLocation(),
                addPackageRequest.getDateOfDelivery()
        );

        p.setePackageStatus(EPackageStatus.REQUESTED);
        p.setPrivateCode("XXXXXAAAAA");
        LocalDateTime localDateTime2 =
                LocalDateTime.of(2019, Month.MARCH, 28, 14, 33, 48, 123456789);
        p.setDateOfRequest(localDateTime2);
        p.setDateOfRegistration(localDateTime2);
        p.setPrice(5.5);


        packageRepo.save(p);
    }

}
