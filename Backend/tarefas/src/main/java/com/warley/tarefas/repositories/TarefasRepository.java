package com.warley.tarefas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.warley.tarefas.domain.Tarefas;

/*
 * @Repository: Notação padrão para repositório.
 */
@Repository
public interface TarefasRepository extends JpaRepository<Tarefas, Integer> {

	@Query("SELECT obj FROM Tarefas obj WHERE obj.finalizado = false ORDER BY obj.dataParaFinalizar")
	List<Tarefas> findAllOpen();

}
