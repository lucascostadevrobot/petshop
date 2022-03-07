package controler;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import model.Animal;
import model.Atendimento;
import service.AnimalService;
import service.AtendimentoService;

@ViewScoped
@ManagedBean
public class AtendimentoBean {
	//Inicializaçãos dos atributos
	private Long idAnimal = 0L;
	@EJB
	private AnimalService animalService;
	@EJB
	private AtendimentoService atendimentoService;
	private Atendimento atendimento = new Atendimento();
	private List<Atendimento> atendimentos =  new ArrayList<Atendimento>();
	private List<Animal> animais =  new ArrayList<Animal>();
	
	//Inicializando o metodo para listar os animais atendidos..
	@PostConstruct 
	public void pesquisando() {
		listandoAnimais();
		listandoAtendimentos();
	}
	
	//Metodo criado para cadastrar os atendimentos..
	public void salvarAtendimento() {
		Animal animal = animalService.obtemPorId(idAnimal);
		getAtendimento().setAnimalAtendido(animal);
		
		
		
		//Pega o create e cria na persistência
		atendimentoService.create(getAtendimento());
		FacesContext.getCurrentInstance().addMessage("Parabéns!!!", new FacesMessage("Atendimento para"+atendimento.getAnimalAtendido().getNomeAnimal()
				+"cliente"+atendimento.getAnimalAtendido().getDono().getNomeCliente()+"realizado com sucesso!!"));
		atendimento = new Atendimento();
		idAnimal = 0L;
		listandoAtendimentos();
		
	}
	   //Metodo para listar os animais utilizando listAll..
		public void listandoAnimais() {
			animais = animalService.listAll();
		}
		//Metodo para listar os atendimentos utilizando o listAll..
		public void listandoAtendimentos() {
			atendimentos = atendimentoService.listAll();
		}
		//Criando o metodo para remover os atendimentos cadastrados com a lógica de "exlcuir o atendimentoAtual" no clique
		public void excluindoAtendimento(Atendimento atendimentoAtual) {
			FacesContext.getCurrentInstance().addMessage("Parabéns!!!", new FacesMessage(atendimentoAtual.getAnimalAtendido().getNomeAnimal()
					+"do responsável"+atendimentoAtual.getAnimalAtendido().getDono().getNomeCliente()+"foi excluido com sucesso!!!"));
			atendimentoService.remove(atendimentoAtual);
			listandoAtendimentos();
		}
		
        //Geração dos Geters e Seters..
		public Long getIdAnimal() {
			return idAnimal;
		}

		public void setIdAnimal(Long idAnimal) {
			this.idAnimal = idAnimal;
		}

		public AnimalService getAnimalService() {
			return animalService;
		}

		public void setAnimalService(AnimalService animalService) {
			this.animalService = animalService;
		}

		public AtendimentoService getAtendimentoService() {
			return atendimentoService;
		}

		public void setAtendimentoService(AtendimentoService atendimentoService) {
			this.atendimentoService = atendimentoService;
		}

		public Atendimento getAtendimento() {
			return atendimento;
		}

		public void setAtendimento(Atendimento atendimento) {
			this.atendimento = atendimento;
		}

		public List<Atendimento> getAtendimentos() {
			return atendimentos;
		}

		public void setAtendimentos(List<Atendimento> atendimentos) {
			this.atendimentos = atendimentos;
		}

		public List<Animal> getAnimais() {
			return animais;
		}

		public void setAnimais(List<Animal> animais) {
			this.animais = animais;
		}
		
		
		
				
	}
	
