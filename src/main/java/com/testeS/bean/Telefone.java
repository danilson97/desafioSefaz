package com.testeS.bean;

public class Telefone {
	private int id;
	private String fone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	@Override
	public String toString() {
		return "Telefone [id=" + id + ", fone=" + fone + "]";
	}
	
}
