package com.epi.diversas.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.epi.diversas.model.DiversasSugestaoModel;
import com.epi.diversas.repositories.DiversasRepositorySugestao;

public class SugestaoService {
	
	final DiversasRepositorySugestao diversasRepositorySugestao;
	
	public SugestaoService(DiversasRepositorySugestao diversasRepositorySugestao ){
		this.diversasRepositorySugestao = diversasRepositorySugestao;
	}
	
	
    @Transactional
	public DiversasSugestaoModel  save(DiversasSugestaoModel diversasSugestaoModel) {
		return diversasRepositorySugestao.save( diversasSugestaoModel);
		
	}


	public List<DiversasSugestaoModel> findAll() {
		return diversasRepositorySugestao.findAll();
	}


	public Optional<DiversasSugestaoModel> findById(UUID idSugest) {
		return diversasRepositorySugestao.findById(idSugest) ;
	}

	@Transactional
	public void delete(DiversasSugestaoModel diversasSugestaoModel) {
		diversasRepositorySugestao.delete(diversasSugestaoModel);
	}

}
