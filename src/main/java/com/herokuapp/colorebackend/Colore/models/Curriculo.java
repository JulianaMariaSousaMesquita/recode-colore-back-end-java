package com.herokuapp.colorebackend.Colore.models;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "curriculo")
public class Curriculo {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@OneToOne
	@JoinColumn(name = "endereco_id") 
	private Endereco endereco;	
	
	@OneToMany
    @JoinColumn(name = "formacao_id")
	private List<Formacao>  formacao;	
	
	@OneToMany
    @JoinColumn(name = "experiencia_id")
	private List<Experiencia> experiencia;	
	
	@OneToMany
    @JoinColumn(name = "habilidades_id")
	private List<Habilidades> habilidades;
	
	public Curriculo() {
		super();
	}

	public Curriculo(String nome, String sobrenome, String nomeSocial, String orientacaoSexual, String identidadeGenero,
			String telefone, String cpf, String rg, LocalDate dataNascimento, Endereco endereco,
			List<Formacao> formacao, List<Experiencia> experiencia, List<Habilidades> habilidades) {
		super();
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

	public List<Formacao> getFormacao() {
		return formacao;
	}

	public void setFormacao(List<Formacao> formacao) {
		this.formacao = formacao;
	}

	public List<Experiencia> getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(List<Experiencia> experiencia) {
		this.experiencia = experiencia;
	}

	public List<Habilidades> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(List<Habilidades> habilidades) {
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
