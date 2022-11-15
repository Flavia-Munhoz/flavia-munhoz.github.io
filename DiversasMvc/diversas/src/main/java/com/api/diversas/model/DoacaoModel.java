package com.api.diversas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_DIVERSAS_DOACAO")
public class DoacaoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idDoacao;

	@Column(nullable = false, unique = true, length = 120)
	private String tipoDoacao;

	@Column(nullable = false, length = 140)
	private String nome;

	@Column(nullable = false, unique = true, length = 120)
	private String email;

	@Column(nullable = false, unique = true, length = 170)
	private String mensagem;

	public long getIdDoacao() {
		return idDoacao;
	}

	public void setIdDoacao(long idDoacao) {
		this.idDoacao = idDoacao;
	}

	public String getTipoDoacao() {
		return tipoDoacao;
	}

	public void setTipoDoacao(String tipoDoacao) {
		this.tipoDoacao = tipoDoacao;
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

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
