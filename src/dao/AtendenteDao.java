package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Atendente;

public class AtendenteDao {
	public int criar(Atendente atendente) throws IOException {
		String sqlInsert = "INSERT INTO Atendente(nome, nascimento, rg, ra, estado, cidade, cep, email, login, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
				stm.setString(1, atendente.getNome());
				stm.setString(2, atendente.getNascimento());
				stm.setString(3, atendente.getRg());
				stm.setString(4, atendente.getRa());
				stm.setString(5, atendente.getEstado());
				stm.setString(6, atendente.getCidade());
				stm.setString(7, atendente.getCep());
				stm.setString(8, atendente.getEmail());
				stm.setString(9, atendente.getLogin());
				stm.setString(10, atendente.getSenha());
				stm.execute();
				String sqlQuery = "SELECT LAST_INSERT_ID()";
				try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
					if (rs.next()) {
						atendente.setId(rs.getInt(1));
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
		return atendente.getId();
	}
	
	public void atualizar(Atendente atendente) throws IOException {
		String sqlUpdate = "UPDATE Atendente SET nome=?, nascimento=?, rg=?, ra=?, estado=?, cidade=?, cep=?, email=?, login=?, senha=? WHERE id=?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setString(1, atendente.getNome());
				stm.setString(2, atendente.getNascimento());
				stm.setString(3, atendente.getRg());
				stm.setString(4, atendente.getRa());
				stm.setString(5, atendente.getEstado());
				stm.setString(6, atendente.getCidade());
				stm.setString(7, atendente.getCep());
				stm.setString(8, atendente.getEmail());
				stm.setString(9, atendente.getLogin());
				stm.setString(10, atendente.getSenha());
				stm.setInt(11, atendente.getId());
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
		String sqlDelete = "DELETE FROM Atendente WHERE id = ?";
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
	
	public Atendente carregar(int id) throws IOException {
		Atendente atendente = new Atendente();
		atendente.setId(id);
		String sqlSelect = "SELECT nome, nascimento, rg, ra, estado, cidade, cep, email, login, senha FROM Atendente WHERE Atendente.id = ?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, atendente.getId());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						atendente.setNome(rs.getString("nome"));
						atendente.setNascimento(rs.getString("nascimento"));
						atendente.setRg(rs.getString("rg"));
						atendente.setRa(rs.getString("ra"));
						atendente.setEstado(rs.getString("estado"));
						atendente.setCidade(rs.getString("cidade"));
						atendente.setCep(rs.getString("cep"));
						atendente.setEmail(rs.getString("email"));
						atendente.setLogin(rs.getString("login"));
						atendente.setSenha(rs.getString("senha"));
					} else {
						atendente.setId(-1);
						atendente.setNome(null);
						atendente.setNascimento(null);
						atendente.setRg(null);
						atendente.setRa(null);
						atendente.setEstado(null);
						atendente.setCidade(null);
						atendente.setCep(null);
						atendente.setEmail(null);
						atendente.setLogin(null);
						atendente.setSenha(null);
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
		return atendente;
	}
	
	public ArrayList<Atendente> listarAtendentes() throws IOException {
		Atendente atendente;
		ArrayList<Atendente> lista = new ArrayList<>();
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT nome, nascimento, rg, ra, estado, cidade, cep, email, login, senha FROM Atendente";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						atendente = new Atendente();
						atendente.setNome(rs.getString("nome"));
						atendente.setNascimento(rs.getString("nascimento"));
						atendente.setRg(rs.getString("rg"));
						atendente.setRa(rs.getString("ra"));
						atendente.setEstado(rs.getString("estado"));
						atendente.setCidade(rs.getString("cidade"));
						atendente.setCep(rs.getString("cep"));
						atendente.setEmail(rs.getString("email"));
						atendente.setLogin(rs.getString("login"));
						atendente.setSenha(rs.getString("senha"));
						lista.add(atendente);
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
		return lista;
	}
	
	public ArrayList<Atendente> listarAtendentes(String chave) throws IOException {
		Atendente atendente;
		ArrayList<Atendente> lista = new ArrayList<>();
		String sqlSelect = "SELECT nome, nascimento, rg, ra, estado, cidade, cep, email, login, senha FROM Atendente where upper(nome) like ?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						atendente = new Atendente();
						atendente.setNome(rs.getString("nome"));
						atendente.setNascimento(rs.getString("nascimento"));
						atendente.setRg(rs.getString("rg"));
						atendente.setRa(rs.getString("ra"));
						atendente.setEstado(rs.getString("estado"));
						atendente.setCidade(rs.getString("cidade"));
						atendente.setCep(rs.getString("cep"));
						atendente.setEmail(rs.getString("email"));
						atendente.setLogin(rs.getString("login"));
						atendente.setSenha(rs.getString("senha"));
						lista.add(atendente);
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
		return lista;
	}
	
	public Atendente carregarEmail(Atendente atendente) throws IOException {
		String sqlSelect = "SELECT nome, nascimento, rg, ra, estado, cidade, cep, email, login, senha FROM Atendente WHERE Atendente.email like ?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, atendente.getEmail());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						atendente.setNome(rs.getString("nome"));
						atendente.setNascimento(rs.getString("nascimento"));
						atendente.setRg(rs.getString("rg"));
						atendente.setRa(rs.getString("ra"));
						atendente.setEstado(rs.getString("estado"));
						atendente.setCidade(rs.getString("cidade"));
						atendente.setCep(rs.getString("cep"));
						atendente.setEmail(rs.getString("email"));
						atendente.setLogin(rs.getString("login"));
						atendente.setSenha(rs.getString("senha"));
					} else {
						atendente.setId(-1);
						atendente.setNome(null);
						atendente.setNascimento(null);
						atendente.setRg(null);
						atendente.setRa(null);
						atendente.setEstado(null);
						atendente.setCidade(null);
						atendente.setCep(null);
						atendente.setEmail(null);
						atendente.setLogin(null);
						atendente.setSenha(null);
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
		return atendente;
	}

	public boolean validar(Atendente atendente) {
		String sqlSelect = "SELECT email, senha FROM Atendente " + "WHERE email = ? and senha = ?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, atendente.getEmail());
				stm.setString(2, atendente.getSenha());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						return true;
					} else {
						return false;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return false;
	}
}
