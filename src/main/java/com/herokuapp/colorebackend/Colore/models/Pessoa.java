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
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String senha;
	private String caminhoImagem;
	
	public Pessoa() {
		super();
	}

	public Pessoa(String email, String senha, String caminhoImagem) {
		super();
		this.email = email;
		this.senha = senha;
		this.caminhoImagem = caminhoImagem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(caminhoImagem, email, id, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(caminhoImagem, other.caminhoImagem) && Objects.equals(email, other.email)
				&& id == other.id && Objects.equals(senha, other.senha);
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", email=" + email + ", senha=" + senha + ", caminhoImagem=" + caminhoImagem + "]";
	}	
	
	
}
