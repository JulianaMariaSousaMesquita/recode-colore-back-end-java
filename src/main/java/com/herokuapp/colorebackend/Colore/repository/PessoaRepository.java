package com.herokuapp.colorebackend.Colore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.herokuapp.colorebackend.Colore.models.Pessoa;

public interface PessoaRepository  extends JpaRepository<Pessoa, Integer>{

}
