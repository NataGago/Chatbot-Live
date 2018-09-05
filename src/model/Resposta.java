package model;

public class Resposta {
	private int id;
	private String resposta;
	public Resposta(int id, String resposta) {
		super();
		this.id = id;
		this.resposta = resposta;
	}
	public Resposta() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
}