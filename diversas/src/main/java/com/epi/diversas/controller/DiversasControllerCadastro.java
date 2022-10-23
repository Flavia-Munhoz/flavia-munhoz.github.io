package com.epi.diversas.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epi.diversas.dtos.DiversasDtoCadastro;
import com.epi.diversas.model.DiversasCadastroModel;
import com.epi.diversas.services.CadastroService;

@RestController
@CrossOrigin(origins = "http://localhost:3306")
@RequestMapping("/cadastro")
public class DiversasControllerCadastro {
	
	
	final CadastroService cadastroService;
	
	public DiversasControllerCadastro(CadastroService cadastroService ) {
	this.cadastroService = cadastroService;
	}
	
	@PostMapping
	 public ResponseEntity<Object>saveCadastro(@RequestBody @Valid DiversasDtoCadastro diversasDtoCadastro ){
		
		if(cadastroService.existsByEmail(diversasDtoCadastro.getEmail())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Email ja esta em uso!");
		}
		if(cadastroService.existsByCpf(diversasDtoCadastro.getCpf())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Cpf ja esta em uso!");
		}
		
		var diversasCadastroModel = new DiversasCadastroModel();
		BeanUtils.copyProperties(diversasDtoCadastro,diversasCadastroModel);
		diversasCadastroModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTF")));
		return ResponseEntity.status(HttpStatus.CREATED).body(cadastroService.save(diversasCadastroModel));
	
	}
   
	@GetMapping
	public ResponseEntity<List<DiversasCadastroModel>> getAllCadastro(){
		return ResponseEntity.status(HttpStatus.OK).body(cadastroService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object>getOneCadastro(@PathVariable(value = "id")UUID id){
		Optional<DiversasCadastroModel>diversasCadastroModelOptional = cadastroService.findById(id);
	    if(!diversasCadastroModelOptional.isPresent()) {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado!");
	    }
	    return ResponseEntity.status(HttpStatus.OK).body(diversasCadastroModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object>deleteCadastro(@PathVariable(value = "id")UUID id){
		Optional<DiversasCadastroModel>diversasCadastroModelOptional = cadastroService.findById(id);
		 if(!diversasCadastroModelOptional.isPresent()){
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado!");
		 }
		 cadastroService.delete(diversasCadastroModelOptional.get());
		 return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
	}
	
	@PutMapping
	public ResponseEntity<Object>updateCadastro(@PathVariable(value = "id")UUID id, @RequestBody @Valid DiversasDtoCadastro diversasDtoCadastro){
		Optional<DiversasCadastroModel> diversasCadastroModelOptional = cadastroService.findById(id);
		if(!diversasCadastroModelOptional.isPresent()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado!");
		}
		var diversasCadastroModel = diversasCadastroModelOptional.get();
		
		diversasCadastroModel.setNome(diversasDtoCadastro.getNome());
		diversasCadastroModel.setEmail(diversasDtoCadastro.getEmail());
		diversasCadastroModel.setSenha(diversasDtoCadastro.getSenha());
		diversasCadastroModel.setCpf(diversasDtoCadastro.getCpf());
		
		return ResponseEntity.status(HttpStatus.OK).body(diversasCadastroModel);
	}
	


}
