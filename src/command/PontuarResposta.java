package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Atendimento;
import model.PalavraChave;
import model.Resposta;
import model.RespostaPalavraChave;
import service.AtendimentoService;
import service.RespostaPalavraChaveService;

public class PontuarResposta implements Command{
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Atendimento atendimento = new Atendimento();
		atendimento = (Atendimento) request.getSession().getAttribute("atendimento");
		AtendimentoService as = new AtendimentoService();
		PalavraChave palavraChave = new PalavraChave();
		Resposta resposta = new Resposta();
		RespostaPalavraChave ligacao = new RespostaPalavraChave();
		RespostaPalavraChaveService rpcs = new RespostaPalavraChaveService();
		palavraChave = (PalavraChave) request.getSession().getAttribute("palavraChave");
		resposta = (Resposta) request.getSession().getAttribute("resposta");
		
		ligacao = rpcs.carregar(palavraChave.getId(), resposta.getId());
		
		as.adicionarAcerto(atendimento);
		atendimento = as.carregar(atendimento.getId());
		rpcs.adicionaPontuacao(ligacao);
		HttpSession session = request.getSession();
		session.setAttribute("atendimento", atendimento);
		
		response.sendRedirect("ChatBot.jsp");
	}

}
