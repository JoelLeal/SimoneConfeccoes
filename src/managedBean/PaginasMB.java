package managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean (name = "paginasMB")
@ViewScoped
public class PaginasMB {
	public String cadCli(){
		return "cadastrarCliente";
	}
	public String busCli(){
		return "buscarCliente";
	}
	public String index(){
		return "index";
	}
	public String cadForn(){
		return "cadastrarFornecedor";
	}
	public String busForn(){
		return "buscarFornecedor";
	}
	public String cadComp(){
		return "cadastrarCompra";
	}
	public String cadMatPri(){
		return "cadastrarMateriaPrima";
	}
	public String busMatPri(){
		return "buscarMateriaPrima";
	}
	public String cadProd(){
		return "cadastrarProduto";
	}
	public String busProd(){
		return "buscarProduto";
	}
	public String busComp(){
		return "buscarCompra";
	}
	public String cadVnd(){
		return "cadastrarVenda";
	}
	public String busVnd(){
		return "buscarVenda";
	}
	public String cadPed(){
		return "cadastrarPedido";
	}
	public String busPed(){
		return "buscarPedido";
	}
}
