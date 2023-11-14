package fr.diginamic.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableScheduling
public class JavaSpringRestTp1Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringRestTp1Application.class, args);
	}

}
