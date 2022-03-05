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

import com.herokuapp.colorebackend.Colore.models.PessoaFisica;
import com.herokuapp.colorebackend.Colore.repository.PessoaFisicaRepository;
@CrossOrigin(origins = "https://colore-front-end.herokuapp.com/PessoaFisica")
@RestController
@RequestMapping(value="/PessoaFisica")
public class PessoaFisicaController {
private PessoaFisicaRepository pessoaFisicaRepository;
	
	public PessoaFisicaController(PessoaFisicaRepository pessoaFisicaRepository) {
		super();
		this.pessoaFisicaRepository = pessoaFisicaRepository;
	}
	
	@PostMapping
	public ResponseEntity<PessoaFisica> save(@RequestBody PessoaFisica pessoaFisica){
		pessoaFisicaRepository.save(pessoaFisica);
		return new ResponseEntity<>(pessoaFisica, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<PessoaFisica>> getAll(){
		List<PessoaFisica> pessoaFisicas = new ArrayList<>();
		pessoaFisicas = pessoaFisicaRepository.findAll();
		return new ResponseEntity<>(pessoaFisicas, HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Optional<PessoaFisica>> getById(@PathVariable Integer id){
		Optional<PessoaFisica> pessoaFisica;
		try {
			pessoaFisica = pessoaFisicaRepository.findById(id);
			return new ResponseEntity<Optional<PessoaFisica>>(pessoaFisica, HttpStatus.OK);
		}catch(NoSuchElementException nsee) {
			return new ResponseEntity<Optional<PessoaFisica>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Optional<PessoaFisica>> deleteById(@PathVariable Integer id){
		try {
			pessoaFisicaRepository.deleteById(id);
			return new ResponseEntity<Optional<PessoaFisica>>(HttpStatus.OK);
		}catch(NoSuchElementException nsee){
			return new ResponseEntity<Optional<PessoaFisica>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<PessoaFisica> update(@PathVariable Integer id, @RequestBody PessoaFisica newPessoaFisica){
		return pessoaFisicaRepository.findById(id)
			   .map(pessoaFisica -> {
				   pessoaFisica.setEmail(newPessoaFisica.getEmail());
				   pessoaFisica.setSenha(newPessoaFisica.getSenha());
				   pessoaFisica.setCaminhoImagem(newPessoaFisica.getCaminhoImagem());
				   pessoaFisica.setCurriculo(newPessoaFisica.getCurriculo());
				   pessoaFisica.setVagas(newPessoaFisica.getVagas());
				   PessoaFisica pessoaFisicaUpdate = pessoaFisicaRepository.save(pessoaFisica);
				   return ResponseEntity.ok().body(pessoaFisicaUpdate);
			   }).orElse(ResponseEntity.notFound().build());
	}
}
