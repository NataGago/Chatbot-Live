package model;

import java.io.Serializable;


public class Atendimento implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private java.sql.Timestamp dataCriacao;
	private boolean aberto;
	private int clienteId;
	private int acertosBot;
	private int errosBot;
	
	public Atendimento() {
		
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public java.sql.Timestamp getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(java.sql.Timestamp dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public boolean isAberto() {
		return aberto;
	}
	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}
	
	public int getClienteId() {
		return clienteId;
	}
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
	public int getAcertosBot() {
		return acertosBot;
	}
	public void setAcertosBot(int acertosBot) {
		this.acertosBot = acertosBot;
	}
	public int getErrosBot() {
		return errosBot;
	}
	public void setErrosBot(int errosBot) {
		this.errosBot = errosBot;
	}
	@Override
	public String toString() {
		return "Atendimento [id=" + id + ", dataCriacao=" + dataCriacao + ", aberto=" + aberto + ", acertosBot="
				+ acertosBot + ", errosBot=" + errosBot + "]";
	}
	
	
}
