package com.warley.tarefas.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	 * @GetMapping: notação que informa que o método retorna um responseEntity de uma 
	 * requisição do tipo Get.
	 * 
	 * @PathVariable: notação que indica que o parâmetro veio de um path, no caso {id}.
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Tarefas> findById(@PathVariable Integer id){
		Tarefas obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
