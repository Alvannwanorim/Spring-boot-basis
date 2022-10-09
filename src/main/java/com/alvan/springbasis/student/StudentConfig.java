package com.alvan.springbasis.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student alvan = new Student("alvan@gmail.com", LocalDate.of(2000, Month.JANUARY, 22), "Alvan");

            Student alex = new Student("alex@gmail.com", LocalDate.of(2004, Month.JANUARY, 22), "Alex");

            repository.saveAll(
                List.of(alvan, alex)
            );

        };
    }
}
