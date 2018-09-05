package service;

import java.io.IOException;

import dao.PalavraChaveDao;
import model.PalavraChave;
import java.util.ArrayList;

public class PalavraChaveService {
	PalavraChaveDao dao = new PalavraChaveDao();
	
	public int criar(PalavraChave palavraChave) throws IOException {
		return dao.criar(palavraChave);
	}
	
	public void atualizar(PalavraChave palavraChave) throws IOException {
		dao.atualizar(palavraChave);
	}
	
	public void excluir(int id) throws IOException {
		dao.excluir(id);
	}
	
	public PalavraChave carregar(int id) throws IOException {
		return dao.carregar(id);
	}
	public ArrayList<PalavraChave> listarTodos() throws IOException {
		return dao.listarTodas();
		
	}
	public PalavraChave achaPalavraChave(String pergunta) throws IOException {
		ArrayList<PalavraChave> todas = dao.listarTodas();
		String quebra[] = new String[20];
		quebra = pergunta.split(" ");
		for(PalavraChave array: todas) {
			for(int i = 0;i<quebra.length;i++) {
				if(array.getPalavraChave().equals(quebra[i])) {
					return array;
				}
			}
			
		}
		return null;
	}	
}
