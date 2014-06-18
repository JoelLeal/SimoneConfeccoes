package model;

public class MateriaPrima {
	
	private Integer id;
	private String descricao;
	private Boolean tipoTecido;
	private float qtdekg;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Boolean getTipoTecido() {
		return tipoTecido;
	}
	public void setTipoTecido(Boolean tipoTecido) {
		this.tipoTecido = tipoTecido;
	}
	public float getQtdekg() {
		return qtdekg;
	}
	public void setQtdekg(float qtdekg) {
		this.qtdekg = qtdekg;
	}
}
