package com.herokuapp.colorebackend.Colore.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import org.springframework.data.annotation.Id;

@Entity
@Table
public class PessoaFisica extends Pessoa{
	@GeneratedValue
	@Id
	private int id;
	@Column(nullable = false)
	private Curriculo curriculo;
	private List<Vaga> vagas;
	
	public PessoaFisica() {
		super();
	}

	public PessoaFisica(int id, Curriculo curriculo, List<Vaga> vagas) {
		super();
		this.id = id;
		this.curriculo = curriculo;
		this.vagas = vagas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

	public List<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(curriculo, id, vagas);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaFisica other = (PessoaFisica) obj;
		return Objects.equals(curriculo, other.curriculo) && id == other.id && Objects.equals(vagas, other.vagas);
	}

	@Override
	public String toString() {
		return "PessoaFisica [id=" + id + ", curriculo=" + curriculo + ", vagas=" + vagas + "]";
	}
	
}
