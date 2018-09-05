package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Resposta;
import model.RespostaPalavraChave;

public class RespostaDao {
	public int criar(Resposta resposta) throws IOException {
		String sqlInsert = "INSERT INTO Resposta(resposta) VALUES (?)";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
				stm.setString(1, resposta.getResposta());
				stm.execute();
				String sqlQuery = "SELECT LAST_INSERT_ID()";
				try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
						ResultSet rs = stm2.executeQuery();) {
					if (rs.next()) {
						resposta.setId(rs.getInt(1));
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
		return resposta.getId();
	}
	public int ligarAtendimento(int atendimento, Resposta resposta) throws IOException {
		String sqlInsert = "insert ignore into `atendimento_has_resposta`(`atendimento_id`,`resposta_id`) VALUES(?,?)";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
				stm.setInt(1, atendimento);
				stm.setInt(2, resposta.getId());
				stm.execute();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new IOException();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new IOException();
		}
		return resposta.getId();
	}
	
	public void atualizar(Resposta resposta) throws IOException {
		String sqlUpdate = "UPDATE Resposta SET resposta=? WHERE id=?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setString(1, resposta.getResposta());
				stm.setInt(2, resposta.getId());
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
	
	public Resposta carregar(int id) throws IOException {
		Resposta resposta = new Resposta();
		resposta.setId(id);
		String sqlSelect = "SELECT resposta FROM Resposta WHERE id = ?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, resposta.getId());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						resposta.setResposta(rs.getString("resposta"));
					} else {
						resposta.setId(-1);
						resposta.setResposta(null);
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
		return resposta;
	}
	public Resposta responder(int idPalavraChave) throws IOException {
		Resposta resposta = new Resposta();
		String sqlSelect = "Select  resposta.id, resposta.resposta from Resposta\r\n" + 
				" inner join palavraChave_has_Resposta \r\n" + 
				" on palavraChave_has_Resposta.resposta_id = Resposta.id\r\n" + 
				" inner join palavraChave \r\n" + 
				" on palavraChave_has_Resposta.resposta_id = palavrachave.id\r\n" + 
				" where palavraChave_has_Resposta.palavraChave_id = ? and"
				+ " palavraChave_has_Resposta.pontuacao = (select max(pontuacao)"
				+ " from palavraChave_has_Resposta  where palavraChave_has_Resposta.palavraChave_id = ?)";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, idPalavraChave);
				stm.setInt(2, idPalavraChave);
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						resposta.setId(rs.getInt("resposta.id"));
						resposta.setResposta(rs.getString("resposta.resposta"));
					} else {
						resposta.setId(-1);
						resposta.setResposta(null);
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
		return resposta;
	}
	
	public ArrayList<Resposta> listarTodas() throws IOException {
		Resposta resposta;
		ArrayList<Resposta> respostas = new ArrayList<>();
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT id, resposta FROM Resposta";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						resposta = new Resposta();
						resposta.setId(rs.getInt("id"));
						resposta.setResposta(rs.getString("resposta"));
						respostas.add(resposta);
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
		return respostas;
	}
	public ArrayList<Resposta> listarPorAtendimento(int atendimento) throws IOException {
		Resposta resposta;
		ArrayList<Resposta> respostas = new ArrayList<>();
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = " Select  resposta.id, resposta.resposta from Resposta\r\n" + 
					" inner join atendimento_has_resposta \r\n" + 
					" on atendimento_has_resposta.resposta_id = Resposta.id\r\n" + 
					" inner join atendimento \r\n" + 
					" on atendimento_has_resposta.atendimento_id = atendimento.id\r\n" + 
					" where Atendimento_has_Resposta.atendimento_id = ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, atendimento);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						resposta = new Resposta();
						resposta.setId(rs.getInt("id"));
						resposta.setResposta(rs.getString("resposta"));
						respostas.add(resposta);
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
		return respostas;
	}
	public void adicionaPontuacao(RespostaPalavraChave ligacao ) throws IOException {
		String sqlUpdate = "UPDATE palavraChave_has_Resposta SET pontuacao=? WHERE palavraChave_id=? and resposta_id=?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setInt(1, ligacao.getPontuacao() + 1);
				stm.setInt(2, ligacao.getPalavraChaveId());
				stm.setInt(3, ligacao.getRespostaId());
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
	
}