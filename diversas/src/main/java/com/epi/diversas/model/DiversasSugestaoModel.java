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
@Table(name = "TB_DIVERSAS_SUGESTAO" )
public class DiversasSugestaoModel implements Serializable  {
	private static final long serialVersionUID = 1L;
	

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idSugest;
    
    @Column(nullable = false, length = 130) 
	private String nome;
    
    @Column(nullable = false, unique = true, length = 130) 
	private String email;
    
    @Column(nullable = false, unique = true, length = 200)
    private String sugestao;
    
    @Column(nullable = false)
    private LocalDateTime registrationDate;
    
    

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	public UUID getIdSugest() {
		return idSugest;
	}

	public void setIdSugest(UUID idSugest) {
		this.idSugest = idSugest;
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
