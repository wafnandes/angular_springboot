package com.warley.tarefas.configuration;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.warley.tarefas.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	
	/*
	 * @Autowired: cria, gerencia e finaliza a instância do projeto.
	 */
	@Autowired
	private DBService dbService;
	
	/*
	 * Inicializa as instâncias da base de dados
	 */
	@Bean
	public boolean instancia() throws ParseException {
		this.dbService.instanciaBaseDeDados();
		return true;
	}
	
	
}
