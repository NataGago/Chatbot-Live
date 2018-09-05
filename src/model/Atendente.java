package model;

import java.io.Serializable;

public class Atendente implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private String nascimento;
	private String rg;
	private String ra;
	private String estado;
	private String cidade;
	private String cep;
	private String email;
	private String login;
	private String senha;

	public Atendente() {

	}

	public Atendente(int id, String nome, String nascimento, String rg, String ra, String estado, String cidade, String cep, String email, String login, String senha) {
		this.setId(id);
		this.setNome(nome);
		this.setNascimento(nascimento);
		this.setRg(rg);
		this.setRa(ra);
		this.setEstado(estado);
		this.setCidade(cidade);
		this.setCep(cep);
		this.setEmail(email);
		this.setLogin(login);
		this.setSenha(senha);
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

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

		public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/*@Override
	public String toString() {
		return "Atendente [id=" + id + ", nome=" + nome;
	}
	*/
}
