package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Resposta;
import service.RespostaService;

public class CriarResposta implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pResposta = request.getParameter("resposta");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}

		Resposta resposta = new Resposta();
		resposta.setId(id);
		resposta.setResposta(pResposta);
		RespostaService cs = new RespostaService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		cs.criar(resposta);
		ArrayList<Resposta> lista = new ArrayList<>();
		lista.add(resposta);
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarRespostas.jsp");

		view.forward(request, response);

	}

	public int busca(Resposta resposta, ArrayList<Resposta> lista) {
		Resposta to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == resposta.getId()) {
				return i;
			}
		}
		return -1;
	}
}