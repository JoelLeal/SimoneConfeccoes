package managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import util.JSFUtil;
import dao.ClienteDAO;
import model.Cliente;

@ManagedBean (name = "clienteMB")
@ViewScoped
public class ClienteMB {
	private Cliente cliente = new Cliente();
	private List<Cliente> lista = new ArrayList<Cliente>();
	private ClienteDAO dao = new ClienteDAO();
	
	public ClienteMB(){
		lista = dao.buscarTodos();
	}
	
	public void salvar() {
		if(cliente.getNomeFantasia().equals("")){
			JSFUtil.mensagemErros("Erro", "Campo em branco");
		} else {
		ClienteDAO cliDAO = new ClienteDAO();
		cliDAO.inserir(cliente);
		JSFUtil.mensagemOk("Cadastrado com Sucesso", "Código: ");
		}
	}
	
	public ClienteDAO getDao() {
		return dao;
	}

	public void setDao(ClienteDAO dao) {
		this.dao = dao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getLista() throws Exception {
		return lista;
	}

	public void setLista(List<Cliente> lista) {
		this.lista = lista;
	}
}
