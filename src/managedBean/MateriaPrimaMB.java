package managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import util.JSFUtil;
import dao.MateriaPrimaDAO;
import model.MateriaPrima;

@ManagedBean (name = "materiaPrimaMB")
@ViewScoped
public class MateriaPrimaMB {
	private MateriaPrima mat = new MateriaPrima();
	private List<MateriaPrima> lista = new ArrayList<MateriaPrima>();
	private MateriaPrimaDAO matDao = new MateriaPrimaDAO();
	
	public MateriaPrimaMB(){
		MateriaPrimaDAO matDao = new MateriaPrimaDAO();
		lista=matDao.buscarTodos();
	}
	
	public void salvar(){
		if(mat.getDescricao().equals("")){
			JSFUtil.mensagemErros("Erro", "Descrição em Branco");
		}
		else{
			String codigo = matDao.inserir(mat);
			JSFUtil.mensagemOk("Cadastrado com Sucesso", "Código: "+ codigo);
		}
	}

	public MateriaPrima getMat() {
		return mat;
	}

	public void setMat(MateriaPrima mat) {
		this.mat = mat;
	}

	public List<MateriaPrima> getLista() {
		return lista;
	}

	public void setLista(List<MateriaPrima> lista) {
		this.lista = lista;
	}
	
}
