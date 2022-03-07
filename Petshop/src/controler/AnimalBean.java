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
import model.Cliente;
import service.AnimalService;
import service.ClienteService;

@ViewScoped
@ManagedBean
public class AnimalBean {
	
	private Long idDonoAnimal = 0L;
	private Animal animal = new Animal(); //Criando Objeto Animal 
	private List<Animal> animais = new ArrayList<Animal>(); //Criando Array List com Objeto Animal..
	private List<Cliente> donosAnimais = new ArrayList<Cliente>();//instanciando

	
	@EJB
	private AnimalService animalService;
	@EJB
	private ClienteService clienteService;
	//Inicializando metodo pesquisando com o listAll..
	@PostConstruct
	public void pesquisar() {
		donosAnimais = clienteService.listAll();
		listandoAnimais();
	}
	
	//Meoto para salvar o animal | Utilização da estrutura de condição
	public void salvarAnimal() {
		if(idDonoAnimal==0) {
			FacesContext.getCurrentInstance().addMessage("Cuidado", new FacesMessage("Escolha o dono do Animal"));
		}else {
			if(getAnimal().getId()!=null) {
				if(idDonoAnimal!=getAnimal().getDono().getId()) {
			  FacesContext.getCurrentInstance().addMessage("Cuidado!!!", new FacesMessage("Não é possivel mudar o dono!"));
				}else {
					animalService.merge(getAnimal());
					FacesContext.getCurrentInstance().addMessage("Parabéns!!!", new FacesMessage("O Animal" +animal.getNomeAnimal()+"Foi atualizado para o dono"
							+animal.getDono().getNomeCliente()+"com sucesso!!!"));
					setAnimal(new Animal());
					idDonoAnimal =0L;
					listandoAnimais();
				}
			}else {
				Cliente dono = clienteService.obtemPorId(idDonoAnimal);
				getAnimal().setDono(dono);
				animalService.create(getAnimal());
				FacesContext.getCurrentInstance().addMessage("Parabens Colabordor!!!", new FacesMessage("Animal"+animal.getNomeAnimal()+"foi registrado com sucesso para o dono"+animal.getDono().getNomeCliente()+"sucesso!!!"));
				
				setAnimal(new Animal());
				idDonoAnimal= 0L;
				listandoAnimais();


			}
		}
		
	}
	
	//Metodo para listar os animais na tabela
	public void listandoAnimais() {
		animais = animalService.listAll();
	}
	
	//Metodo para editar os animais cadastrados
	public void editandoAnimais(Animal animalAtual) {
		setAnimal(animalAtual);
		idDonoAnimal = animalAtual.getDono().getId();
	}

	//Geração dos Geters e Seters..
	public Long getIdDonoAnimal() {
		return idDonoAnimal;
	}


	public void setIdDonoAnimal(Long idDonoAnimal) {
		this.idDonoAnimal = idDonoAnimal;
	}


	public Animal getAnimal() {
		return animal;
	}


	public void setAnimal(Animal animal) {
		this.animal = animal;
	}


	public List<Animal> getAnimais() {
		return animais;
	}


	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}


	public List<Cliente> getDonosAnimais() {
		return donosAnimais;
	}


	public void setDonosAnimais(List<Cliente> donosAnimais) {
		this.donosAnimais = donosAnimais;
	}


	public AnimalService getAnimalService() {
		return animalService;
	}


	public void setAnimalService(AnimalService animalService) {
		this.animalService = animalService;
	}


	public ClienteService getClienteService() {
		return clienteService;
	}


	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	
	
	
}
