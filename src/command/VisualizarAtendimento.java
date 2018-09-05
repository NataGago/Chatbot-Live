package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Atendimento;
import model.Pergunta;
import model.Resposta;
import service.AtendimentoService;
import service.HistoricoService;
import service.PerguntaService;
import service.RespostaService;

public class VisualizarAtendimento implements Command {
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		int idAtendimento = -1;
		try {
			 idAtendimento = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}
		ArrayList<Resposta> respostas = null;
		ArrayList<Pergunta> perguntas = null;
		Atendimento atendimento = new Atendimento();
		AtendimentoService ats = new AtendimentoService();
		PerguntaService ps = new PerguntaService();
		RespostaService rs = new RespostaService();
		HistoricoService hs = new HistoricoService();
		
		atendimento = ats.carregar(idAtendimento) ;
		
		perguntas = ps.listarPorAtendimento(atendimento.getId());
		respostas = rs.listarPorAtendimento(atendimento.getId());
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		session.setAttribute("conversa", hs);
		session.setAttribute("atendimento", atendimento);
		session.setAttribute("respostas", respostas);
		session.setAttribute("perguntas", perguntas);
		view = request.getRequestDispatcher("ChatAtendente.jsp");

		view.forward(request, response);
	}
}
