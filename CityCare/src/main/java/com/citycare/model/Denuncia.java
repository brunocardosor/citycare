package com.citycare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Denuncia {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="descricao", nullable=false)
	private String descricao;
	@Column(name="localizacao", nullable=false)
	private String localizacao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
}
