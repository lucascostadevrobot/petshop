package controler;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import model.Cliente;
import service.ClienteService;

@ViewScoped
@ManagedBean
public class ClienteBean {

	private Cliente cliente = new Cliente(); //Criando objeto Cliente..
	
	private List<Cliente> clientes = new ArrayList<Cliente>(); //Criando ArrayList com objeto Cliente..
	
	@EJB
	private ClienteService clienteService;
	
	@PostConstruct
	public void pesquisar() {
		listandoClientes();
	}
	
	//Metodo cadastro cliente | verifica se o ID está vazio | se estiver ele permite a gravação.
	public void CadastarCliente() {
		if(cliente.getId()==null) {
			clienteService.create(cliente);
			FacesContext.getCurrentInstance().addMessage("Cadastro realizado com sucesso!", new FacesMessage("Cliente"+cliente.getNomeCliente()+"Cliente Alterado com sucesso!"));
		}else {
			clienteService.merge(cliente);
			FacesContext.getCurrentInstance().addMessage("Parabéns!!!", new FacesMessage("O cliente"+cliente.getNomeCliente()+"atualizado com sucesso!!!"));
		}
		
		//Nova instancia zerando..
		cliente = new Cliente();
		listandoClientes();
	}
	
	//Metódo listar clientes usando listAll da classe GenericService e objeto Cliente..
	public void listandoClientes() {
		clientes = clienteService.listAll();
	}
	
	//Edita o Cliente com a variavel clienteAtual
	public void ediçãoTODO(Cliente clienteAtual) {
		cliente = clienteAtual;
	}

	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	

}
