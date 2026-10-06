package com.brisa.projetoseries;

import com.brisa.projetoseries.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoseriesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoseriesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();

	}
}
