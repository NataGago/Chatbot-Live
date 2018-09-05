package service;

import java.io.IOException;

import dao.RespostaPalavraChaveDao;
import model.RespostaPalavraChave;

public class RespostaPalavraChaveService {
	RespostaPalavraChaveDao dao = new RespostaPalavraChaveDao();
	
	public RespostaPalavraChave carregar(int palavraChaveId,int respostaId) throws IOException {
		return dao.carregar(palavraChaveId,respostaId);
	}
	public void adicionaPontuacao(RespostaPalavraChave ligacao) throws IOException {
		dao.adicionaPontuacao(ligacao);
	}
	public void subtraiPontuacao(RespostaPalavraChave ligacao) throws IOException {
		dao.subtraiPontuacao(ligacao);
	}
	
}
