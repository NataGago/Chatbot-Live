package model;

import java.sql.Timestamp;

public class Historico {
	private int id;
	private String texto;
	private String pessoa;
	private java.sql.Timestamp hora;
	private int fkAtendimento;
	private int user;
	
	public Historico(int id, String texto, String pessoa, Timestamp hora, int fkAtendimento, int user) {
		super();
		this.id = id;
		this.texto = texto;
		this.pessoa = pessoa;
		this.hora = hora;
		this.fkAtendimento = fkAtendimento;
	}

	public Historico() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getFkAtendimento() {
		return fkAtendimento;
	}
	public void setFkAtendimento(int fkAtendimento) {
		this.fkAtendimento = fkAtendimento;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getPessoa() {
		return pessoa;
	}

	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}

	public java.sql.Timestamp getHora() {
		return hora;
	}

	public void setHora(java.sql.Timestamp hora) {
		this.hora = hora;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}
	
	
}
