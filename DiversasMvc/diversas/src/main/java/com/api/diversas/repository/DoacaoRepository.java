package com.api.diversas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.diversas.model.DoacaoModel;
@Repository
public interface DoacaoRepository  extends CrudRepository<DoacaoModel,Long>  {

}
