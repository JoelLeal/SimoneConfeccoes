package managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import util.JSFUtil;
import dao.FornecedorDAO;
import model.Fornecedor;

@ManagedBean (name = "fornecedorMB")
@ViewScoped
public class FornecedorMB {
	private Fornecedor fornec = new Fornecedor();
	private List<Fornecedor> lstFornec = new ArrayList<Fornecedor>();
	
	public FornecedorMB(){
		FornecedorDAO fornecDao = new FornecedorDAO();
		lstFornec = fornecDao.buscarTodos();
	}
	
	public void salvar(){
		if(fornec.getNomeFantasia().equals("")){
			JSFUtil.mensagemErros("Erro", "Campo em Branco");
		} else {
			FornecedorDAO fornecDao = new FornecedorDAO();
			fornecDao.inserir(fornec);
			JSFUtil.mensagemOk("Cadastrado com Sucesso", "Nome: "+fornec.getNomeFantasia());
		}
	}

	public Fornecedor getFornec() {
		return fornec;
	}

	public void setFornec(Fornecedor fornec) {
		this.fornec = fornec;
	}

	public List<Fornecedor> getLstFornec() {
		return lstFornec;
	}

	public void setLstFornec(List<Fornecedor> lstFornec) {
		this.lstFornec = lstFornec;
	}
}
