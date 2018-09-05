package service;
import java.io.IOException;
import java.util.ArrayList;

import dao.PerguntaDao;
import model.Pergunta;


public class PerguntaService {
	
	PerguntaDao dao = new PerguntaDao();
	
	public int criar(Pergunta pergunta) throws IOException{
		return dao.criar(pergunta);
	}
	public int ligarAtendimento(int atendimento, Pergunta pergunta) throws IOException{
		return dao.ligarAtendimento(atendimento, pergunta);
	}
	
	public void atualizar(Pergunta pergunta) throws IOException{
		dao.atualizar(pergunta);
	}
	
	public void excluir(int id) throws IOException{
		dao.excluir(id);
	}
	public ArrayList<Pergunta> listarPorAtendimento(int atendimento) throws IOException {
		return dao.listarPorAtendimento(atendimento);
	}
	
	public Pergunta carregar(int id) throws IOException{
		return dao.carregar(id);
	}
}
