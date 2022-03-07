package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cliente {
	
	@Id @GeneratedValue
	private Long Id;
	
	
	private String nomeCliente;
	private String cpfCliente;
	
	//Relacionamento com  a classe Endereco
	@OneToOne
	(cascade = CascadeType.ALL)
	private Endereco endereco = new Endereco();
	
	
	


	
	
	//Geração dos Geters e Seters
	public Long getId() {
		return Id;
	}




	public void setId(Long id) {
		Id = id;
	}

	
	public String getNomeCliente() {
		return nomeCliente;
	}



	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public String getCpfCliente() {
		return cpfCliente;
	}


	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}




	public Endereco getEndereco() {
		return endereco;
	}




	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}





	
	
	
	

}
