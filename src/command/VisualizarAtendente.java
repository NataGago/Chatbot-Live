package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Atendente;
import service.AtendenteService;

public class VisualizarAtendente implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pNascimento = request.getParameter("nascimento");
		String pRg = request.getParameter("rg");
		String pRa = request.getParameter("ra");
		String pEstado = request.getParameter("estado");
		String pCidade = request.getParameter("cidade");
		String pCep = request.getParameter("cep");
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}

		Atendente atendente = new Atendente();
		atendente.setId(id);
		atendente.setNome(pNome);
		atendente.setNascimento(pNascimento);
		atendente.setRg(pRg);
		atendente.setRa(pRa);
		atendente.setEstado(pEstado);
		atendente.setCidade(pCidade);
		atendente.setCep(pCep);
		atendente.setEmail(pEmail);
		atendente.setSenha(pSenha);
		AtendenteService cs = new AtendenteService();
		
		RequestDispatcher view = null;
		
		atendente = cs.carregar(atendente.getId());
		request.setAttribute("atendente", atendente);
		view = request.getRequestDispatcher("Atendente.jsp");		
		response.sendRedirect("Atendente.jsp");
		//view.forward(request, response);

	}

}
