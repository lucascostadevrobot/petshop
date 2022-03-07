package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Atendimento {

	@Id @GeneratedValue
	private Long Id;
	
	private String descricao;
	private Double valor;
	
	@ManyToOne
	private Animal animalAtendido;
	
	//Construtor vazio..
	public Atendimento() {
		
		
		
	}
	//Geração Geters e Seters..
	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}



	public Animal getAnimalAtendido() {
		return animalAtendido;
	}


	public void setAnimalAtendido(Animal animalAtendido) {
		this.animalAtendido = animalAtendido;
	}
	
	
	
	
}
