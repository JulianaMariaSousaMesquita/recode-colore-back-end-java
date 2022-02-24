package com.herokuapp.colorebackend.Colore.models;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import org.springframework.data.annotation.Id;

@Entity
@Table
public class Experiencia {
	@GeneratedValue
	@Id
	private int id;
	@Column(nullable = false)
	private String titulo;
	@Column(nullable = false)
	private String cargo;
	@Column(nullable = false)
	private String empresa;	
	@Column(nullable = false)
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private String descricaoAtividades;
	
	public Experiencia() {
		super();
	}

	public Experiencia(int id, String titulo, String cargo, String empresa, LocalDate dataInicio, LocalDate dataFim,
			String descricaoAtividades) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.cargo = cargo;
		this.empresa = empresa;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.descricaoAtividades = descricaoAtividades;
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public String getDescricaoAtividades() {
		return descricaoAtividades;
	}

	public void setDescricaoAtividades(String descricaoAtividades) {
		this.descricaoAtividades = descricaoAtividades;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cargo, dataFim, dataInicio, descricaoAtividades, empresa, id, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Experiencia other = (Experiencia) obj;
		return Objects.equals(cargo, other.cargo) && Objects.equals(dataFim, other.dataFim)
				&& Objects.equals(dataInicio, other.dataInicio)
				&& Objects.equals(descricaoAtividades, other.descricaoAtividades)
				&& Objects.equals(empresa, other.empresa) && id == other.id && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Experiencia [id=" + id + ", titulo=" + titulo + ", cargo=" + cargo + ", empresa=" + empresa
				+ ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", descricaoAtividades=" + descricaoAtividades
				+ "]";
	}
	
}
