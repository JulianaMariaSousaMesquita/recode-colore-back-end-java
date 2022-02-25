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

import com.herokuapp.colorebackend.Colore.models.Requisitos;
import com.herokuapp.colorebackend.Colore.repositories.RequisitosRepository;

@RestController
@RequestMapping(value="/Requisitos")
public class RequisitosController {
private RequisitosRepository requisitosRepository;
	
	public RequisitosController(RequisitosRepository requisitosRepository) {
		super();
		this.requisitosRepository = requisitosRepository;
	}
	
	@PostMapping
	public ResponseEntity<Requisitos> save(@RequestBody Requisitos requisitos){
		requisitosRepository.save(requisitos);
		return new ResponseEntity<>(requisitos, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Requisitos>> getAll(){
		List<Requisitos> requisitoss = new ArrayList<>();
		requisitoss = requisitosRepository.findAll();
		return new ResponseEntity<>(requisitoss, HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Optional<Requisitos>> getById(@PathVariable Integer id){
		Optional<Requisitos> requisitos;
		try {
			requisitos = requisitosRepository.findById(id);
			return new ResponseEntity<Optional<Requisitos>>(requisitos, HttpStatus.OK);
		}catch(NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Requisitos>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Optional<Requisitos>> deleteById(@PathVariable Integer id){
		try {
			requisitosRepository.deleteById(id);
			return new ResponseEntity<Optional<Requisitos>>(HttpStatus.OK);
		}catch(NoSuchElementException nsee){
			return new ResponseEntity<Optional<Requisitos>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Requisitos> update(@PathVariable Integer id, @RequestBody Requisitos newRequisitos){
		return requisitosRepository.findById(id)
			   .map(requisitos -> {
				   requisitos.setAreaAtuacao(newRequisitos.getAreaAtuacao());
				   requisitos.setCargo(newRequisitos.getCargo());
				   requisitos.setTempoExperiencia(newRequisitos.getTempoExperiencia());
				   requisitos.setEscolaridade(newRequisitos.getEscolaridade());
				   requisitos.setHabilidades(newRequisitos.getHabilidades());
				   Requisitos requisitosUpdate = requisitosRepository.save(requisitos);
				   return ResponseEntity.ok().body(requisitosUpdate);
			   }).orElse(ResponseEntity.notFound().build());
	}
}
