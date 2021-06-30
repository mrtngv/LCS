package com.logistics.Package;

import com.logistics.UsersAndAuth.*;
import com.logistics.Util.FieldsContants;
import com.logistics.Util.Functions;
import com.logistics.Util.MailFunctions;
import com.logistics.Util.ResponseConstants;
import com.sun.xml.bind.v2.runtime.reflect.Lister;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import javax.mail.MessagingException;
import java.lang.reflect.Executable;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

@Service
public class PackageService {

    //TODO
    private static final double servicePrice_sameCity = 2.40;
    private static final double servicePrice_differentCity = 3.60;

    private final PackageRepository packageRepo;
    private final UserDetailsServiceImplementation userDetailsServiceImplementation;
    private final UserRepository userRepository;
    private JavaMailSender javaMailSender;
    private MailFunctions mailFunctions;

    @Autowired
    public PackageService(PackageRepository packageRepo,
                          UserDetailsServiceImplementation userDetailsServiceImplementation,
                          UserRepository userRepository,
                          JavaMailSender javaMailSender,
                          MailFunctions mailFunctions) {
        this.packageRepo = packageRepo;
        this.userDetailsServiceImplementation = userDetailsServiceImplementation;
        this.userRepository = userRepository;
        this.javaMailSender = javaMailSender;
        this.mailFunctions = mailFunctions;
    }

    public List<Package> getPackages() {
        String role = this.getUltimateAuthorization();
        if(role.equals("NO_ROLE")){
            return new ArrayList<Package>();
        }
            try {
                UserDetailsImplementation userDetails = (UserDetailsImplementation) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

                if (role.equals(ERoles.ROLE_CLIENT.toString())){

                    final User user = userRepository
                            .findAll()
                            .stream()
                            .filter(u -> u.getId() == userDetails.getId()).findFirst().orElseThrow(() -> new IllegalStateException("Not such user"));
                    if(user != null) {
                        return packageRepo
                                .findAll()
                                .stream()
                                .filter(p -> p.getPackageUsers().contains(user))
                                .collect(Collectors.toList());
                    }
                } else {
                    return packageRepo.findAll();
                }
            } catch (Exception e) {
                System.out.println("Not Authenticated User!");
            }

        return new ArrayList<Package>();
    }

    private User calculateDriver() {
        List<User> deliveryGuys = userRepository.findAll().stream().filter(u -> u.getStringRoles().contains(ERoles.ROLE_DELIVERY.toString())).collect(Collectors.toList());
        System.out.println("Delivery Guys");
        System.out.println(deliveryGuys);
        if (deliveryGuys.size() == 0) {
            throw new IllegalStateException("There are no drivers in the company");
        }
        User selectedDeliveryGuy = deliveryGuys.get(0);
        int c = Integer.MAX_VALUE;
        for (User delivery : deliveryGuys) {
            if (delivery.getUserPackages().size() < c) {
                selectedDeliveryGuy = delivery;
                c = delivery.getUserPackages().size();
            }
        }

        return selectedDeliveryGuy;
    }

