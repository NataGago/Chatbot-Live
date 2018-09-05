package model;

public class PalavraChave {
	private int id;
	private String palavraChave;

	public PalavraChave(int id, String palavraChave) {
		super();
		this.id = id;
		this.palavraChave = palavraChave;
	}

	public PalavraChave() {
		super();
	}

	public String getPalavraChave() {
		return palavraChave;
	}

	public void setPalavraChave(String palavraChave) {
		this.palavraChave = palavraChave;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

