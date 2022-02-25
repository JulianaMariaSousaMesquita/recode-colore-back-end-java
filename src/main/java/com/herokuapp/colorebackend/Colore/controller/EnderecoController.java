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

import com.herokuapp.colorebackend.Colore.models.Endereco;
import com.herokuapp.colorebackend.Colore.repositories.EnderecoRepository;

@RestController
@RequestMapping(value="/Endereco")
public class EnderecoController {
private EnderecoRepository enderecoRepository;
	
	public EnderecoController() {
		super();
		this.enderecoRepository = enderecoRepository;
	}
	
	@PostMapping
	public ResponseEntity<Endereco> save(@RequestBody Endereco endereco){
		enderecoRepository.save(endereco);
		return new ResponseEntity<>(endereco, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Endereco>> getAll(){
		List<Endereco> enderecos = new ArrayList<>();
		enderecos = enderecoRepository.findAll();
		return new ResponseEntity<>(enderecos, HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Optional<Endereco>> getById(@PathVariable Integer id){
		Optional<Endereco> endereco;
		try {
			endereco = enderecoRepository.findById(id);
			return new ResponseEntity<Optional<Endereco>>(endereco, HttpStatus.OK);
		}catch(NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Endereco>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Optional<Endereco>> deleteById(@PathVariable Integer id){
		try {
			enderecoRepository.deleteById(id);
			return new ResponseEntity<Optional<Endereco>>(HttpStatus.OK);
		}catch(NoSuchElementException nsee){
			return new ResponseEntity<Optional<Endereco>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Endereco> update(@PathVariable Integer id, @RequestBody Endereco newEndereco){
		return enderecoRepository.findById(id)
			   .map(endereco -> {
				   endereco.setCep(newEndereco.getCep());
				   endereco.setRua(newEndereco.getRua());
				   endereco.setNumero(newEndereco.getNumero());
				   endereco.setComplemento(newEndereco.getComplemento());
				   endereco.setBairro(newEndereco.getBairro());
				   endereco.setCidade(newEndereco.getCidade());
				   endereco.setUf(newEndereco.getUf());
				   endereco.setPais(newEndereco.getPais());				   
				   Endereco enderecoUpdate = enderecoRepository.save(endereco);
				   return ResponseEntity.ok().body(enderecoUpdate);
			   }).orElse(ResponseEntity.notFound().build());
	}
}
