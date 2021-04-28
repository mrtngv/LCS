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
    CommandLineRunner commandLineRunner(OfficeRepository officeRepo) {
        return args -> {
            Office ekont1 = new Office("Boris Stefanov 2", "Sofia");
            Office ekont2 = new Office("Zahari Stoyanov", "Sofia");
            officeRepo.saveAll(Arrays.asList(ekont1, ekont2));
        };
    }

    @Bean
    CommandLineRunner commandLineRunner2(PackageRepository packageRepository) {
        return args -> {
            Package pratka1 = new Package("Marta", "Studentski grad", "Kati", "Borovo", false, 0.5);
            packageRepository.save(pratka1);
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
