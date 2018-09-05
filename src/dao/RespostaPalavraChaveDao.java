package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.RespostaPalavraChave;

public class RespostaPalavraChaveDao {
	public RespostaPalavraChave carregar(int palavraChaveId,int respostaId) throws IOException {
		RespostaPalavraChave ligacao = new RespostaPalavraChave();
		ligacao.setPalavraChaveId(palavraChaveId);
		ligacao.setRespostaId(respostaId);
		String sqlSelect = "SELECT pontuacao FROM palavraChave_has_Resposta WHERE palavraChave_id=? and resposta_id=?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, ligacao.getPalavraChaveId());
				stm.setInt(2, ligacao.getRespostaId());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						ligacao.setPontuacao(rs.getInt("pontuacao"));
					} else {
						ligacao.setPalavraChaveId(-1);
						ligacao.setRespostaId(-1);
						ligacao.setPontuacao(-1);
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
		return ligacao;
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
	public void subtraiPontuacao(RespostaPalavraChave ligacao ) throws IOException {
		String sqlUpdate = "UPDATE palavraChave_has_Resposta SET pontuacao=? WHERE palavraChave_id=? and resposta_id=?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setInt(1, ligacao.getPontuacao() - 1);
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
