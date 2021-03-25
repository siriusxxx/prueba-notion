package com.prueba.restapiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * The Class RestApiServiceApplication.
 */
@SpringBootApplication
@EnableFeignClients
public class RestApiServiceApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(RestApiServiceApplication.class, args);
	}

}
