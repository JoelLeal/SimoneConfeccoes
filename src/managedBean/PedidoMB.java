package managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import util.JSFUtil;
import dao.PedidoDAO;
import model.Pedido;

@ManagedBean (name = "pedidoMB")
@ViewScoped
public class PedidoMB {
	private Pedido ped = new Pedido();
	private List<Pedido> lstPed = new ArrayList<Pedido>();
	private PedidoDAO dao = new PedidoDAO();
	
	public PedidoMB(){
		PedidoDAO dao = new PedidoDAO();
		lstPed = dao.buscarTodos();
	}
	
	public void salvar(){
		if(ped.getDescricao().equals("")){
			JSFUtil.mensagemErros("Erro", "Descrição em Branco");
		}
		else {
			String codigo = dao.inserir(ped);
			JSFUtil.mensagemOk("Cadastrado com Sucesso", "Pedido: "+codigo);
		}
		
	}
	
	public Pedido getPed() {
		return ped;
	}
	public void setPed(Pedido ped) {
		this.ped = ped;
	}
	public List<Pedido> getLstPed() {
		lstPed = dao.buscarTodos();
		return lstPed;
	}
	public void setLstPed(List<Pedido> lstPed) {
		this.lstPed = lstPed;
	}

}
