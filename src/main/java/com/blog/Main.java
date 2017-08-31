package com.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"hello","com.blog.controllers", "com.blog.services"})
@EntityScan("com.blog.entities")
@EnableJpaRepositories(basePackages={"com.blog.repositories"})
public class Main {
	public static Integer cantPalabras(String palabra) {
		boolean esPalabra = true;
		Integer resp = 0;
		for(char letra : palabra.toCharArray()) {
			if(letra != ' ' && esPalabra) {
				resp++;
				esPalabra = false;
			} else if(letra == ' ') {
				esPalabra = true;
			}
		}
		return resp;
	}
	public static void main(String[] args) {
		//System.out.println(cantPalabras("         ASDASD ASDAS ASDAS ADASDAS         "));
		SpringApplication.run(Main.class, args);
		hola
	}
}