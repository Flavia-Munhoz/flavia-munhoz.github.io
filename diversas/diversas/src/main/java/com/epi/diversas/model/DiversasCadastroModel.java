package com.epi.diversas.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/* */

@Entity
@Table(name = "TB_DIVERSAS_CADASTRO")
public class DiversasCadastroModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
	
	@Column(nullable = false, length = 130) 
	private String nome;
	
	@Column(nullable = false, unique = true, length = 170) 
	private String email;
	
	@Column(nullable = false, length = 15) 
	private String senha;
	
	@Column(nullable = false, unique = true, length = 11) 
	private String cpf;

	
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
