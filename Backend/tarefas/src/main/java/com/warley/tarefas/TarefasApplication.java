package com.warley.tarefas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @SpringBootApplication: Classe responsável por subir o servidor e servir o projeto.
 */
@SpringBootApplication
public class TarefasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TarefasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
