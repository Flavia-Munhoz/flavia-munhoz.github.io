package com.epi.diversas.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_DIVERSAS_DOACAO")
public class DiversasDoacaoModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	/* */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idDoa;
	
	@Column(nullable = false, unique = true, length = 120) 
	private String tipoDoacao;
	
	@Column(nullable = false, length = 140) 
	private String nome;
	
	@Column(nullable = false, unique = true, length = 120) 
	private String email;
	
	@Column(nullable = false, unique = true, length = 170) 
	private String mensagem;
	
	@Column(nullable = false)
    private LocalDateTime registrationDate;

	
	
	
	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	public UUID getIdDoa() {
		return idDoa;
	}

	public void setIdDoa(UUID idDoa) {
		this.idDoa = idDoa;
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
