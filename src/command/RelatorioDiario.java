package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Atendimento;
import service.AtendimentoService;

public class RelatorioDiario implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int totalAtendimentos, falhas, acertos, res1, res2, res3,atendimentosHumanos, interacoes;
		AtendimentoService as = new AtendimentoService();
		ArrayList<Atendimento> atendimentos = new ArrayList<Atendimento>();
		
		totalAtendimentos = as.totalAtendimentosDiarios();
		falhas = as.relatarFalhasDiarios();
		acertos = as.relatarAcertosSDiarios();
		res1 = as.atendimentosResolvidosFirstDiarios();
		res2 = as.atendimentosResolvidosSecondDiarios();
		res3 = as.atendimentosResolvidosThirdDiarios();
		atendimentosHumanos = as.atendimentosHumanosDiarios();
		interacoes = as.totalInteracoesDiarios();
		atendimentos = as.listarAtendimentosDiarios();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("totalAtendimentos", totalAtendimentos);
		session.setAttribute("falhas", falhas);
		session.setAttribute("acertos", acertos);
		session.setAttribute("res1", res1);
		session.setAttribute("res2", res2);	
		session.setAttribute("res3", res3);
		session.setAttribute("atendimentosHumanos", atendimentosHumanos);	
		session.setAttribute("interacoes", interacoes);
		session.setAttribute("atendimentos", atendimentos);
		response.sendRedirect("Diario.jsp");

	}

}
