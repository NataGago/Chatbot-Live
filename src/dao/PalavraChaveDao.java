package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.PalavraChave;

public class PalavraChaveDao {
	public int criar(PalavraChave palavraChave) throws IOException {
		String sqlInsert = "INSERT INTO palavraChave(palavrachave) VALUES (?)";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
				stm.setString(1, palavraChave.getPalavraChave());
				stm.execute();
				String sqlQuery = "SELECT LAST_INSERT_ID()";
				try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
						ResultSet rs = stm2.executeQuery();) {
					if (rs.next()) {
						palavraChave.setId(rs.getInt(1));
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
		return palavraChave.getId();
	}
	
	public void atualizar(PalavraChave palavraChave) throws IOException {
		String sqlUpdate = "UPDATE palavraChave SET palavrachave=? WHERE id=?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setString(1, palavraChave.getPalavraChave());
				stm.setInt(2, palavraChave.getId());
				stm.execute();;
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
	
	public PalavraChave carregar(int id) throws IOException {
		PalavraChave palavraChave = new PalavraChave();
		palavraChave.setId(id);
		String sqlSelect = "SELECT palavrachave FROM palavraChave WHERE palavraChave.id = ?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, palavraChave.getId());;
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						palavraChave.setPalavraChave(rs.getString("PalavraChave"));
					} else {
						palavraChave.setId(-1);
						palavraChave.setPalavraChave(null);
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
		return palavraChave;
	}
	
	public ArrayList<PalavraChave> listarTodas() throws IOException {
		PalavraChave palavraChave;
		ArrayList<PalavraChave> palavrasChaves = new ArrayList<>();
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT * FROM palavraChave";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						palavraChave = new PalavraChave();
						palavraChave.setId(rs.getInt("id"));
						palavraChave.setPalavraChave(rs.getString("palavraChave"));
						palavrasChaves.add(palavraChave);
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
		return palavrasChaves;
	}

	public ArrayList<PalavraChave> listarTodas(String chave) throws IOException {
		PalavraChave palavraChave;
		ArrayList<PalavraChave> palavrasChaves = new ArrayList<>();
		String sqlSelect = "SELECT * FROM palavraChave where upper(palavrachave) like ?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						palavraChave = new PalavraChave();
						palavraChave.setId(rs.getInt("id"));
						palavraChave.setPalavraChave(rs.getString("palavraChave"));
						palavrasChaves.add(palavraChave);
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
		return palavrasChaves;
	}
}