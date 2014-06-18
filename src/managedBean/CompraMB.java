package managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import util.JSFUtil;
import dao.CompraDAO;
import dao.CompraDetalheDAO;
import dao.MateriaPrimaDAO;
import model.Compra;
import model.CompraDetalhe;

@ManagedBean (name = "compraMB")
@SessionScoped
public class CompraMB {
	private Integer codigo;
	private Compra comp = new Compra();
	private CompraDetalhe compDet = new CompraDetalhe();
	private List<Compra> lstComp = new ArrayList<Compra>();
	private List<CompraDetalhe> lstCompDet = new ArrayList<CompraDetalhe>();
	private CompraDetalheDAO compDetdao = new CompraDetalheDAO();
	private CompraDAO compDao = new CompraDAO();
	
	public CompraMB(){
		System.out.println("passou aqui");
	}
	
	public String salvar(){
		System.out.println("Código: "+codigo);
		//CompraDAO compDao = new CompraDAO();
		codigo = compDao.inserir(comp);
		JSFUtil.mensagemOk("Compra Cadastrada com Sucesso", "Código: "+codigo);
		System.out.println("Código: "+codigo);
		comp = new Compra();
		return "adcionarMateriaPrima";
	}
	
	public String salvarMat(){
		System.out.println("Código: "+codigo);
		//CompraDetalheDAO compDetdao = new CompraDetalheDAO();
		MateriaPrimaDAO matDao = new MateriaPrimaDAO();
		System.out.println("Qtde kg: "+compDet.getQtdekg());
		matDao.atualizarQtdeKg(compDet.getQtdekg(), compDet.getIdMateriaPrima());
		System.out.println("Qtde kg: "+compDet.getQtdekg());
		compDet.setIdCompra(codigo);
		compDet.setValorTotal(compDet.getQtdekg()*compDet.getValorkg());
		if(compDet.getIdMateriaPrima().equals(0)){
			JSFUtil.mensagemErros("Erro", "Nenhum Código de Matéria Prima Adicionado");
		}
		else {
			compDetdao.inserir(compDet);
			JSFUtil.mensagemOk("Adcionada com Sucesso", "R$"+compDet.getValorTotal());
		}
		compDet = new CompraDetalhe();
		lstCompDet = new ArrayList<CompraDetalhe>();
		lstComp = new ArrayList<Compra>();
		return "adcionarMateriaPrima";
	}
	
	public String atualizar(){
		CompraDAO compDao = new CompraDAO();
		compDao.atualizarTotal(codigo);
		System.out.println("Atualizar Código: "+this.codigo);
		return "index";
	}
	public Compra getComp() {
		return comp;
	}
	public void setComp(Compra comp) {
		this.comp = comp;
	}
	public List<Compra> getLstComp() {
		lstComp = compDao.buscarTodos();
		return lstComp;
	}
	public void setLstComp(List<Compra> lstComp) {
		this.lstComp = lstComp;
	}
	public CompraDetalhe getCompDet() {
		return compDet;
	}
	public void setCompDet(CompraDetalhe compDet) {
		this.compDet = compDet;
	}
	public List<CompraDetalhe> getLstCompDet() {
		lstCompDet = compDetdao.buscarTodos();
		return lstCompDet;
	}
	public void setLstCompDet(List<CompraDetalhe> lstCompDet) {
		this.lstCompDet = lstCompDet;
	}
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
}
