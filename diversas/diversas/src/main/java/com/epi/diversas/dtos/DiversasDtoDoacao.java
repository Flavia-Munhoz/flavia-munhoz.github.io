package com.epi.diversas.dtos;

import javax.validation.constraints.NotBlank;

public class DiversasDtoDoacao {
	
	@NotBlank
	private String tipoDoacao;
	@NotBlank
	private String nome;
	@NotBlank
	private String email;
	@NotBlank
	private String mensagem;
	
	
	
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
	
	

}
