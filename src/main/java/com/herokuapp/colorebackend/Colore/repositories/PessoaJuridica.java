package com.herokuapp.colorebackend.Colore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.herokuapp.colorebackend.Colore.models.PessoaFisica;

public interface PessoaJuridica extends JpaRepository<PessoaFisica, Integer>{

}
