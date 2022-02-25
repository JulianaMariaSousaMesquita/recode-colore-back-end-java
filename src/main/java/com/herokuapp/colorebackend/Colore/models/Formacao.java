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
public class Formacao {
	@GeneratedValue
	@Id
	private int id;
	private String titulo;
	@Column(nullable = false)
	private String nivel;
	private String instituicao;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private String caminhoImagemDiploma;
	
	public Formacao() {
		super();
	}

	public Formacao(int id, String titulo, String nivel, String instituicao, LocalDate dataInicio, LocalDate dataFim,
			String caminhoImagemDiploma) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.nivel = nivel;
		this.instituicao = instituicao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.caminhoImagemDiploma = caminhoImagemDiploma;
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

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
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

	public String getCaminhoImagemDiploma() {
		return caminhoImagemDiploma;
	}

	public void setCaminhoImagemDiploma(String caminhoImagemDiploma) {
		this.caminhoImagemDiploma = caminhoImagemDiploma;
	}

	@Override
	public int hashCode() {
		return Objects.hash(caminhoImagemDiploma, dataFim, dataInicio, id, instituicao, nivel, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formacao other = (Formacao) obj;
		return Objects.equals(caminhoImagemDiploma, other.caminhoImagemDiploma)
				&& Objects.equals(dataFim, other.dataFim) && Objects.equals(dataInicio, other.dataInicio)
				&& id == other.id && Objects.equals(instituicao, other.instituicao)
				&& Objects.equals(nivel, other.nivel) && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Formacao [id=" + id + ", titulo=" + titulo + ", nivel=" + nivel + ", instituicao=" + instituicao
				+ ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", caminhoImagemDiploma="
				+ caminhoImagemDiploma + "]";
	}	
	
}