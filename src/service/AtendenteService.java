package service;

import java.io.IOException;

import model.Atendente;
import dao.AtendenteDao;

public class AtendenteService {
	AtendenteDao dao = new AtendenteDao();

	public int criar(Atendente atendente) throws IOException {
		return dao.criar(atendente);
	}

	public void atualizar(Atendente atendente) throws IOException {
		dao.atualizar(atendente);
	}

	public void excluir(int id) throws IOException {
		dao.excluir(id);
	}
	
	public Atendente carregar(int id) throws IOException {
		return dao.carregar(id);
	}
	
	public Atendente carregarEmail(Atendente atendente) throws IOException {
		return dao.carregarEmail(atendente);
	}
	
	public boolean validar(Atendente atendente){
		AtendenteDao dao = new AtendenteDao();
		return dao.validar(atendente);
	}
}