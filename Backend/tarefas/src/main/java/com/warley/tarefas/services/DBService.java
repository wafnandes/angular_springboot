package com.warley.tarefas.services;

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

	public void instanciaBaseDeDados() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		Tarefas t1 = new Tarefas(null, "Estudar", "Estudar SpringBoot 2 e Angular 11",
				LocalDateTime.parse("25/03/2022 10:40", formatter), false);

		tarefasRepository.saveAll(Arrays.asList(t1));
	}

}
