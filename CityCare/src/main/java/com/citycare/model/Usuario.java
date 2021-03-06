package com.citycare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "cpf", "email" }))
public class Usuario {

	
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="cpf", nullable = false)
	private String cpf;
	
	@Column(name="senha", nullable = false)
	private String senha;
	
	@Column(name="email", nullable = false)
	private String email;
	
	@Column(name="nome", nullable = false)
	private String nome;
	
	@Column(name="sobrenome", nullable = false)
	private String sobrenome;
	
	@Column(name="status", columnDefinition = "boolean default true")
	private boolean status=true;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	

}
