package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Atendente;
import model.Atendimento;
import model.Historico;
import model.Pergunta;
import model.Resposta;
import service.HistoricoService;
import service.PerguntaService;
import service.RespostaService;

public class ResponderCliente implements Command{
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Atendimento atendimento = new Atendimento();
		Atendente atendente = new Atendente();
		java.sql.Timestamp t = new java.sql.Timestamp(System.currentTimeMillis());
		atendimento = (Atendimento) request.getSession().getAttribute("atendimento");
		atendente = (Atendente) request.getSession().getAttribute("logado");
		String pResposta = request.getParameter("resposta");
		ArrayList<Resposta> respostas = null;
		ArrayList<Pergunta> perguntas = null;
		PerguntaService ps = new PerguntaService();
		Resposta resposta = new Resposta();
		Historico historico = new Historico();
		HistoricoService hs = new HistoricoService();
		
		historico.setTexto(pResposta);
		historico.setPessoa("Atendente - " + atendente.getNome());
		historico.setHora(t);
		historico.setFkAtendimento(atendimento.getId());
		historico.setUser(2);
		hs.criar(historico);
		
		
		resposta.setResposta(pResposta);
		RespostaService rs = new RespostaService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		resposta.setId(rs.criar(resposta));
		rs.ligarAtendimento(atendimento.getId(), resposta);
		
		perguntas = ps.listarPorAtendimento(atendimento.getId());
		respostas = rs.listarPorAtendimento(atendimento.getId());
		
		session.setAttribute("resposta", resposta);
		session.setAttribute("respostas", respostas);
		session.setAttribute("perguntas", perguntas);
		view = request.getRequestDispatcher("ChatAtendente.jsp");
		response.sendRedirect("ChatAtendente.jsp");
		//view.forward(request, response);
	}
}
