package model;


public class Pergunta {
	private int id;
	private String pergunta;
	// private double hora;
	public Pergunta(int id, String pergunta) {
		super();
		this.id = id;
		this.pergunta = pergunta;
	}

	public Pergunta() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	/*
	public double getHora() {
		return hora;
	}

	public void setHora(double hora) {
		this.hora = hora;
	}
	*/
}
