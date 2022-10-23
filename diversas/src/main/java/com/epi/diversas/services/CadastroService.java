package com.epi.diversas.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.epi.diversas.model.DiversasCadastroModel;
import com.epi.diversas.repositories.DiversasRepositoryCadastro;

@Service
public class CadastroService {
	
	private DiversasRepositoryCadastro diversasRepositoryCadastro;
	
	public CadastroService(DiversasRepositoryCadastro  diversasRepositoryCadastro){
		this.diversasRepositoryCadastro = diversasRepositoryCadastro;		
	}

	@Transactional
	public DiversasCadastroModel save(DiversasCadastroModel diversasCadastroModel) {
		return diversasRepositoryCadastro.save(diversasCadastroModel) ;
	}
	
	public boolean existsByEmail(String email) {
		return diversasRepositoryCadastro.existsByEmail(email);
	}

	public boolean existsByCpf(String cpf) {
		return diversasRepositoryCadastro.existsByCpf(cpf);
	}

	public List<DiversasCadastroModel> findAll() {
		return diversasRepositoryCadastro.findAll();
	}

	public Optional<DiversasCadastroModel> findById(UUID id) {
		return diversasRepositoryCadastro.findById(id) ;
	}
    
	@Transactional
	public void delete(DiversasCadastroModel diversasCadastroModel) {
		diversasRepositoryCadastro.delete(diversasCadastroModel);
	}
	
	
	
	
	
	

}