    private void addAllPossibleUsersToPackage(Package p, String privateCode) throws MessagingException {
        List<User> currentUsers = p.getPackageUsers();
        String role = this.getUltimateAuthorization();
        String senderEmailBegin = p.getSenderEmail();
        int flag = 0;

        if (role.equals(ERoles.ROLE_OFFICE_EMPLOYEE.toString())) {
            try {
                UserDetailsImplementation userDetails = (UserDetailsImplementation) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                User office = userRepository.findAll().stream().filter(u -> u.getEmail().equals(userDetails.getEmail())).findFirst().orElse(office = null);
                if (office != null) {
                    currentUsers.add(office);
                    flag = 1;
                }
            } catch (Exception e) {
                System.out.println("=============> Not Authenticated User!");
            }
        }

        try {
            User driver = this.calculateDriver();
            currentUsers.add(driver);
        }catch (IllegalStateException e) {
        }

        // за таблицата с user_id - package_id
        User userSender = userRepository.findAll().stream().filter(user -> user.getEmail().equals(p.getSenderEmail())).findFirst().orElse(userSender = null);
        if (userSender != null && p.getSenderEmail().equals(userSender.getEmail())) {
            currentUsers.add(userSender);
        }
        User userReceiver = userRepository.findAll().stream().filter(user -> user.getEmail().equals(p.getReceiverEmail())).findFirst().orElse(userReceiver = null);
        if (userReceiver != null && p.getReceiverEmail().equals(userReceiver.getEmail())) {
            currentUsers.add(userReceiver);
        }
        p.setPackageUsers(currentUsers);
        LocalDateTime localDateTime = LocalDateTime.now();
        p.setDateOfRequest(localDateTime);

        if(flag == 0) {
            p.setePackageStatus(EPackageStatus.REQUESTED);
        } else {
            p.setePackageStatus(EPackageStatus.REGISTERED);
            p.setDateOfRegistration(localDateTime);
            try {
                mailFunctions.sendEmail(privateCode, p.getSenderEmail(), p.getReceiverEmail());
                mailFunctions.sendEmailReceiver(p.getReceiverEmail(), p.getSenderFirstName(), privateCode, p.getFromCity(), p.getFromAddress(), p.isFromOffice(), p.getDateOfDelivery().plusDays(2).toString());
            }catch (Exception e){

            }
        }

    }
//
//    public Double calculatePrice () {
//
//    }

    public String getUltimateAuthorization() {
        try {
            UserDetailsImplementation userDetails = (UserDetailsImplementation) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            List<? extends GrantedAuthority> collect = userDetails.getAuthorities().stream().collect(Collectors.toList());
            List <String> newCollect = collect.stream().map(v -> v.toString()).collect(Collectors.toList());
            if (newCollect.contains(ERoles.ROLE_MODERATOR.toString()))
                return ERoles.ROLE_MODERATOR.toString();
            if (newCollect.contains(ERoles.ROLE_OFFICE_EMPLOYEE.toString()))
                return ERoles.ROLE_OFFICE_EMPLOYEE.toString();
            if (newCollect.contains(ERoles.ROLE_DELIVERY.toString()))
                return ERoles.ROLE_DELIVERY.toString();
            if (newCollect.contains(ERoles.ROLE_CLIENT.toString()))
                return ERoles.ROLE_CLIENT.toString();
        } catch (Exception e) {

        }
        return "NO_ROLE";
    }

    public ResponseEntity<String> addPackage(AddPackageRequest addPackageRequest) throws MessagingException {
        // TODO {if the user is office User then -> assign himself as a reporter, calculate the driver and check if the telephone number of the sender}
        // TODO {If the user is CLIENT, only the user is the set, until Office_user accepts the package and assign himself as a reporter and then calculate the free driver}
        // TODO calculate the free driver which is going  to be assigned

        // TODO extend validations as the example below -
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
                addPackageRequest.getSenderEmail(),
                addPackageRequest.getIsFirm(),
                addPackageRequest.getFirmName(),
                addPackageRequest.getFromOffice(),
                addPackageRequest.getFromAddress(),
                addPackageRequest.getReceiverFirstName(),
                addPackageRequest.getReceiverLastName(),
                addPackageRequest.getReceiverTelephoneNumber(),
                addPackageRequest.getReceiverEmail(),
                addPackageRequest.getToOffice(),
                addPackageRequest.getToAddress(),
                addPackageRequest.getePackageType(),
                addPackageRequest.getePayMethod(),
                addPackageRequest.getWeight(),
                addPackageRequest.getIsFragile(),
                addPackageRequest.getComment(),
                addPackageRequest.getReturnToOffice(),
                addPackageRequest.getReturnLocation(),
                addPackageRequest.getDateOfDelivery(),
                addPackageRequest.getDateOfSending(),
                addPackageRequest.getToFirm(),
                addPackageRequest.getToFirmName(),
                addPackageRequest.getFromCity(),
                addPackageRequest.getToCity(),
                addPackageRequest.getAlternativeCity()
        );

