package service;

import java.io.IOException;

import model.Cliente;
import dao.ClienteDao;

public class ClienteService {
	ClienteDao dao = new ClienteDao();

	public int criar(Cliente cliente) throws IOException {
		return dao.criar(cliente);
	}

	public void atualizar(Cliente cliente) throws IOException {
		dao.atualizar(cliente);
	}

	public void excluir(int id) throws IOException {
		dao.excluir(id);
	}

	public Cliente carregar(int id) throws IOException {
		return dao.carregar(id);
	}
}
