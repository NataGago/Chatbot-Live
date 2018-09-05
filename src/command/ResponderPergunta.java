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
import model.PalavraChave;
import model.Pergunta;
import model.Resposta;
import model.RespostaPalavraChave;
import service.PerguntaService;
import service.HistoricoService;
import service.PalavraChaveService;
import service.RespostaService;

public class ResponderPergunta implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pPergunta = request.getParameter("pergunta");
		Atendimento atendimento = new Atendimento();
		Cliente cliente = new Cliente();
		java.sql.Timestamp t = new java.sql.Timestamp(System.currentTimeMillis());
		atendimento = (Atendimento) request.getSession().getAttribute("atendimento");
		cliente = (Cliente) request.getSession().getAttribute("cliente");
		ArrayList<Resposta> respostas = null;
		ArrayList<Pergunta> perguntas = null;
		
		Pergunta pergunta = new Pergunta();
		pergunta.setPergunta(pPergunta);
		PerguntaService ps = new PerguntaService();
		RespostaService rs = new RespostaService();
		Resposta resposta = new Resposta();
		RespostaPalavraChave ligacao = new RespostaPalavraChave();
		PalavraChave palavraChave = new PalavraChave();
		PalavraChaveService pc = new PalavraChaveService();
		Historico historico = new Historico();
		Historico historicoCli = new Historico();
		HistoricoService hs = new HistoricoService();
		
		historicoCli.setTexto(pPergunta);
		historicoCli.setPessoa(cliente.getNome());
		historicoCli.setHora(t);
		historicoCli.setFkAtendimento(atendimento.getId());
		historicoCli.setUser(1);
		hs.criar(historicoCli);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
			pergunta.setId(ps.criar(pergunta));
			ps.ligarAtendimento(atendimento.getId(), pergunta);
			pergunta = ps.carregar(pergunta.getId());
			palavraChave = pc.achaPalavraChave(pergunta.getPergunta());
			if(palavraChave == null) {
				resposta= rs.responder(7);
				palavraChave = pc.carregar(7);
				rs.ligarAtendimento(atendimento.getId(), resposta);
				respostas = rs.listarPorAtendimento(atendimento.getId());
				perguntas = ps.listarPorAtendimento(atendimento.getId());
				historico.setTexto(resposta.getResposta());
				historico.setPessoa("-- CHATBOT --");
				historico.setHora(t);
				historico.setFkAtendimento(atendimento.getId());
				historico.setUser(3);
				hs.criar(historico);
			session.setAttribute("palavraChave", palavraChave);
			session.setAttribute("resposta", resposta);
			session.setAttribute("respostas", respostas);
			session.setAttribute("pergunta", pergunta);
			session.setAttribute("perguntas", perguntas);
			view = request.getRequestDispatcher("PontuarResposta.jsp");
			}else {
			resposta = rs.responder(palavraChave.getId());
			rs.ligarAtendimento(atendimento.getId(), resposta);
			respostas = rs.listarPorAtendimento(atendimento.getId());
			perguntas = ps.listarPorAtendimento(atendimento.getId());
			historico.setTexto(resposta.getResposta());
			historico.setPessoa("-- CHATBOT --");
			historico.setHora(t);
			historico.setFkAtendimento(atendimento.getId());
			historico.setUser(3);
			hs.criar(historico);
			session.setAttribute("palavraChave", palavraChave);
			session.setAttribute("resposta", resposta);
			session.setAttribute("respostas", respostas);
			session.setAttribute("pergunta", pergunta);
			session.setAttribute("perguntas", perguntas);
			view = request.getRequestDispatcher("PontuarResposta.jsp");
			}
			response.sendRedirect("PontuarResposta.jsp");
			//view.forward(request, response);
	}
}