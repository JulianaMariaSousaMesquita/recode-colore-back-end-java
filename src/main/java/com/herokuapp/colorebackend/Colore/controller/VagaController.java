package com.herokuapp.colorebackend.Colore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

import com.herokuapp.colorebackend.Colore.models.Vaga;
import com.herokuapp.colorebackend.Colore.repository.VagaRepository;

@CrossOrigin(origins = "http://localhost:3000/Vaga")
@RestController
@RequestMapping(value="/Vaga")
public class VagaController {
private VagaRepository vagaRepository;
	
	public VagaController(VagaRepository vagaRepository) {
		super();
		this.vagaRepository = vagaRepository;
	}
	
	@PostMapping
	public ResponseEntity<Vaga> save(@RequestBody Vaga vaga){
		vagaRepository.save(vaga);
		return new ResponseEntity<>(vaga, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Vaga>> getAll(){
		List<Vaga> vagas = new ArrayList<>();
		vagas = vagaRepository.findAll();
		return new ResponseEntity<>(vagas, HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Optional<Vaga>> getById(@PathVariable Integer id){
		Optional<Vaga> vaga;
		try {
			vaga = vagaRepository.findById(id);
			return new ResponseEntity<Optional<Vaga>>(vaga, HttpStatus.OK);
		}catch(NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Vaga>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Optional<Vaga>> deleteById(@PathVariable Integer id){
		try {
			vagaRepository.deleteById(id);
			return new ResponseEntity<Optional<Vaga>>(HttpStatus.OK);
		}catch(NoSuchElementException nsee){
			return new ResponseEntity<Optional<Vaga>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Vaga> update(@PathVariable Integer id, @RequestBody Vaga newVaga){
		return vagaRepository.findById(id)
			   .map(vaga -> {
				   vaga.setTitulo(newVaga.getTitulo());
				   vaga.setCargo(newVaga.getCargo());
				   vaga.setSalario(newVaga.getSalario());
				   vaga.setDescricao(newVaga.getDescricao());
				   vaga.setBeneficios(newVaga.getBeneficios());
				   vaga.setDataInicioInscricao(newVaga.getDataFimInscricao());
				   vaga.setDataFimInscricao(newVaga.getDataFimInscricao());
				   vaga.setFormacao(newVaga.getFormacao());
				   vaga.setRequisitos(newVaga.getRequisitos());
				   Vaga vagaUpdate = vagaRepository.save(vaga);
				   return ResponseEntity.ok().body(vagaUpdate);
			   }).orElse(ResponseEntity.notFound().build());
	}
}
