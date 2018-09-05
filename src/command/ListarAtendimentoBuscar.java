package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Atendimento;
import service.AtendimentoService;

public class ListarAtendimentoBuscar implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		AtendimentoService atendimento = new AtendimentoService();
		ArrayList<Atendimento> atendimentos = null;
		HttpSession session = request.getSession();
			atendimentos = atendimento.listarAtendimentos();
		session.setAttribute("atendimentos", atendimentos);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarAtendimento.jsp");
		dispatcher.forward(request, response);
	}
}
