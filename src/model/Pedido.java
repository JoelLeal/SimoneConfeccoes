package model;

import java.util.Date;

public class Pedido {
	private Integer id;
	private Integer idCliente;
	private String descricao;
	private Date dataPedido;
	private Date dataPrevisao;
	private Date dataPronto;
	private float valorPrevisto;
	private float valorFinal;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Date getDataPrevisao() {
		return dataPrevisao;
	}
	public void setDataPrevisao(Date dataPrevisao) {
		this.dataPrevisao = dataPrevisao;
	}
	public Date getDataPronto() {
		return dataPronto;
	}
	public void setDataPronto(Date dataPronto) {
		this.dataPronto = dataPronto;
	}
	public float getValorPrevisto() {
		return valorPrevisto;
	}
	public void setValorPrevisto(float valorPrevisto) {
		this.valorPrevisto = valorPrevisto;
	}
	public float getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(float valorFinal) {
		this.valorFinal = valorFinal;
	}
	
}
