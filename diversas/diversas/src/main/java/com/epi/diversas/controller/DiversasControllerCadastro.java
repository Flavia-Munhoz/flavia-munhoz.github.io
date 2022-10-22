package com.epi.diversas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epi.diversas.model.DiversasCadastroModel;
import com.epi.diversas.repositories.DiversasRepositoryCadastro;
import com.epi.diversas.services.CadastroService;

@RestController
@CrossOrigin(origins = "http://localhost:3306")
@RequestMapping("/cadastro")
public class DiversasControllerCadastro {
	
	
	final CadastroService cadastroService;
	
	public DiversasControllerCadastro(CadastroService cadastroService ) {
		this.cadastroService = new CadastroService();
	}
	



}
