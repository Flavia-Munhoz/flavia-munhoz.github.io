package com.epi.diversas.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epi.diversas.model.DiversasCadastroModel;

@Repository
public interface DiversasRepositoryCadastro extends JpaRepository<DiversasCadastroModel, UUID> {

	
	boolean existsByEmail(String email);
	boolean existsByCpf(String cpf);

}

