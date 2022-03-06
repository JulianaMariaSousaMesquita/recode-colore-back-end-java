package com.herokuapp.colorebackend.Colore.models;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table
public class Vaga {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String titulo;
	@Column(nullable = false)
	private String cargo;
	@Column(nullable = false)
	private double salario;
	@Column(nullable = false)
	private String descricao;
	@Column(nullable = false)
	private String beneficios;
	@Column(nullable = false)
	private LocalDate dataInicioInscricao;
	@Column(nullable = false)
	private LocalDate dataFimInscricao;
	@Column(nullable = false)
	@OneToOne
	@JoinColumn(name = "formacao_id")
	private Formacao formacao;
	@Column(nullable = false)
	@OneToOne
	@JoinColumn(name = "requisitos_id")
	private Requisitos requisitos;
	
	public Vaga() {
		super();
	}

	public Vaga(String titulo, String cargo, double salario, String descricao, String beneficios,
			LocalDate dataInicioInscricao, LocalDate dataFimInscricao, Formacao formacao, Requisitos requisitos) {
		super();
		this.titulo = titulo;
		this.cargo = cargo;
		this.salario = salario;
		this.descricao = descricao;
		this.beneficios = beneficios;
		this.dataInicioInscricao = dataInicioInscricao;
		this.dataFimInscricao = dataFimInscricao;
		this.formacao = formacao;
		this.requisitos = requisitos;
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

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

	public LocalDate getDataInicioInscricao() {
		return dataInicioInscricao;
	}

	public void setDataInicioInscricao(LocalDate dataInicioInscricao) {
		this.dataInicioInscricao = dataInicioInscricao;
	}

	public LocalDate getDataFimInscricao() {
		return dataFimInscricao;
	}

	public void setDataFimInscricao(LocalDate dataFimInscricao) {
		this.dataFimInscricao = dataFimInscricao;
	}

	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}

	public Requisitos getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(Requisitos requisitos) {
		this.requisitos = requisitos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(beneficios, cargo, dataFimInscricao, dataInicioInscricao, descricao, formacao, id,
				requisitos, salario, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vaga other = (Vaga) obj;
		return Objects.equals(beneficios, other.beneficios) && Objects.equals(cargo, other.cargo)
				&& Objects.equals(dataFimInscricao, other.dataFimInscricao)
				&& Objects.equals(dataInicioInscricao, other.dataInicioInscricao)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(formacao, other.formacao)
				&& id == other.id && Objects.equals(requisitos, other.requisitos)
				&& Double.doubleToLongBits(salario) == Double.doubleToLongBits(other.salario)
				&& Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Vaga [id=" + id + ", titulo=" + titulo + ", cargo=" + cargo + ", salario=" + salario + ", descricao="
				+ descricao + ", beneficios=" + beneficios + ", dataInicioInscricao=" + dataInicioInscricao
				+ ", dataFimInscricao=" + dataFimInscricao + ", formacao=" + formacao + ", requisitos=" + requisitos
				+ "]";
	}
	
}

