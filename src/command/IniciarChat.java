package command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.jmx.snmp.Timestamp;

import model.Cliente;
import model.Historico;
import model.Atendimento;
import service.ClienteService;
import service.HistoricoService;
import service.AtendimentoService;

public class IniciarChat  implements Command {
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pEmail = request.getParameter("email");
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}
		int contador = 1;
		Cliente cliente = new Cliente();
		HistoricoService conversa = new HistoricoService();
		cliente.setId(id);
		cliente.setNome(pNome);
		cliente.setEmail(pEmail);
		ClienteService cs = new ClienteService();
		Atendimento atendimento = new Atendimento();
		AtendimentoService ats = new AtendimentoService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		atendimento.setDataCriacao(c);
		atendimento.setAberto(true);
		atendimento.setAcertosBot(0);
		atendimento.setErrosBot(0);
		cs.criar(cliente);
		atendimento.setId(ats.criar(atendimento, cliente.getId()));
		ArrayList<Cliente> lista = new ArrayList<>();
		lista.add(cliente);
		session.setAttribute("cliente", cliente);
		session.setAttribute("conversa", conversa);
		session.setAttribute("lista", lista);
		session.setAttribute("atendimento", atendimento);
		session.setAttribute("atendimentoId", atendimento.getId());
		session.setAttribute("contador", contador);
		view = request.getRequestDispatcher("ChatBot.jsp");

		view.forward(request, response);

	}
}
