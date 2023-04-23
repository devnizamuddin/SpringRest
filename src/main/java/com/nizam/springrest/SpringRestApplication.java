package com.nizam.springrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringRestApplication implements CommandLineRunner {

    @Autowired
    PasswordEncoder encoder;

    public static void main(String[] args) {
        SpringApplication.run(SpringRestApplication.class, args);

    }

    private void passwordEncode() {
        System.out.println("My custom password is : " + encoder.encode("xyz"));
    }

    @Override
    public void run(String... args) throws Exception {
        passwordEncode();
    }
}


/*
* @ComponentScan({"com.nizam.springrest.services"})
@EntityScan("com.nizam.springrest.entity")
@EnableJpaRepositories("com.nizam.springrest.dao")
*
* @ComponentScan({"com.delivery.request"})
@EntityScan("com.delivery.domain")
@EnableJpaRepositories("com.delivery.repository")
* */