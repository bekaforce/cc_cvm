package com.offers.cvm_cc_tariffs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CvmCcTariffsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CvmCcTariffsApplication.class, args);
    }

}
