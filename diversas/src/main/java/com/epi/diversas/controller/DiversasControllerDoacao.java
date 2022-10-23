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

import com.epi.diversas.dtos.DiversasDtoDoacao;
import com.epi.diversas.model.DiversasDoacaoModel;
import com.epi.diversas.services.DoacaoService;

@RestController
@CrossOrigin(origins = "http://localhost:3306")
@RequestMapping("/Doacao")
public class DiversasControllerDoacao {
	
	 
	 
	final DoacaoService doacaoService;

	public DiversasControllerDoacao(DoacaoService doacaoService) {
		 this. doacaoService =  doacaoService;
	 }
	 
	 @PostMapping
	 public ResponseEntity<Object> saveDoacao(@RequestBody @Valid DiversasDtoDoacao diversasDtoDoacao ){
		 var diversasDoacaoModel = new  DiversasDoacaoModel();
		 BeanUtils.copyProperties(diversasDtoDoacao, diversasDoacaoModel);
		 diversasDoacaoModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTF")));
		 return ResponseEntity.status(HttpStatus.CREATED).body(doacaoService.save(diversasDoacaoModel));
	 }
	 
	 @GetMapping
	 public ResponseEntity<List<DiversasDoacaoModel>> getAllDoacao(){
		 return ResponseEntity.status(HttpStatus.OK).body(doacaoService.findAll());
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<Object>getOneDoacao(@PathVariable(value = "id")UUID idDoa){
		 Optional<DiversasDoacaoModel>diversasDoacaoModelOptional = doacaoService.findById(idDoa);
	     if(!diversasDoacaoModelOptional.isPresent()) {
	    	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao encontrado"); 
	     }
	     return ResponseEntity.status(HttpStatus.OK).body(diversasDoacaoModelOptional.get());
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Object> deleteDoacao(@PathVariable(value = "id")UUID idDoa){
		 Optional<DiversasDoacaoModel>diversasDoacaoModelOptional = doacaoService.findById(idDoa);
		 if(!diversasDoacaoModelOptional.isPresent()) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao encontrado"); 
		 }
		 doacaoService.delete(diversasDoacaoModelOptional.get());
		 return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
	 }
	 
	 @PutMapping
	 public ResponseEntity<Object>updateDoacao(@PathVariable(value = "id")UUID idDoa, @RequestBody @Valid DiversasDtoDoacao diversasDtoDoacao ){
		 Optional<DiversasDoacaoModel>	diversasDoacaoModelOptional = doacaoService.findById(idDoa);
		 if(!diversasDoacaoModelOptional.isPresent()){
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado"); 
		 }
		 
		 var diversasDoacaoModel = diversasDoacaoModelOptional.get();
		 
		 diversasDoacaoModel.setTipoDoacao(diversasDtoDoacao.getTipoDoacao());
		 diversasDoacaoModel.setNome(diversasDtoDoacao.getNome());
		 diversasDoacaoModel.setEmail(diversasDtoDoacao.getEmail());
		 diversasDoacaoModel.setMensagem(diversasDtoDoacao.getMensagem());
		 
		 return ResponseEntity.status(HttpStatus.OK).body( doacaoService.save( diversasDoacaoModel));
	 }

}
