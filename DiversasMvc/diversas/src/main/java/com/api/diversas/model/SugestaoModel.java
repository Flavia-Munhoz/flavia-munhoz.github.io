package com.api.diversas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_DIVERSAS_SUGESTAO")
public class SugestaoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idSugestao;

	@Column(nullable = false, length = 130)
	private String nome;

	@Column(nullable = false, unique = true, length = 130)
	private String email;

	@Column(nullable = false, unique = true, length = 200)
	private String sugestao;

	public long getIdSugestao() {
		return idSugestao;
	}

	public void setIdSugestao(long idSugestao) {
		this.idSugestao = idSugestao;
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

	public String getSugestao() {
		return sugestao;
	}

	public void setSugestao(String sugestao) {
		this.sugestao = sugestao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
