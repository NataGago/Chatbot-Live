package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pergunta;
import service.PerguntaService;

public class AlterarPergunta implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pPergunta = request.getParameter("pergunta");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}

		Pergunta pergunta = new Pergunta();
		pergunta.setId(id);
		pergunta.setPergunta(pPergunta);
		PerguntaService cs = new PerguntaService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		cs.atualizar(pergunta);
		@SuppressWarnings("unchecked")
		ArrayList<Pergunta> lista = (ArrayList<Pergunta>) session.getAttribute("lista");
		int pos = busca(pergunta, lista);
		lista.remove(pos);
		lista.add(pos, pergunta);
		session.setAttribute("lista", lista);
		request.setAttribute("pergunta", pergunta);
		view = request.getRequestDispatcher("VisualizarPergunta.jsp");

		view.forward(request, response);
	}

	public int busca(Pergunta pergunta, ArrayList<Pergunta> lista) {
		Pergunta to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == pergunta.getId()) {
				return i;
			}
		}
		return -1;
	}
}