        p.setCashOnDelivery(addPackageRequest.getCashOnDelivery());
        p.setIban(addPackageRequest.getIBAN());
        p.setIsCashOnDelivery(addPackageRequest.getIsCashOnDelivery());
        p.setBic(addPackageRequest.getBIC());
        p.setBank(addPackageRequest.getBank());
        p.setBankAccountOwner(addPackageRequest.getBankAccountOwner());
        p.setIsReturnCashToOffice(addPackageRequest.getReturnCashToOffice());
        p.setReturnCashAddress(addPackageRequest.getReturnCashAddress());
        p.setReturnCashCity(addPackageRequest.getReturnCashCity());

        String privateCode = Functions.generatePrivateCode();
        p.setPrivateCode(privateCode);
        double price = (addPackageRequest.getWeight()*0.30) + 1.50;
        if(!addPackageRequest.getFromOffice())
            price+=2;
        if(!addPackageRequest.getToOffice())
            price+=2;
        p.setPrice(price);
        this.addAllPossibleUsersToPackage(p, privateCode);
        packageRepo.saveAndFlush(p);
        return ResponseEntity.ok(p.toString());
    }

    public ResponseEntity<Object> getPackageByPrivateCode(String privateCode) {
        Optional<Package> packageToReturn = packageRepo.findAll().stream().filter(p -> p.getPrivateCode().equals(privateCode)).findFirst();
        if (packageToReturn.isPresent())
            return ResponseEntity.ok().body(packageToReturn);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseConstants.PACKAGE_NOT_FOUND.getResponseMessage());
    }


    public double getRevenue(RevenueRequest revenueRequest) {
        List<Package> all = this.packageRepo.findAll();
        double revenue = 0.0;
        if(revenueRequest.getFromDate() !=null && revenueRequest.getToDate() !=null){
            for(Package p: all) {
                if(p.getDateOfRegistration() !=null && p.getDateOfRegistration().toLocalDate().isAfter(revenueRequest.getFromDate()) && p.getDateOfRegistration().toLocalDate().isBefore(revenueRequest.getToDate()))
                revenue+=p.getPrice();
            }
            return revenue;
        }
        if(revenueRequest.getFromDate() != null){
            for(Package p: all) {
                if(p.getDateOfRegistration() !=null && p.getDateOfRegistration().toLocalDate().isAfter(revenueRequest.getFromDate()))
                    revenue+=p.getPrice();
            }
            return revenue;

        }
        if(revenueRequest.getToDate() !=null){
            for(Package p: all) {
                if( p.getDateOfRegistration() !=null && p.getDateOfRegistration().toLocalDate().isBefore(revenueRequest.getToDate()))
                    revenue+=p.getPrice();
            }
            return revenue;
        }

        for(Package p: all) {
            if(p.getDateOfRegistration() !=null)
            revenue+=p.getPrice();
        }
        return revenue;
    }

    public ResponseEntity<Object> getPackageById(Long id) {
        Package package1 = packageRepo.findById(id).orElse(package1 = null);
        if(package1 == null) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseConstants.PACKAGE_NOT_FOUND.getResponseMessage());
        }
        return ResponseEntity.ok().body(package1);
    }

    public ResponseEntity<?> editPackage(EditPackageRequest packageDetails) {
        Package packagee = packageRepo.findById(packageDetails.getId())
                .orElse(packagee=null);
        if (packagee==null) {
            return ResponseEntity.ok(new MessageResponse("Didn't find a package with this id: " + packageDetails.getId()));
        }
        packagee.setSenderTelephoneNumber(packageDetails.getSenderTelephoneNumber());
        packagee.setReceiverTelephoneNumber(packageDetails.getReceiverTelephoneNumber());
        packagee.setToCity(packageDetails.getToCity());
        packagee.setToAddress(packageDetails.getToAddress());
        packagee.setAlternativeCity(packageDetails.getAlternativeCity());
        packagee.setReturnLocation(packageDetails.getReturnLocation());
        packagee.setDateOfDelivery(packageDetails.getDateOfDelivery());
        packagee.setToOffice(packageDetails.getToOffice());
        packagee.setReturnToOffice(packageDetails.getReturnToOffice());
        packageRepo.save(packagee);
        return ResponseEntity.ok(packagee);
    }

    public ResponseEntity<?> editStatus(EditEPackageStatus editEPackageStatus) {
        Package ptbc = packageRepo.findById(editEPackageStatus.getId()).orElse(ptbc = null);
        if (ptbc == null) {
            return ResponseEntity.ok(new MessageResponse("Didn't find a package with this id: " + editEPackageStatus.getId()));
        }
        ptbc.setePackageStatus(editEPackageStatus.getePackageStatus());
        if(ptbc.getePackageStatus() == EPackageStatus.DECLINED){
            try {
                mailFunctions.sendRejectedEmail(ptbc.getSenderEmail(),ptbc.getSenderFirstName(),ptbc.getPrivateCode(), ptbc.isFromOffice(),  ptbc.getReturnLocation(), ptbc.getAlternativeCity());
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
        if (ptbc.getePackageStatus() == EPackageStatus.COLLECTED || ptbc.getePackageStatus() == EPackageStatus.DELIVERED){
            try {
                mailFunctions.sendDeliveredEmail(ptbc.getSenderEmail(),ptbc.getSenderFirstName(),ptbc.getPrivateCode());
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }

    packageRepo.save(ptbc);
    return ResponseEntity.ok(ptbc);
    }

    public ResponseEntity<?> getAllRelatedStatuses(Long id) {
        Package p = packageRepo.findById(id).orElse(p = null);
        if(p==null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseConstants.PACKAGE_NOT_FOUND.getResponseMessage());
        }

        List<EPackageStatus> statuses;
        switch(p.getePackageStatus()) {
            case REQUESTED: statuses = Arrays.asList(EPackageStatus.REGISTERED,EPackageStatus.ANNULLED);break;
            case REGISTERED:
                if(p.isFromOffice()){
                    statuses = Arrays.asList(EPackageStatus.ANNULLED,EPackageStatus.IN_PROCESS_OF_DELIVERING, EPackageStatus.COLLECTED);
                }else{
                    statuses = Arrays.asList(EPackageStatus.ANNULLED,EPackageStatus.IN_PROCESS_OF_DELIVERING);
                }
                ;break;
            case COLLECTED: statuses = Arrays.asList(EPackageStatus.ANNULLED,EPackageStatus.IN_PROCESS_OF_DELIVERING);break;
            case IN_PROCESS_OF_DELIVERING: statuses = Arrays.asList(EPackageStatus.ANNULLED,EPackageStatus.DECLINED,  EPackageStatus.DELIVERED, EPackageStatus.AWAITING_PICK_UP);break;
            case AWAITING_PICK_UP: statuses = Arrays.asList(EPackageStatus.ANNULLED, EPackageStatus.DECLINED, EPackageStatus.DELIVERED);break;
            case RETURNED: statuses = Arrays.asList(EPackageStatus.ANNULLED);break;
            case DELIVERED: statuses = Arrays.asList(EPackageStatus.REGISTERED);break;
            case DECLINED: statuses = Arrays.asList(EPackageStatus.ANNULLED, EPackageStatus.RETURNED);break;
            case ANNULLED: statuses = Arrays.asList(EPackageStatus.REGISTERED);break;
            default:
                statuses = Arrays.asList(EPackageStatus.REGISTERED);break;
        }
        return ResponseEntity.ok(statuses);
    }
}
