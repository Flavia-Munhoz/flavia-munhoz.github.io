package com.epi.diversas.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.epi.diversas.model.DiversasDoacaoModel;
import com.epi.diversas.repositories.DiversasRepositoryDaocao;

@Service
public class DoacaoService {
	
	
	private DiversasRepositoryDaocao diversasRepositoryDaocao;
	
	
	public  DoacaoService( DiversasRepositoryDaocao diversasRepositoryDaocao ) {
		this.diversasRepositoryDaocao = diversasRepositoryDaocao;
	}

    @Transactional
	public DiversasDoacaoModel save(DiversasDoacaoModel diversasDoacaoModel) {
		return diversasRepositoryDaocao.save(diversasDoacaoModel);
	}

	public List<DiversasDoacaoModel> findAll() {
		return diversasRepositoryDaocao.findAll();
	}

	public Optional<DiversasDoacaoModel> findById(UUID id) {
		return diversasRepositoryDaocao.findById(id) ;
	}

	public void delete(DiversasDoacaoModel diversasDoacaoModel) {
	
	}
	
	
}
