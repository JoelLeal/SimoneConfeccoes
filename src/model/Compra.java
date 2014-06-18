package model;

import java.util.Date;

public class Compra {
	private Integer id;
	private Integer idFornecedor;
	private Date dataCompra;
	private float valorTotal;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(Integer idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

}
