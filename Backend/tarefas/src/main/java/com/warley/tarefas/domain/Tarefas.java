package com.warley.tarefas.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

/*
 * @Entity: informa que a classe é uma entidade e que seus objetos devem
 * ser persistidos em uma base de dados. Pode ser usada com a notação (name="nome").
 * 
 * Serializable: boa prática.
 */
@Entity
public class Tarefas implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/*
	 * @Id: declara atributo como chave primária
	 * 
	 * @GeneratedValue: declara que o banco de dados fica responsável pela criação
	 * do Id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String titulo;
	private String descricao;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataParaFinalizar;
	private Boolean finalizado = false;

	public Tarefas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tarefas(Integer id, String titulo, String descricao, Date dataParaFinalizar, Boolean finalizado) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataParaFinalizar = dataParaFinalizar;
		this.finalizado = finalizado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataParaFinalizar() {
		return dataParaFinalizar;
	}

	public void setDataParaFinalizar(Date dataParaFinalizar) {
		this.dataParaFinalizar = dataParaFinalizar;
	}

	public Boolean getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefas other = (Tarefas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
