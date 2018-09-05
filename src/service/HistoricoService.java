package service;

import java.io.IOException;
import java.util.ArrayList;

import dao.HistoricoDao;
import model.Historico;

public class HistoricoService {
	HistoricoDao dao = new HistoricoDao();
	

	public int criar(Historico historico) throws IOException {
		return dao.criar(historico);
	}
	
	public ArrayList<Historico> exibirConversa(int atendimento) throws IOException {
		return dao.exibirConversa(atendimento);
	}
}
