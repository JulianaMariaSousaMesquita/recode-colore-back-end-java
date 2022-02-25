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

import com.herokuapp.colorebackend.Colore.models.Pessoa;
import com.herokuapp.colorebackend.Colore.repositories.PessoaRepository;

@RestController
@RequestMapping(value="/Pessoa")
public class PessoaController {
private PessoaRepository pessoaRepository;
	
	public PessoaController(PessoaRepository pessoaRepository) {
		super();
		this.pessoaRepository = pessoaRepository;
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa){
		pessoaRepository.save(pessoa);
		return new ResponseEntity<>(pessoa, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> getAll(){
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas = pessoaRepository.findAll();
		return new ResponseEntity<>(pessoas, HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Optional<Pessoa>> getById(@PathVariable Integer id){
		Optional<Pessoa> pessoa;
		try {
			pessoa = pessoaRepository.findById(id);
			return new ResponseEntity<Optional<Pessoa>>(pessoa, HttpStatus.OK);
		}catch(NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Pessoa>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Optional<Pessoa>> deleteById(@PathVariable Integer id){
		try {
			pessoaRepository.deleteById(id);
			return new ResponseEntity<Optional<Pessoa>>(HttpStatus.OK);
		}catch(NoSuchElementException nsee){
			return new ResponseEntity<Optional<Pessoa>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable Integer id, @RequestBody Pessoa newPessoa){
		return pessoaRepository.findById(id)
			   .map(pessoa -> {
				   pessoa.setEmail(newPessoa.getEmail());
				   pessoa.setSenha(newPessoa.getEmail());
				   pessoa.setCaminhoImagem(newPessoa.getCaminhoImagem());
				   Pessoa pessoaUpdate = pessoaRepository.save(pessoa);
				   return ResponseEntity.ok().body(pessoaUpdate);
			   }).orElse(ResponseEntity.notFound().build());
	}
}
