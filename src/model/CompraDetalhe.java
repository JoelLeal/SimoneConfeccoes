package model;


public class CompraDetalhe {
	private Integer idMateriaPrima;
	private Integer idCompra;
	private float qtdekg;
	private float valorkg;
	private float valorTotal;
	
	
	public Integer getIdMateriaPrima() {
		return idMateriaPrima;
	}
	public void setIdMateriaPrima(Integer idMateriaPrima) {
		this.idMateriaPrima = idMateriaPrima;
	}
	public Integer getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}
	public float getQtdekg() {
		return qtdekg;
	}
	public void setQtdekg(float qtdekg) {
		this.qtdekg = qtdekg;
	}
	public float getValorkg() {
		return valorkg;
	}
	public void setValorkg(float valorkg) {
		this.valorkg = valorkg;
	}
	public float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
