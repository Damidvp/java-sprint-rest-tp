package fr.diginamic.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class JavaSpringRestTp1Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringRestTp1Application.class, args);
	}

}
