package com.logistics.Config;

import com.logistics.Office.Office;
import com.logistics.Package.Package;
import com.logistics.Office.OfficeRepository;
import com.logistics.Package.PackageRepository;
import com.logistics.UsersAndAuth.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class OfficeConfig {

    @Autowired
    PasswordEncoder encoder;

    @Bean
    CommandLineRunner commandLineRunner(OfficeRepository officeRepo, UserRepository userRepository, PackageRepository packageRepository, RoleRepository roleRepository) {
        return args -> {

            /*
                Adding initial hardcoded data just for test
             */
            Office o1= new Office("Офис o1", "София","Граф Николай Игнатиев 19", "10:00 - 17:00", "09:00 - 13:00", null);
            Office o2 = new Office("Офис o2", "София","Московска 2", "09:00 - 9:00", "09:00 - 13:00", null);
            Office o3 = new Office("Офис o3", "София","Цар Симеон 11", "10:00 - 17:00", "09:00 - 13:00", null);
            Office o4 = new Office("Офис o4", "София","Екзарх Йосиф 237", "10:00 - 17:00", "09:00 - 13:00", null);
            Office o5 = new Office("Офис o5", "Пловдив","Александър Пушкин, зад Хотел Катерина", "10:00 - 17:00", "09:00 - 13:00", null);
            Office o6 = new Office("Офис o6", "Варна","булевард Иван Вазов, номер 76", "10:00 - 17:00", "09:00 - 13:00", null);
            Office o7 = new Office("Офис o7", "Бургас","Мол Галерия, етаж 3, до магазин Adidas", "10:00 - 17:00", "09:00 - 13:00", null);
            Office o8 = new Office("Офис o8", "Велико Търново","улица Опълченци", "10:00 - 17:00", "09:00 - 13:00", null);
            Office o9 = new Office("Офис o9", "Ямбол","булевард Васил Левски 1", "10:00 - 17:00", "09:00 - 13:00", null);
            Office o10 = new Office("Офис o10", "Силистра","улица Христо Ботев, 114А", "10:00 - 17:00", "09:00 - 13:00", null);
            officeRepo.saveAll(Arrays.asList(o1,o2,o3,o4,o5,o6,o7,o8,o9,o10));

            Role client = new Role (ERoles.ROLE_CLIENT);
            Role office = new Role (ERoles.ROLE_OFFICE_EMPLOYEE);
            Role delivery = new Role (ERoles.ROLE_DELIVERY);
            Role moderator = new Role (ERoles.ROLE_MODERATOR);
//          roleRepository.saveAll(Arrays.asList(client,office,delivery,moderator));


            Set<Role> roles = new HashSet<>();
            Set<Role> roles1 = new HashSet<>();
            Set<Role> roles2 = new HashSet<>();
            Set<Role> roles3 = new HashSet<>();
            roles.add(client);
            roles1.add(office);
            roles2.add(delivery);
            roles3.add(moderator);
            User user = new User("client1","client1@abv.bg", encoder.encode("12345678"));
            user.setRoles(roles);
            User user1 = new User("client2","client2@abv.bg", encoder.encode("12345678"));
            user1.setRoles(roles);
            User user2 = new User("client3","client3@abv.bg", encoder.encode("12345678"));
            user2.setRoles(roles);
            User user3  = new User("client4","client4@abv.bg", encoder.encode("12345678"));
            user3.setRoles(roles);

            User office1  = new User("office1","office1@abv.bg", encoder.encode("12345678"));
            office1.setRoles(roles1);
            User office2  = new User("office2","office2@abv.bg", encoder.encode("12345678"));
            office2.setRoles(roles1);
            User delivery1  = new User("delivery1","delivert14@abv.bg", encoder.encode("12345678"));
            delivery1.setRoles(roles2);
            User delivery2  = new User("delivery2","delivery2@abv.bg", encoder.encode("12345678"));
            delivery2.setRoles(roles2);

            User moderator1  = new User("moderator1","moderator1@abv.bg", encoder.encode("12345678"));
            moderator1.setRoles(roles3);
            userRepository.saveAll(Arrays.asList(user,user1,user2,user3, office1, office2, delivery1, delivery2, moderator1));


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
