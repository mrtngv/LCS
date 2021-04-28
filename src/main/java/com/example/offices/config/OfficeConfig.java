package com.example.offices.config;

import com.example.offices.entities.Office;
import com.example.offices.entities.Package;
import com.example.offices.repositories.OfficeRepository;
import com.example.offices.repositories.PackageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class OfficeConfig {
    @Bean
    CommandLineRunner commandLineRunner(OfficeRepository officeRepo, PackageRepository packageRepository) {
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
