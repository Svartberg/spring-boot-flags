package com.svartberg.springbootflagsloader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBootFlagsloaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFlagsloaderApplication.class, args);
	}

}
