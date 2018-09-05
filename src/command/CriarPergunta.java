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

public class CriarPergunta implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pPergunta = request.getParameter("pergunta");
		String pAtendimentoId = request.getParameter("atendimentoId");
		int id = -1;
		int atendimentoId = -1;
		try {
			id = Integer.parseInt(pId);
			atendimentoId = Integer.parseInt(pAtendimentoId);
		} catch (NumberFormatException e) {

		}

		Pergunta pergunta = new Pergunta();
		pergunta.setId(id);
		pergunta.setPergunta(pPergunta);
		PerguntaService cs = new PerguntaService();

		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		cs.criar(pergunta);
		cs.ligarAtendimento(atendimentoId, pergunta);
		ArrayList<Pergunta> lista = new ArrayList<>();
		lista.add(pergunta);
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarPerguntas.jsp");

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
