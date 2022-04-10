package com.banco.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
	falta hacer alguna forma de crear los usuarios y que tengan distintos roles, por ahora solo se pueden crear
	directamente en la base de datos. Ahi hay que guardar la contraseña de forma codificada, pero cuando quiero acceder
	a la API hay que poner de forma normal.

	Es decir, desde esta pagina https://bcrypt-generator.com/ se codifica la contraseña y se guarda en la BD directamente
	ejemplo: 1234 -> $2a$12$ariFgTwP944vOVxj6uytouuYeK72x7ZNZwEWvI.sqpAh.JCskvoLG
	pero en la API pongo 1234
*/

@SpringBootApplication
public class DesafioApplication {
	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}
}
