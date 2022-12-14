package com.api.diversas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.diversas.model.SugestaoModel;
@Repository
public interface SugestaoRepository  extends CrudRepository<SugestaoModel,Long>  {

}
