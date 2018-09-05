package model;

public class RespostaPalavraChave {
	private int palavraChaveId;
	private int RespostaId;
	private int pontuacao;
	public RespostaPalavraChave(int palavraChaveId, int respostaId, int pontuacao) {
		super();
		this.palavraChaveId = palavraChaveId;
		RespostaId = respostaId;
		this.pontuacao = pontuacao;
	}
	
	public RespostaPalavraChave(int palavraChaveId, int respostaId) {
		super();
		this.palavraChaveId = palavraChaveId;
		RespostaId = respostaId;
	}
	public RespostaPalavraChave() {
		super();
	}

	public int getPalavraChaveId() {
		return palavraChaveId;
	}
	public void setPalavraChaveId(int palavraChaveId) {
		this.palavraChaveId = palavraChaveId;
	}
	public int getRespostaId() {
		return RespostaId;
	}
	public void setRespostaId(int respostaId) {
		RespostaId = respostaId;
	}
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
}
