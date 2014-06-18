package model;

public class VendaDetalhe {
	private Integer idVena;
	private Integer idProduto;
	private Integer qtde;
	private float valorUnitario;
	private float valorTotal;
	
	
	public Integer getIdVena() {
		return idVena;
	}
	public void setIdVena(Integer idVena) {
		this.idVena = idVena;
	}
	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	public Integer getQtde() {
		return qtde;
	}
	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}
	public float getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
