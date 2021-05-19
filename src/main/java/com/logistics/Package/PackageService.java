package com.logistics.Package;

import com.logistics.UsersAndAuth.*;
import com.logistics.Util.FieldsContants;
import com.logistics.Util.Functions;
import com.logistics.Util.ResponseConstants;
import com.sun.xml.bind.v2.runtime.reflect.Lister;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.zip.DataFormatException;

@Service
public class PackageService {

    //TODO
    private static final double servicePrice_sameCity = 2.40;
    private static final double servicePrice_differentCity = 3.60;

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

    public ResponseEntity<String> addPackage(AddPackageRequest addPackageRequest) {
        //TODO add the user to the Set
        try {
            UserDetailsImplementation userDetails = (UserDetailsImplementation) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            userDetails.getAuthorities().stream().forEach(s -> {
                System.out.println(s.toString());
            });
        }catch (Exception e) {
            System.out.println("=============> Not Authenticated User!");
        }

        try {
            PackageValidations.validateName(addPackageRequest.getSenderFirstName(), FieldsContants.FIRSTNAME.getField());
        } catch (DataFormatException d) {
            String error = Functions.getErrorMessage(d.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
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
        p.setPrivateCode(Functions.generatePrivateCode());
        LocalDateTime localDateTime = LocalDateTime.now();
        p.setDateOfRequest(localDateTime);
        p.setDateOfRegistration(localDateTime);
        p.setPrice(5.5);


        packageRepo.save(p);

        return ResponseEntity.ok(p.toString());
    }

    public ResponseEntity<Object> getPackageByPrivateCode(String privateCode) {
        Optional<Package> packageToReturn = packageRepo.findAll().stream().filter(p -> p.getPrivateCode().equals(privateCode)).findFirst();
        if (packageToReturn.isPresent())
            return ResponseEntity.ok().body(packageToReturn);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseConstants.PACKAGE_NOT_FOUND.getResponseMessage());
    }
}
