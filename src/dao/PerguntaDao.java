package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Pergunta;

public class PerguntaDao {
	public int criar(Pergunta pergunta) throws IOException {
		String sqlInsert = "INSERT INTO Pergunta(pergunta) VALUES (?)";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
				stm.setString(1, pergunta.getPergunta());
				stm.execute();
				String sqlQuery = "SELECT LAST_INSERT_ID()";
				try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
						ResultSet rs = stm2.executeQuery();) {
					if (rs.next()) {
						pergunta.setId(rs.getInt(1));
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
		return pergunta.getId();
	}
	public int ligarAtendimento(int atendimento, Pergunta pergunta) throws IOException {
		String sqlInsert = "insert into `atendimento_has_Pergunta`(`atendimento_id`,`pergunta_id`) VALUES(?,?)";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
				stm.setInt(1, atendimento);
				stm.setInt(2, pergunta.getId());
				stm.execute();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new IOException();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new IOException();
		}
		return pergunta.getId();
	}
	public void atualizar(Pergunta pergunta) throws IOException {
		String sqlUpdate = "UPDATE Pergunta SET pergunta=? WHERE id=?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setString(1, pergunta.getPergunta());
				stm.setInt(2, pergunta.getId());
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
				throw new IOException();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new IOException();
		}
	}
	
	public void excluir(int id) throws IOException {
		String sqlDelete = "DELETE FROM cliente WHERE id = ?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
				stm.setInt(1, id);
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
				throw new IOException();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new IOException();
		}
	}
	
	public Pergunta carregar(int id) throws IOException {
		Pergunta pergunta = new Pergunta();
		pergunta.setId(id);
		String sqlSelect = "SELECT pergunta FROM Pergunta WHERE id = ?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, pergunta.getId());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						pergunta.setPergunta(rs.getString("pergunta"));
					} else {
						pergunta.setId(-1);
						pergunta.setPergunta(null);
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
		return pergunta;
	}
	public ArrayList<Pergunta> listarPorAtendimento(int atendimento) throws IOException {
		Pergunta pergunta;
		ArrayList<Pergunta> perguntas = new ArrayList<>();
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect =   "Select  pergunta.id, pergunta.pergunta from pergunta\r\n" +
					" inner join atendimento_has_pergunta\r\n" +
					 "on atendimento_has_pergunta.pergunta_id = pergunta.id\r\n" +
					 "inner join atendimento\r\n " +
					" on atendimento_has_pergunta.atendimento_id = atendimento.id\r\n" +
					" where Atendimento_has_pergunta.atendimento_id = ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, atendimento);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						pergunta = new Pergunta();
						pergunta.setId(rs.getInt("pergunta.id"));
						pergunta.setPergunta(rs.getString("pergunta.pergunta"));
						perguntas.add(pergunta);
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
		return perguntas;
	}
}