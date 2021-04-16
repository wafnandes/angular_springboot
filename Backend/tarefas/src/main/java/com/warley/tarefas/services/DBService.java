package com.warley.tarefas.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warley.tarefas.domain.Tarefas;
import com.warley.tarefas.repositories.TarefasRepository;

@Service
public class DBService {

	/*
	 * @Autowired: cria, gerencia e finaliza a instância do projeto.
	 */
	@Autowired
	private TarefasRepository tarefasRepository;

	public void instanciaBaseDeDados() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Tarefas t1 = new Tarefas(null, "Estudar", "Estudar SpringBoot 2 e Angular 11",
				sdf.parse("25/03/2022"), false);

		tarefasRepository.saveAll(Arrays.asList(t1));
	}

}
