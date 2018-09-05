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

public class NegarResposta implements Command{
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Atendimento atendimento = new Atendimento();
		atendimento = (Atendimento) request.getSession().getAttribute("atendimento");
		AtendimentoService as = new AtendimentoService();
		int contador;
		PalavraChave palavraChave = new PalavraChave();
		Resposta resposta = new Resposta();
		RespostaPalavraChave ligacao = new RespostaPalavraChave();
		RespostaPalavraChaveService rpcs = new RespostaPalavraChaveService();
		palavraChave = (PalavraChave) request.getSession().getAttribute("palavraChave");
		resposta = (Resposta) request.getSession().getAttribute("resposta");
		contador = (int) request.getSession().getAttribute("contador");
		ligacao = rpcs.carregar(palavraChave.getId(), resposta.getId());
		
		HttpSession session = request.getSession();
		
			as.adicionarErro(atendimento);
			rpcs.subtraiPontuacao(ligacao);
			atendimento = as.carregar(atendimento.getId());
			session.setAttribute("atendimento", atendimento);
		
		if(contador < 3) {
			contador = contador + 1;
			session.setAttribute("contador", contador);
			response.sendRedirect("ChatBot.jsp");
		}else {
			session.removeAttribute("contador");
			response.sendRedirect("LiveChat.jsp");
		}
	}

}
