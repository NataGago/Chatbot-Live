package service;
import dao.RespostaDao;
import model.Resposta;
import model.RespostaPalavraChave;

import java.io.IOException;
import java.util.ArrayList;

public class RespostaService {
	RespostaDao dao = new RespostaDao();
	
	public int criar(Resposta resposta) throws IOException {
		return dao.criar(resposta);
	}
	public int ligarAtendimento(int atendimento, Resposta resposta) throws IOException {
		return dao.ligarAtendimento(atendimento, resposta);
	}
	public void atualizar(Resposta resposta) throws IOException {
		dao.atualizar(resposta);
	}
	
	public void excluir(int id) throws IOException {
		dao.excluir(id);
	}
	
	public Resposta carregar(int id) throws IOException {
		return dao.carregar(id);
	}
	public Resposta responder(int id) throws IOException {
		return dao.responder(id);
	}
	public ArrayList<Resposta> listarTodas() throws IOException {
		return dao.listarTodas();
	}
	public ArrayList<Resposta> listarPorAtendimento(int atendimento) throws IOException {
		return dao.listarPorAtendimento(atendimento);
	}
	
}