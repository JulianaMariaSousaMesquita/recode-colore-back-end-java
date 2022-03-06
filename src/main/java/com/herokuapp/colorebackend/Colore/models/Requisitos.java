package com.herokuapp.colorebackend.Colore.models;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@Table(name = "requisitos")
public class Requisitos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String areaAtuacao;
	@Column(nullable = false)
	private String cargo;
	@Column(nullable = false)
	private int tempoExperiencia;
	@Column(nullable = false)
	private String escolaridade;
	@OneToMany
	@JoinColumn(name = "habilidades_id") 
	private List<Habilidades> habilidades;
	
	public Requisitos() {
		super();
	}

	public Requisitos(String areaAtuacao, String cargo, int tempoExperiencia, String escolaridade,
			List<Habilidades> habilidades) {
		super();
		this.areaAtuacao = areaAtuacao;
		this.cargo = cargo;
		this.tempoExperiencia = tempoExperiencia;
		this.escolaridade = escolaridade;
		this.habilidades = habilidades;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getTempoExperiencia() {
		return tempoExperiencia;
	}

	public void setTempoExperiencia(int tempoExperiencia) {
		this.tempoExperiencia = tempoExperiencia;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public List<Habilidades> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(List<Habilidades> habilidades) {
		this.habilidades = habilidades;
	}

	@Override
	public int hashCode() {
		return Objects.hash(areaAtuacao, cargo, escolaridade, habilidades, id, tempoExperiencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Requisitos other = (Requisitos) obj;
		return Objects.equals(areaAtuacao, other.areaAtuacao) && Objects.equals(cargo, other.cargo)
				&& Objects.equals(escolaridade, other.escolaridade) && Objects.equals(habilidades, other.habilidades)
				&& id == other.id && tempoExperiencia == other.tempoExperiencia;
	}

	@Override
	public String toString() {
		return "Requisitos [id=" + id + ", areaAtuacao=" + areaAtuacao + ", cargo=" + cargo + ", tempoExperiencia="
				+ tempoExperiencia + ", escolaridade=" + escolaridade + ", habilidades=" + habilidades + "]";
	}	
	
}