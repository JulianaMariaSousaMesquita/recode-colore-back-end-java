package com.herokuapp.colorebackend.Colore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.colorebackend.Colore.models.Formacao;
import com.herokuapp.colorebackend.Colore.repositories.FormacaoRepository;

@RestController
@RequestMapping(value="/Formacao")
public class FormacaoController {
private FormacaoRepository formacaoRepository;
	
	public FormacaoController(FormacaoRepository formacaoRepository) {
		super();
		this.formacaoRepository = formacaoRepository;
	}
	
	@PostMapping
	public ResponseEntity<Formacao> save(@RequestBody Formacao formacao){
		formacaoRepository.save(formacao);
		return new ResponseEntity<>(formacao, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Formacao>> getAll(){
		List<Formacao> formacaos = new ArrayList<>();
		formacaos = formacaoRepository.findAll();
		return new ResponseEntity<>(formacaos, HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Optional<Formacao>> getById(@PathVariable Integer id){
		Optional<Formacao> formacao;
		try {
			formacao = formacaoRepository.findById(id);
			return new ResponseEntity<Optional<Formacao>>(formacao, HttpStatus.OK);
		}catch(NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Formacao>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Optional<Formacao>> deleteById(@PathVariable Integer id){
		try {
			formacaoRepository.deleteById(id);
			return new ResponseEntity<Optional<Formacao>>(HttpStatus.OK);
		}catch(NoSuchElementException nsee){
			return new ResponseEntity<Optional<Formacao>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Formacao> update(@PathVariable Integer id, @RequestBody Formacao newFormacao){
		return formacaoRepository.findById(id)
			   .map(formacao -> {
				   formacao.setTitulo(newFormacao.getTitulo());
				   formacao.setNivel(newFormacao.getNivel());
				   formacao.setInstituicao(newFormacao.getInstituicao());
				   formacao.setDataInicio(newFormacao.getDataInicio());
				   formacao.setDataFim(newFormacao.getDataFim());
				   formacao.setCaminhoImagemDiploma(newFormacao.getCaminhoImagemDiploma());
				   Formacao formacaoUpdate = formacaoRepository.save(formacao);
				   return ResponseEntity.ok().body(formacaoUpdate);
			   }).orElse(ResponseEntity.notFound().build());
	}
}
