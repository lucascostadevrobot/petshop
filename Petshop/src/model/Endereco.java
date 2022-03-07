package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Endereco {

	@Id @GeneratedValue
	private Long Id;
	
	private String rua;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String cep;
	
	
	//Construtor vazio..
    public Endereco() {
			
  }
    //Metodo para endereçamento..
    public String getEnderecoTodo() {
    	return rua+", "+numero+"-"+bairro;
    }
    
	//Geração Geters e Seters..
    
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
    
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	
	

	
}
