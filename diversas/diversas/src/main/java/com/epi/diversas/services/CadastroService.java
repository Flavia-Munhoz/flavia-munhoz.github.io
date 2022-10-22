package com.epi.diversas.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.epi.diversas.repositories.DiversasRepositoryCadastro;

@Service
public class CadastroService {
	
	private DiversasRepositoryCadastro diversasRepositoryCadastro;
	
	public void CadastroService(DiversasRepositoryCadastro  diversasRepositoryCadastro){
		this.diversasRepositoryCadastro = diversasRepositoryCadastro;		
	}
	
	
	

}
