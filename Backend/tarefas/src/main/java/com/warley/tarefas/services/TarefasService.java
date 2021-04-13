package com.warley.tarefas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warley.tarefas.domain.Tarefas;
import com.warley.tarefas.repositories.TarefasRepository;
import com.warley.tarefas.services.exceptions.ObjectNotFoundException;


/*
 * @Service: Notação que permite injetar o serviço em partes diferentes do código
 */
@Service
public class TarefasService {
	
	@Autowired
	private TarefasRepository repository;
	
	public Tarefas findById(Integer id) {
		Optional<Tarefas> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Tarefas.class.getName()));
	}
	
	public List<Tarefas> findAllOpen() {
		List<Tarefas> list = repository.findAllOpen();
		return list;
	}

	public List<Tarefas> findAllClose() {
		List<Tarefas> list = repository.findAllClose();
		return list;
	}

	public List<Tarefas> findAll() {
		List<Tarefas> list = repository.findAll();
		return list;
	}

	public Tarefas create(Tarefas obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public Tarefas update(Integer id, Tarefas obj) {
		Tarefas newObj = findById(id);
		newObj.setTitulo(obj.getTitulo());
		newObj.setDataParaFinalizar(obj.getDataParaFinalizar());
		newObj.setDescricao(obj.getDescricao());
		newObj.setFinalizado(obj.getFinalizado());
		return repository.save(newObj);
	}
}
