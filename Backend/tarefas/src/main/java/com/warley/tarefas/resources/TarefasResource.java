package com.warley.tarefas.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.warley.tarefas.domain.Tarefas;
import com.warley.tarefas.services.TarefasService;

/*
 * @RestController: informa que a classe é uma controladora Rest e recebe requisições
 * do tipo HTTP.
 * 
 * @RequestMapping: seta o nome do endpoint.
 */
@RestController
@RequestMapping(value = "/tarefas")
public class TarefasResource {

	@Autowired
	private TarefasService service;

	/*
	 * @GetMapping: notação que informa que o método retorna um responseEntity de
	 * uma requisição do tipo Get.
	 * 
	 * @PathVariable: notação que indica que o parâmetro veio de um path, no caso
	 * {id}.
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Tarefas> findById(@PathVariable Integer id) {
		Tarefas obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/open")
	public ResponseEntity<List<Tarefas>> listOpen() {
		List<Tarefas> list = service.findAllOpen();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/close")
	public ResponseEntity<List<Tarefas>> listClose() {
		List<Tarefas> list = service.findAllClose();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping
	public ResponseEntity<List<Tarefas>> listAll() {
		List<Tarefas> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping 
	public ResponseEntity<Tarefas> create(@RequestBody Tarefas obj){
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
}
