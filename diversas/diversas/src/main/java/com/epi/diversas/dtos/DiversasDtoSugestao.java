package com.epi.diversas.dtos;

import javax.validation.constraints.NotBlank;

public class DiversasDtoSugestao {
	
	@NotBlank
	private String nome;
	@NotBlank
	private String email;
	@NotBlank
	private String sugestao;
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
	
	

}
