package com.example.offices.config;

import com.example.offices.entities.Office;
import com.example.offices.entities.Package;
import com.example.offices.repositories.OfficeRepository;
import com.example.offices.repositories.PackageRepository;
import com.example.offices.users.ERoles;
import com.example.offices.users.Role;
import com.example.offices.users.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class OfficeConfig {
    @Bean
    CommandLineRunner commandLineRunner(OfficeRepository officeRepo, PackageRepository packageRepository, RoleRepository roleRepository) {
        return args -> {
            /*
                Adding initial hardcoded data just for test
             */
            Office ekont1 = new Office("Boris Stefanov 2", "Sofia");
            Office ekont2 = new Office("Zahari Stoyanov", "Sofia");
            officeRepo.saveAll(Arrays.asList(ekont1, ekont2));

            Package pratka1 = new Package("Marta", "Studentski grad", "Kati", "Borovo", false, 0.5);
            Package pratka2 = new Package("Hrisi", "ul. Stuklen Svurzan Spisak", "Kati", "Borovo", true, 400);
            Package pratka3 = new Package("Preslava", "Mladost", "Marta", "Studentski", false, 8.8);
            packageRepository.saveAll(Arrays.asList(pratka1, pratka2,pratka3));

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
