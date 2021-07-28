package com.testeS.bean;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private int id;
	private String nome;
	private String password;
	private String email;

	private List<Telefone> fones = new ArrayList<Telefone>();
	private String telefone;

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Telefone> getFones() {
		return fones;
	}

	public void setFones(List<Telefone> fones) {
		this.fones = fones;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", password=" + password + ", email=" + email + ", fones="
				+ fones + "]";
	}


}