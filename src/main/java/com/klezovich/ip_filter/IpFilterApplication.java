package com.klezovich.ip_filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableCaching
public class IpFilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpFilterApplication.class, args);
	}
}
