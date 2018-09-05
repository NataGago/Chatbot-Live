package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Atendimento;
import model.Historico;

public class HistoricoDao {
	
	public int criar( Historico historico) throws IOException {
		String sqlInsert = "INSERT INTO historico(texto, pessoa,hora, historico_atendimento_id, user) VALUES (?, ?, ?, ?, ?)";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
				stm.setString(1, historico.getTexto());
				stm.setString(2, historico.getPessoa());
				stm.setTimestamp(3, historico.getHora());
				stm.setInt(4, historico.getFkAtendimento());
				stm.setInt(5, historico.getUser());
				stm.execute();
				String sqlQuery = "SELECT LAST_INSERT_ID()";
				try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
						ResultSet rs = stm2.executeQuery();) {
					if (rs.next()) {
						historico.setId(rs.getInt(1));
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new IOException();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new IOException();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new IOException();
		}
		return historico.getId();
	}
	public ArrayList<Historico> exibirConversa(int atendimento) throws IOException {
		Historico historico = null;
		ArrayList<Historico> conversa = new ArrayList<>();
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "Select  historico.id, historico.texto, historico.pessoa, historico.hora, historico.user from historico\r\n" + 
					" inner join atendimento \r\n" + 
					" on atendimento.id = historico_atendimento_id and atendimento.id = ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, atendimento);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						historico = new Historico();
						historico.setId(rs.getInt("historico.id"));
						historico.setTexto(rs.getString("historico.texto"));
						historico.setPessoa(rs.getString("historico.pessoa"));
						historico.setHora(rs.getTimestamp("historico.hora"));
						historico.setUser(rs.getInt("historico.user"));
						conversa.add(historico);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new IOException();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new IOException();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new IOException();
		}
		return conversa;
	}
}
