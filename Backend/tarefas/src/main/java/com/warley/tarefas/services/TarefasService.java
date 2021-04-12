package com.warley.tarefas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warley.tarefas.domain.Tarefas;
import com.warley.tarefas.repositories.TarefasRepository;

/*
 * @Service: Notação que permite injetar o serviço em partes diferentes do código
 */
@Service
public class TarefasService {
	
	@Autowired
	private TarefasRepository repository;
	
	public Tarefas findById(Integer id) {
		Optional<Tarefas> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	public List<Tarefas> findAllOpen() {
		List<Tarefas> list = repository.findAllOpen();
		return list;
	}
}
