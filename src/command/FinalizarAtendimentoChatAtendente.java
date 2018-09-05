package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Atendimento;
import service.AtendimentoService;

public class FinalizarAtendimentoChatAtendente implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Atendimento atendimento = new Atendimento();
		atendimento = (Atendimento) request.getSession().getAttribute("atendimento");
		AtendimentoService as = new AtendimentoService();
		atendimento.setAberto(false);
		as.atualizar(atendimento);
		HttpSession session = request.getSession();
		session.removeAttribute("atendimento");
		response.sendRedirect("ListarAtendimento.jsp");	
	}

}
