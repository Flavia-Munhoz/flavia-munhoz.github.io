package com.api.diversas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.diversas.model.UsuarioModel;
@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel,Long>   {

}
