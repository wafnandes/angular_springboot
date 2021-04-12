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
		Tarefas t2 = new Tarefas(null, "Ler", "Ler documentação Angular",
				LocalDateTime.parse("04/04/2021 20:00", formatter), true);
		Tarefas t3 = new Tarefas(null, "Ler", "Ler documentação SpringBoot",
				LocalDateTime.parse("05/04/2021 20:00", formatter), true);
		Tarefas t4 = new Tarefas(null, "Meditar", "Meditar durante 30 minutos pela manhã",
				LocalDateTime.parse("13/04/2021 06:30", formatter), false);

		tarefasRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
	}

}
