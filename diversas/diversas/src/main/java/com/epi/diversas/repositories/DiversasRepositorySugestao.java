package com.epi.diversas.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epi.diversas.model.DiversasSugestaoModel;

public interface DiversasRepositorySugestao extends JpaRepository<DiversasSugestaoModel ,UUID > {

}
