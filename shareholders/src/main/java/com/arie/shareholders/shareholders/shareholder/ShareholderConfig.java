package com.arie.shareholders.shareholders.shareholder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class ShareholderConfig {

    @Bean
    CommandLineRunner commandLineRunner (ShareholderRepository shareholderRepository) {
        return args -> {
            Shareholder skuditskylv = new Shareholder(
                    "Lev Skuditsky",
                    LocalDate.of(1985, 12,2),
                    "skuditskylv@gmail.com");

            Shareholder secondOne = new Shareholder(
                    "John Doe",
                    LocalDate.of(1945, 11,1),
                    "noname@gmail.com");

            shareholderRepository.saveAll(
                    List.of(skuditskylv, secondOne));
        };
    }
}
