package com.herokuapp.colorebackend.Colore.models;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table
public class Habilidades {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String tipo;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String nivel;
	private String tempo;
	private String caminhoImagemComprovante;
	
	public Habilidades() {
		super();
	}

	public Habilidades(String tipo, String nome, String nivel, String tempo, String caminhoImagemComprovante) {
		super();
		this.tipo = tipo;
		this.nome = nome;
		this.nivel = nivel;
		this.tempo = tempo;
		this.caminhoImagemComprovante = caminhoImagemComprovante;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public String getCaminhoImagemComprovante() {
		return caminhoImagemComprovante;
	}

	public void setCaminhoImagemComprovante(String caminhoImagemComprovante) {
		this.caminhoImagemComprovante = caminhoImagemComprovante;
	}

	@Override
	public int hashCode() {
		return Objects.hash(caminhoImagemComprovante, id, nivel, nome, tempo, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Habilidades other = (Habilidades) obj;
		return Objects.equals(caminhoImagemComprovante, other.caminhoImagemComprovante) && id == other.id
				&& Objects.equals(nivel, other.nivel) && Objects.equals(nome, other.nome)
				&& Objects.equals(tempo, other.tempo) && Objects.equals(tipo, other.tipo);
	}

	@Override
	public String toString() {
		return "Habilidades [id=" + id + ", tipo=" + tipo + ", nome=" + nome + ", nivel=" + nivel + ", tempo=" + tempo
				+ ", caminhoImagemComprovante=" + caminhoImagemComprovante + "]";
	}
	
	
}
