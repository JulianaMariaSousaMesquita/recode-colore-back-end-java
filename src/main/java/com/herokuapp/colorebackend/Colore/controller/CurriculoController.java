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
import com.herokuapp.colorebackend.Colore.models.Curriculo;
import com.herokuapp.colorebackend.Colore.repositories.CurriculoRepository;

@RestController
@RequestMapping(value="/Curriculo")
public class CurriculoController {
	private CurriculoRepository curriculoRepository;
	
	public CurriculoController() {
		super();
		this.curriculoRepository = curriculoRepository;
	}
	
	@PostMapping
	public ResponseEntity<Curriculo> save(@RequestBody Curriculo curriculo){
		curriculoRepository.save(curriculo);
		return new ResponseEntity<>(curriculo, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Curriculo>> getAll(){
		List<Curriculo> curriculos = new ArrayList<>();
		curriculos = curriculoRepository.findAll();
		return new ResponseEntity<>(curriculos, HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Optional<Curriculo>> getById(@PathVariable Integer id){
		Optional<Curriculo> curriculo;
		try {
			curriculo = curriculoRepository.findById(id);
			return new ResponseEntity<Optional<Curriculo>>(curriculo, HttpStatus.OK);
		}catch(NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Curriculo>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Optional<Curriculo>> deleteById(@PathVariable Integer id){
		try {
			curriculoRepository.deleteById(id);
			return new ResponseEntity<Optional<Curriculo>>(HttpStatus.OK);
		}catch(NoSuchElementException nsee){
			return new ResponseEntity<Optional<Curriculo>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Curriculo> update(@PathVariable Integer id, @RequestBody Curriculo newCurriculo){
		return curriculoRepository.findById(id)
			   .map(curriculo -> {
				   curriculo.setNome(newCurriculo.getNome());
				   curriculo.setSobrenome(newCurriculo.getSobrenome());
				   curriculo.setNomeSocial(newCurriculo.getNomeSocial());
				   curriculo.setOrientacaoSexual(newCurriculo.getOrientacaoSexual());
				   curriculo.setIdentidadeGenero(newCurriculo.getIdentidadeGenero());
				   curriculo.setTelefone(newCurriculo.getTelefone());
				   curriculo.setCpf(newCurriculo.getCpf());
				   curriculo.setRg(newCurriculo.getRg());
				   curriculo.setDataNascimento(newCurriculo.getDataNascimento());
				   curriculo.setEndereco(newCurriculo.getEndereco());
				   curriculo.setFormacao(newCurriculo.getFormacao());
				   curriculo.setExperiencia(newCurriculo.getExperiencia());
				   curriculo.setHabilidades(newCurriculo.getHabilidades());
				   Curriculo curriculoUpdate = curriculoRepository.save(curriculo);
				   return ResponseEntity.ok().body(curriculoUpdate);
			   }).orElse(ResponseEntity.notFound().build());
	}
}
