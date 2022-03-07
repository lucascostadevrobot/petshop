package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Animal {

	@Id @GeneratedValue
	private Long Id;
	
	private String nomeAnimal;
	private String racaAnimal;
	private String especieAnimal;
	
	@ManyToOne
	private Cliente dono;// Relacionameto com a classe Cliente | Vulgo dono Animal..
	
	//Construtor vazio..
	public Animal() {
		
	}

	
    //Geração Geters e Seters..
	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}

	public Cliente getDono() {
		return dono;
	}


	public void setDono(Cliente dono) {
		this.dono = dono;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}


	public String getRacaAnimal() {
		return racaAnimal;
	}


	public void setRacaAnimal(String racaAnimal) {
		this.racaAnimal = racaAnimal;
	}


	public String getEspecieAnimal() {
		return especieAnimal;
	}


	public void setEspecieAnimal(String especieAnimal) {
		this.especieAnimal = especieAnimal;
	}
	
	
}
