package com.epi.diversas.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epi.diversas.model.DiversasCadastroModel;
import com.epi.diversas.model.DiversasDoacaoModel;

@Repository
public interface DiversasRepositoryCadastro extends JpaRepository<DiversasCadastroModel, UUID> {

}

