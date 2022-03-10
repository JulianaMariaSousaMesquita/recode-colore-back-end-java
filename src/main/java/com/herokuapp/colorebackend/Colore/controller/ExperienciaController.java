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
import com.herokuapp.colorebackend.Colore.models.Experiencia;
import com.herokuapp.colorebackend.Colore.repository.ExperienciaRepository;
@CrossOrigin(origins = "https://colore-front-end.herokuapp.com")
@RestController
@RequestMapping(value="/Experiencia")
public class ExperienciaController {
	private ExperienciaRepository experienciaRepository;
	
	public ExperienciaController(ExperienciaRepository experienciaRepository) {
		super();
		this.experienciaRepository = experienciaRepository;
	}
	
	@PostMapping
	public ResponseEntity<Experiencia> save(@RequestBody Experiencia experiencia){
		experienciaRepository.save(experiencia);
		return new ResponseEntity<>(experiencia, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Experiencia>> getAll(){
		List<Experiencia> experiencias = new ArrayList<>();
		experiencias = experienciaRepository.findAll();
		return new ResponseEntity<>(experiencias, HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Optional<Experiencia>> getById(@PathVariable Integer id){
		Optional<Experiencia> experiencia;
		try {
			experiencia = experienciaRepository.findById(id);
			return new ResponseEntity<Optional<Experiencia>>(experiencia, HttpStatus.OK);
		}catch(NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Experiencia>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Optional<Experiencia>> deleteById(@PathVariable Integer id){
		try {
			experienciaRepository.deleteById(id);
			return new ResponseEntity<Optional<Experiencia>>(HttpStatus.OK);
		}catch(NoSuchElementException nsee){
			return new ResponseEntity<Optional<Experiencia>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Experiencia> update(@PathVariable Integer id, @RequestBody Experiencia newExperiencia){
		return experienciaRepository.findById(id)
			   .map(experiencia -> {
				   experiencia.setTitulo(newExperiencia.getTitulo());
				   experiencia.setCargo(newExperiencia.getCargo());
				   experiencia.setEmpresa(newExperiencia.getEmpresa());
				   experiencia.setDataInicio(newExperiencia.getDataInicio());
				   experiencia.setDataFim(newExperiencia.getDataFim());
				   experiencia.setDescricaoAtividades(newExperiencia.getDescricaoAtividades());
				   Experiencia experienciaUpdate = experienciaRepository.save(experiencia);
				   return ResponseEntity.ok().body(experienciaUpdate);
			   }).orElse(ResponseEntity.notFound().build());
	}
}
