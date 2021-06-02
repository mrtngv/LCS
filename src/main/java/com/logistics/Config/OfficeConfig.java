package com.logistics.Config;

import com.logistics.Office.Office;
import com.logistics.Package.Package;
import com.logistics.Office.OfficeRepository;
import com.logistics.Package.PackageRepository;
import com.logistics.UsersAndAuth.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class OfficeConfig {
    @Bean
    CommandLineRunner commandLineRunner(OfficeRepository officeRepo, UserRepository userRepository, PackageRepository packageRepository, RoleRepository roleRepository) {
        return args -> {
            /*
                Adding initial hardcoded data just for test
             */
            Office ekont1 = new Office("blackGOLD_003", "Sofia","ul. Slavqni 1");
            Office ekont5 = new Office("blackGOLD_004", "Sofia","ul. Triadica 3");
            Office ekont6 = new Office("blackGOLD_001", "Sofia","ul. ILUMINATI 666");
            Office ekont2 = new Office("roseGOLD_002", "Plovdiv","ul. Gospel 32");
            Office ekont3 = new Office("roseGOLD_003", "Plovdiv","bul. Cheshmqna voda 120");
            Office ekont4 = new Office("roseGOLD_004", "Plovdiv","kvartal Tepe ul. mrunkalo 2");
            officeRepo.saveAll(Arrays.asList(ekont1, ekont2,ekont3,ekont4,ekont5,ekont6));

//            User user1 = new User("NIGHTWOLF", "nightwolf@gmail.com", "hello1234");
//            User user2 = new User("NIGH23TWOLF", "nig23htwol1f@gmail.com", "hello1234");
//            User user3 = new User("NIGHT32WOLF1", "nightwo32lf@gmail.com", "hello1234");
//            User user4 = new User("franklin", "franklin@gmail.com", "hello1234");
//
//            Package package1 = new Package("Kiril", "Kirilov");
//            Package package2 = new Package("Pencho2", "Penchov");
//
//            user1.getUserPackages().add(package1);
//            user1.getUserPackages().add(package2);
//            user4.getUserPackages().add(package1);
//
//            package1.getPackageUsers().add(user1);
//            package1.getPackageUsers().add(user4);
//            package2.getPackageUsers().add(user1);
//            userRepository.saveAll(Arrays.asList(user1,user2,user3,user4));
//            packageRepository.saveAll(Arrays.asList(package1,package2));


            Role client = new Role (ERoles.ROLE_CLIENT);
            Role office = new Role (ERoles.ROLE_OFFICE_EMPLOYEE);
            Role delivery = new Role (ERoles.ROLE_DELIVERY);
            Role moderator = new Role (ERoles.ROLE_MODERATOR);
            roleRepository.saveAll(Arrays.asList(client,office,delivery,moderator));

        };
    }

    @Bean
    public WebMvcConfigurer configure() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*").allowedOrigins("localhost:3000");
            }
        };
    }
}
