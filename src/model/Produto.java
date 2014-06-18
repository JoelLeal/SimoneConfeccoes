package model;

public class Produto {
	private Integer id;
	private Integer idMateriaPrima;
	private String descricao;
	private float valor;
	private Integer qtde;
	private float pesoProd;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdMateriaPrima() {
		return idMateriaPrima;
	}
	public void setIdMateriaPrima(Integer idMateriaPrima) {
		this.idMateriaPrima = idMateriaPrima;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Integer getQtde() {
		return qtde;
	}
	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}
	public float getPesoProd() {
		return pesoProd;
	}
	public void setPesoProd(float pesoProd) {
		this.pesoProd = pesoProd;
	}
	
}
