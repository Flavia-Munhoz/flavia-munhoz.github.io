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

import com.epi.diversas.dtos.DiversasDtoSugestao;
import com.epi.diversas.model.DiversasSugestaoModel;
import com.epi.diversas.services.SugestaoService;

@RestController
@CrossOrigin(origins = "http://localhost:3306")
@RequestMapping("/sugestao")
public class DiversasControllerSugestao {
	
	final SugestaoService sugestaoService;
	
	public  DiversasControllerSugestao(SugestaoService sugestaoService) {
		this.sugestaoService = sugestaoService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveSugestao (@RequestBody @Valid DiversasDtoSugestao diversasDtoSugestao){
		
		var diversasSugestaoModel = new DiversasSugestaoModel();
		BeanUtils.copyProperties(diversasDtoSugestao,diversasSugestaoModel);
		diversasSugestaoModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTF")));
		return ResponseEntity.status(HttpStatus.CREATED).body(sugestaoService.save(diversasSugestaoModel));
		
	}
	
	@GetMapping
	public ResponseEntity<List<DiversasSugestaoModel>> getAllSujestao(){
		return ResponseEntity.status(HttpStatus.OK).body(sugestaoService.findAll());	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneSugestao(@PathVariable(value = "idSugest")UUID idSugest){
		Optional<DiversasSugestaoModel>	diversasSugestaoModelOptional = sugestaoService.findById(idSugest);
		if(!diversasSugestaoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(diversasSugestaoModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteSugestao (@PathVariable(value = "idSugest")UUID idSugest){
		Optional<DiversasSugestaoModel>	diversasSugestaoModelOptional = sugestaoService.findById(idSugest);	
		if(!diversasSugestaoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao encontrado");
		}
		sugestaoService.delete(diversasSugestaoModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
	}
	@PutMapping

}
