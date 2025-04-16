package br.com.ruderson.spring_auth_template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class SpringAuthTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAuthTemplateApplication.class, args);
	}

}
