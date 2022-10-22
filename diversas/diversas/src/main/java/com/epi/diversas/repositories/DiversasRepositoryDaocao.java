package com.epi.diversas.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epi.diversas.model.DiversasDoacaoModel;

@Repository
public interface DiversasRepositoryDaocao extends JpaRepository<DiversasDoacaoModel, UUID> {

}
