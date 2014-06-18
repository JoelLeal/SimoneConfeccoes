package managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import util.JSFUtil;
import dao.ProdutoDAO;
import dao.VendaDAO;
import dao.VendaDetalheDAO;
import model.Venda;
import model.VendaDetalhe;

@ManagedBean (name = "vendaMB")
@SessionScoped
public class VendaMB {
	private Integer codigo;
	private Venda vnd = new Venda();
	private List<Venda> lstVnd = new ArrayList<Venda>();
	private VendaDAO vndDao = new VendaDAO();
	private VendaDetalhe vndDet = new VendaDetalhe();
	private VendaDetalheDAO vndDetDao = new VendaDetalheDAO();
	private List<VendaDetalhe> lstVndDet = new ArrayList<VendaDetalhe>();
	
	public String salvar(){
		System.out.println("Código: "+codigo);
		vndDao = new VendaDAO();
		codigo = vndDao.inserir(vnd);
		JSFUtil.mensagemOk("Venda Cadastrada com Sucesso", "Código: "+codigo);
		vnd = new Venda();
		return "adcionarProduto";
	}
	
	public String salvarProd(){
		vndDetDao = new VendaDetalheDAO();
		vndDet.setIdVena(codigo);
		vndDet.setValorTotal(vndDet.getValorUnitario()*vndDet.getQtde());
		vndDetDao.inserir(vndDet);
		JSFUtil.mensagemOk("Produto Inserido", "R$"+vndDet.getValorTotal());
		ProdutoDAO proDao = new ProdutoDAO();
		proDao.atualizarQtde(vndDet.getIdProduto(), vndDet.getQtde());
		vndDetDao = new VendaDetalheDAO();
		lstVnd = new ArrayList<Venda>();
		return "adcionarProduto";
	}
	
	public String atualizar(){
		vndDao.atualizarTotal(codigo);
		return "index";
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Venda getVnd() {
		return vnd;
	}
	public void setVnd(Venda vnd) {
		this.vnd = vnd;
	}
	public List<Venda> getLstVnd() {
		lstVnd = vndDao.buscarTodos();
		return lstVnd;
	}
	public void setLstVnd(List<Venda> lstVnd) {
		this.lstVnd = lstVnd;
	}
	public VendaDAO getVndDao() {
		return vndDao;
	}
	public void setVndDao(VendaDAO vndDao) {
		this.vndDao = vndDao;
	}

	public VendaDetalhe getVndDet() {
		return vndDet;
	}

	public void setVndDet(VendaDetalhe vndDet) {
		this.vndDet = vndDet;
	}

	public VendaDetalheDAO getVndDetDao() {
		return vndDetDao;
	}

	public void setVndDetDao(VendaDetalheDAO vndDetDao) {
		this.vndDetDao = vndDetDao;
	}

	public List<VendaDetalhe> getLstVndDet() {
		lstVndDet = vndDetDao.buscarTodos();
		return lstVndDet;
	}

	public void setLstVndDet(List<VendaDetalhe> lstVndDet) {
		this.lstVndDet = lstVndDet;
	}
	
}