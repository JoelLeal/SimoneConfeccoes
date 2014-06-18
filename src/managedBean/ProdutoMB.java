package managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import util.JSFUtil;
import dao.MateriaPrimaDAO;
import dao.ProdutoDAO;
import model.Produto;

//colocar o nome do ManagedBean de (name = "produtoMB")
@ManagedBean (name = "produtoMB")
@ViewScoped
public class ProdutoMB {
	private Produto prod = new Produto();
	private List<Produto> lstProd = new ArrayList<Produto>();
	private MateriaPrimaDAO matDao = new MateriaPrimaDAO();
	
	public ProdutoMB(){
		ProdutoDAO prodDao = new ProdutoDAO();
		lstProd = prodDao.buscarTodos();
	}
	
	public void salvar(){
		ProdutoDAO prodDao = new ProdutoDAO();
		String codigo = prodDao.inserir(prod);
		matDao.atualizarQtdeKgSubtrair((prod.getPesoProd()*prod.getQtde()), prod.getIdMateriaPrima());
		JSFUtil.mensagemOk("Cadastrado com Sucesso", "Produto Num: "+codigo);
	}
	
	public Produto getProd() {
		return prod;
	}
	public void setProd(Produto prod) {
		this.prod = prod;
	}
	public List<Produto> getLstProd() {
		return lstProd;
	}
	public void setLstProd(List<Produto> lstProd) {
		this.lstProd = lstProd;
	}
	
}
