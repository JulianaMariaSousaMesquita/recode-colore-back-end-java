package com.herokuapp.colorebackend.Colore.models;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import org.springframework.data.annotation.Id;

@Entity
@Table
public class PessoaJuridica extends Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String titulo;
	@Column(nullable = false)
	private String telefone;
	@Column(nullable = false)
	private String cnpj;
	@Column(nullable = false)
	private Endereco endereco;
	private List<Vaga> vagas;
	
	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String titulo, String telefone, String cnpj, Endereco endereco, List<Vaga> vagas) {
		super();
		this.titulo = titulo;
		this.telefone = telefone;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.vagas = vagas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
		result = prime * result + Objects.hash(cnpj, endereco, id, telefone, titulo, vagas);
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
		PessoaJuridica other = (PessoaJuridica) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(endereco, other.endereco) && id == other.id
				&& Objects.equals(telefone, other.telefone) && Objects.equals(titulo, other.titulo)
				&& Objects.equals(vagas, other.vagas);
	}

	@Override
	public String toString() {
		return "PessoaJuridica [id=" + id + ", titulo=" + titulo + ", telefone=" + telefone + ", cnpj=" + cnpj
				+ ", endereco=" + endereco + ", vagas=" + vagas + "]";
	}	
	
}
