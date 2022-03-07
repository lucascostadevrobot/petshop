package service;

import javax.ejb.Stateless;

import model.Cliente;


//Classe Cliente Service...
   
	@Stateless
	public class ClienteService extends GenericService<Cliente>{
		public ClienteService() {
			super(Cliente.class);
          }	
}
