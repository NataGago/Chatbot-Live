package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Atendente;
import service.AtendenteService;

public class FazerLogin implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		Atendente atendente = new Atendente();
		atendente.setEmail(email);
		atendente.setSenha(senha);
		AtendenteService service = new AtendenteService();

		if (service.validar(atendente)) {
			atendente = service.carregarEmail(atendente);
			HttpSession session = request.getSession();
			session.setAttribute("logado", atendente);
			session.setAttribute("atendente", atendente);
			System.out.println("Logou " + atendente);
		} else {
			System.out.println("Não Logou " + atendente);
			throw new ServletException("Usuário/Senha inválidos");
		}
		response.sendRedirect("Atendente.jsp");
		
		
	}

}
