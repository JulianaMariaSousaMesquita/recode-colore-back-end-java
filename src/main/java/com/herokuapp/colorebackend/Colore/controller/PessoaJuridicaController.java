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

import com.herokuapp.colorebackend.Colore.models.PessoaJuridica;
import com.herokuapp.colorebackend.Colore.repository.PessoaJuridicaRepository;
@CrossOrigin(origins = "https://colore-front-end.herokuapp.com/PessoaJuridica")
@RestController
@RequestMapping(value="/PessoaJuridica")
public class PessoaJuridicaController {
	
	private PessoaJuridicaRepository pessoaJuridicaRepository;
	
	public PessoaJuridicaController(PessoaJuridicaRepository pessoaJuridicaRepository) {
		super();
		this.pessoaJuridicaRepository = pessoaJuridicaRepository;
	}
	
	@PostMapping
	public ResponseEntity<PessoaJuridica> save(@RequestBody PessoaJuridica pessoaJuridica){
		pessoaJuridicaRepository.save(pessoaJuridica);
		return new ResponseEntity<>(pessoaJuridica, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<PessoaJuridica>> getAll(){
		List<PessoaJuridica> pessoaJuridicas = new ArrayList<>();
		pessoaJuridicas = pessoaJuridicaRepository.findAll();
		return new ResponseEntity<>(pessoaJuridicas, HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Optional<PessoaJuridica>> getById(@PathVariable Integer id){
		Optional<PessoaJuridica> pessoaJuridica;
		try {
			pessoaJuridica = pessoaJuridicaRepository.findById(id);
			return new ResponseEntity<Optional<PessoaJuridica>>(pessoaJuridica, HttpStatus.OK);
		}catch(NoSuchElementException nsee) {
			return new ResponseEntity<Optional<PessoaJuridica>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Optional<PessoaJuridica>> deleteById(@PathVariable Integer id){
		try {
			pessoaJuridicaRepository.deleteById(id);
			return new ResponseEntity<Optional<PessoaJuridica>>(HttpStatus.OK);
		}catch(NoSuchElementException nsee){
			return new ResponseEntity<Optional<PessoaJuridica>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<PessoaJuridica> update(@PathVariable Integer id, @RequestBody PessoaJuridica newPessoaJuridica){
		return pessoaJuridicaRepository.findById(id)
			   .map(pessoaJuridica -> {
				   pessoaJuridica.setEmail(newPessoaJuridica.getEmail());
				   pessoaJuridica.setSenha(newPessoaJuridica.getSenha());
				   pessoaJuridica.setCaminhoImagem(newPessoaJuridica.getCaminhoImagem());
				   pessoaJuridica.setTitulo(newPessoaJuridica.getTitulo());
				   pessoaJuridica.setTelefone(newPessoaJuridica.getTelefone());
				   pessoaJuridica.setCnpj(newPessoaJuridica.getCnpj());
				   pessoaJuridica.setEndereco(newPessoaJuridica.getEndereco());
				   pessoaJuridica.setVagas(newPessoaJuridica.getVagas());
				   PessoaJuridica pessoaJuridicaUpdate = pessoaJuridicaRepository.save(pessoaJuridica);
				   return ResponseEntity.ok().body(pessoaJuridicaUpdate);
			   }).orElse(ResponseEntity.notFound().build());
	}
}
