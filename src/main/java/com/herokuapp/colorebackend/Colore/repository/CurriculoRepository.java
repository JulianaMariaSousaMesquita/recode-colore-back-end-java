package com.herokuapp.colorebackend.Colore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.herokuapp.colorebackend.Colore.models.Curriculo;

@Repository
public interface CurriculoRepository extends JpaRepository<Curriculo, Integer>{

}

