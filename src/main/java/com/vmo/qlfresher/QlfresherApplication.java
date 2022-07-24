package com.vmo.qlfresher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;



@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class QlfresherApplication {

	public static void main(String[] args) {
		SpringApplication.run(QlfresherApplication.class, args);
	}

}
