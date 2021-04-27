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
            Office ekont1 = new Office("Boris Stefanov 2", "Sofia");
            Office ekont2 = new Office("Zahari Stoyanov", "Sofia");
            officeRepo.saveAll(Arrays.asList(ekont1, ekont2));
             Package package_one = new Package("ekont_1","ekont_2",true,300,"Ekaterina Gerasimova","Jipko Bibitkov","Princesa Dayana","Prince Philip Andonov",false,250);
             Package package_two = new Package("ekont_3","ul.Minzuhar 10",false,69.69,"Marta Gyurova","office-employee007","Preslava Noname","Delivery guy 221",false,78.99);
             Package package_three = new Package("ekont_2","ekont_1",true,12.10,"Ekaterina Gerasimova","office-employee221","Martin Georgiev","Delivery guy 007",true,15.89);
//            Package p1 = new Package("ekont 1","Minzuhar 10" ,
//                    true,2.15,"Yordanka Fundukova", "Boiko Borisov",
//                    "office-employee id1","delivery guy");
//            Package p2 = new Package("ekont 21","Izvunzemna planeta 1" ,
//                    false,15.35,"Gevrek Fundukova", "Gevrek Borisov",
//                    "office-employee id14","delivery_destroyer");
//            Package p3 = new Package("ekont 15","Minzuhar 10" ,
//                    true,2.15,"Donka Gospodinova", "Boiko Gevrekov",
//                    "office-employee id2","delivery guy 21");
            packageRepository.saveAll(Arrays.asList(package_one,package_two,package_three));
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
