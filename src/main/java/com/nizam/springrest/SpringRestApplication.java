package com.nizam.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
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