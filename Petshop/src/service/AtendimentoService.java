package service;

import javax.ejb.Stateless;

import model.Atendimento;

@Stateless 
	public class AtendimentoService extends GenericService<Atendimento>{
		public AtendimentoService() {
			super(Atendimento.class);
	}
}
