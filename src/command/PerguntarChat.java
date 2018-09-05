package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Atendimento;
import model.Cliente;
import model.Historico;
import model.Pergunta;
import model.Resposta;
import service.HistoricoService;
import service.PerguntaService;
import service.RespostaService;

public class PerguntarChat implements Command{
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Atendimento atendimento = new Atendimento();
		Cliente cliente = new Cliente();
		java.sql.Timestamp t = new java.sql.Timestamp(System.currentTimeMillis());
		
		atendimento = (Atendimento) request.getSession().getAttribute("atendimento");
		cliente = (Cliente) request.getSession().getAttribute("cliente");
		String pPergunta = request.getParameter("pergunta");
		ArrayList<Resposta> respostas = null;
		ArrayList<Pergunta> perguntas = null;
		PerguntaService ps = new PerguntaService();
		Pergunta pergunta = new Pergunta();
		Historico historico = new Historico();
		HistoricoService hs = new HistoricoService();
		
		historico.setTexto(pPergunta);
		historico.setPessoa(cliente.getNome());
		historico.setHora(t);
		historico.setFkAtendimento(atendimento.getId());
		historico.setUser(1);
		hs.criar(historico);
		
		pergunta.setPergunta(pPergunta);
		RespostaService rs = new RespostaService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		pergunta.setId(ps.criar(pergunta));
		ps.ligarAtendimento(atendimento.getId(), pergunta);
		
		perguntas = ps.listarPorAtendimento(atendimento.getId());
		respostas = rs.listarPorAtendimento(atendimento.getId());
		
		session.setAttribute("pergunta", pergunta);
		session.setAttribute("respostas", respostas);
		session.setAttribute("perguntas", perguntas);
		
		response.sendRedirect("LiveChat.jsp");
	}
}
