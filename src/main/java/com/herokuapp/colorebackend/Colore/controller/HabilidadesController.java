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

import com.herokuapp.colorebackend.Colore.models.Habilidades;
import com.herokuapp.colorebackend.Colore.repository.HabilidadesRepository;
@CrossOrigin(origins = "https://colore-front-end.herokuapp.com")
@RestController
@RequestMapping(value="/Habilidades")
public class HabilidadesController {
private HabilidadesRepository habilidadesRepository;
	
	public HabilidadesController(HabilidadesRepository habilidadesRepository) {
		super();
		this.habilidadesRepository = habilidadesRepository;
	}
	
	@PostMapping
	public ResponseEntity<Habilidades> save(@RequestBody Habilidades habilidades){
		habilidadesRepository.save(habilidades);
		return new ResponseEntity<>(habilidades, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Habilidades>> getAll(){
		List<Habilidades> habilidadess = new ArrayList<>();
		habilidadess = habilidadesRepository.findAll();
		return new ResponseEntity<>(habilidadess, HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Optional<Habilidades>> getById(@PathVariable Integer id){
		Optional<Habilidades> habilidades;
		try {
			habilidades = habilidadesRepository.findById(id);
			return new ResponseEntity<Optional<Habilidades>>(habilidades, HttpStatus.OK);
		}catch(NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Habilidades>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Optional<Habilidades>> deleteById(@PathVariable Integer id){
		try {
			habilidadesRepository.deleteById(id);
			return new ResponseEntity<Optional<Habilidades>>(HttpStatus.OK);
		}catch(NoSuchElementException nsee){
			return new ResponseEntity<Optional<Habilidades>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Habilidades> update(@PathVariable Integer id, @RequestBody Habilidades newHabilidades){
		return habilidadesRepository.findById(id)
			   .map(habilidades -> {
				   habilidades.setTipo(newHabilidades.getTipo());
				   habilidades.setNome(newHabilidades.getNome());
				   habilidades.setNivel(newHabilidades.getNivel());
				   habilidades.setTempo(newHabilidades.getTempo());
				   habilidades.setCaminhoImagemComprovante(newHabilidades.getCaminhoImagemComprovante());
				   Habilidades habilidadesUpdate = habilidadesRepository.save(habilidades);
				   return ResponseEntity.ok().body(habilidadesUpdate);
			   }).orElse(ResponseEntity.notFound().build());
	}
}
