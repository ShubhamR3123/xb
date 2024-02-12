package com.xb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.xb")
public class XbApplication {

	public static void main(String[] args) {
		SpringApplication.run(XbApplication.class, args);
	}

}
