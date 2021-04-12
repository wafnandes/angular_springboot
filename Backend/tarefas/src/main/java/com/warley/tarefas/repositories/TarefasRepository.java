package com.warley.tarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.warley.tarefas.domain.Tarefas;

/*
 * @Repository: Notação padrão para repositório.
 */
@Repository
public interface TarefasRepository extends JpaRepository<Tarefas, Integer> {
	
}
