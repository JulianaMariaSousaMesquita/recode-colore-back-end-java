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
public class Curriculo {
	@GeneratedValue
	@Id
	private int id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String sobrenome;
	private String nomeSocial;
	@Column(nullable = false)
	private String orientacaoSexual;
	@Column(nullable = false)
	private String identidadeGenero;
	@Column(nullable = false)
	private String telefone;
	@Column(nullable = false)
	private String cpf;
	@Column(nullable = false)
	private String rg;
	@Column(nullable = false)
	private LocalDate dataNascimento;
	@Column(nullable = false)
	private Endereco endereco;
	@Column(nullable = false)
	private Formacao formacao;
	@Column(nullable = false)
	private Experiencia experiencia;
	@Column(nullable = false)
	private Habilidades habilidades;
	
	public Curriculo() {
		super();
	}
	public Curriculo(int id, String nome, String sobrenome, String nomeSocial, String orientacaoSexual,
			String identidadeGenero, String telefone, String cpf, String rg, LocalDate dataNascimento,
			Endereco endereco, Formacao formacao, Experiencia experiencia, Habilidades habilidades) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nomeSocial = nomeSocial;
		this.orientacaoSexual = orientacaoSexual;
		this.identidadeGenero = identidadeGenero;
		this.telefone = telefone;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.formacao = formacao;
		this.experiencia = experiencia;
		this.habilidades = habilidades;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getNomeSocial() {
		return nomeSocial;
	}
	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}
	public String getOrientacaoSexual() {
		return orientacaoSexual;
	}
	public void setOrientacaoSexual(String orientacaoSexual) {
		this.orientacaoSexual = orientacaoSexual;
	}
	public String getIdentidadeGenero() {
		return identidadeGenero;
	}
	public void setIdentidadeGenero(String identidadeGenero) {
		this.identidadeGenero = identidadeGenero;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Formacao getFormacao() {
		return formacao;
	}
	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}
	public Experiencia getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(Experiencia experiencia) {
		this.experiencia = experiencia;
	}
	public Habilidades getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(Habilidades habilidades) {
		this.habilidades = habilidades;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cpf, dataNascimento, endereco, experiencia, formacao, habilidades, id, identidadeGenero,
				nome, nomeSocial, orientacaoSexual, rg, sobrenome, telefone);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curriculo other = (Curriculo) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(dataNascimento, other.dataNascimento)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(experiencia, other.experiencia)
				&& Objects.equals(formacao, other.formacao) && Objects.equals(habilidades, other.habilidades)
				&& id == other.id && Objects.equals(identidadeGenero, other.identidadeGenero)
				&& Objects.equals(nome, other.nome) && Objects.equals(nomeSocial, other.nomeSocial)
				&& Objects.equals(orientacaoSexual, other.orientacaoSexual) && Objects.equals(rg, other.rg)
				&& Objects.equals(sobrenome, other.sobrenome) && Objects.equals(telefone, other.telefone);
	}
	@Override
	public String toString() {
		return "Curriculo [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", nomeSocial=" + nomeSocial
				+ ", orientacaoSexual=" + orientacaoSexual + ", identidadeGenero=" + identidadeGenero + ", telefone="
				+ telefone + ", cpf=" + cpf + ", rg=" + rg + ", dataNascimento=" + dataNascimento + ", endereco="
				+ endereco + ", formacao=" + formacao + ", experiencia=" + experiencia + ", habilidades=" + habilidades
				+ "]";
	}	
	
}
