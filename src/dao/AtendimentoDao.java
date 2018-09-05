package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.sun.jmx.snmp.Timestamp;

import model.Atendimento;;

public class AtendimentoDao {

	public int criar(Atendimento atendimento, int cliente) throws IOException {
		String sqlInsert = "INSERT INTO Atendimento( aberto, dataCriacao, Cliente_id, AcertosBot, ErrosBot) VALUES (?, ?, ?, ?, ?)";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
				stm.setBoolean(1, atendimento.isAberto());
				stm.setTimestamp(2, atendimento.getDataCriacao());
				stm.setInt(3, cliente);
				stm.setInt(4, atendimento.getAcertosBot());
				stm.setInt(5, atendimento.getErrosBot());
				stm.execute();
				String sqlQuery = "SELECT LAST_INSERT_ID()";
				try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
						ResultSet rs = stm2.executeQuery();) {
					if (rs.next()) {
						atendimento.setId(rs.getInt(1));
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
		return atendimento.getId();
	}
	
	public void atualizar(Atendimento atendimento) throws IOException {
		String sqlUpdate = "UPDATE Atendimento SET aberto=? WHERE id=?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlUpdate)){
				stm.setBoolean(1, atendimento.isAberto());
				stm.setInt(2, atendimento.getId());
				stm.execute();
			} catch (Exception e){
				e.printStackTrace();
				throw new IOException();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new IOException();
		}
	}
	public void fechar(Atendimento atendimento) throws IOException {
		String sqlUpdate = "UPDATE Atendimento SET aberto=? WHERE id=?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlUpdate)){
				stm.setBoolean(1, atendimento.isAberto());
				stm.setInt(2, atendimento.getId());
				stm.execute();
			} catch (Exception e){
				e.printStackTrace();
				throw new IOException();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new IOException();
		}
	}
	public void adicionarAcerto(Atendimento atendimento) throws IOException {
		String sqlUpdate = "UPDATE Atendimento SET AcertosBot=? WHERE id=?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlUpdate)){
				stm.setInt(1, atendimento.getAcertosBot() + 1);
				stm.setInt(2, atendimento.getId());
				stm.execute();
			} catch (Exception e){
				e.printStackTrace();
				throw new IOException();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new IOException();
		}
	}
	public void adicionarErro(Atendimento atendimento) throws IOException {
		String sqlUpdate = "UPDATE Atendimento SET ErrosBot=? WHERE id=?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlUpdate)){
				stm.setInt(1, atendimento.getErrosBot() + 1);
				stm.setInt(2, atendimento.getId());
				stm.execute();
			} catch (Exception e){
				e.printStackTrace();
				throw new IOException();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new IOException();
		}
	}
	
	public void excluir(int id) throws IOException {
		String sqlDelete = "DELETE FROM Atendimento WHERE id = ?";
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
	
	public Atendimento carregar(int id) throws IOException {
		Atendimento atendimento = new Atendimento();
		atendimento.setId(id);
		String sqlSelect = "SELECT aberto, dataCriacao, Cliente_id, Atendente_id, AcertosBot, ErrosBot  FROM Atendimento WHERE Atendimento.id = ?";
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, atendimento.getId());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						atendimento.setAberto(rs.getBoolean("aberto"));
						atendimento.setDataCriacao(rs.getTimestamp("dataCriacao"));
						atendimento.setClienteId(rs.getInt("Cliente_id"));
						atendimento.setAcertosBot(rs.getInt("AcertosBot"));
						atendimento.setErrosBot(rs.getInt("ErrosBot"));
						
					} else {
						atendimento.setId(-1);
						atendimento.setDataCriacao(null);
						atendimento.setAberto(false);
						atendimento.setClienteId(-1);
						atendimento.setAcertosBot(-1);
						atendimento.setErrosBot(-1);
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
		return atendimento;
	}
	
	public ArrayList<Atendimento> listarAtendimentos() throws IOException {
		Atendimento atendimento = null;
		ArrayList<Atendimento> lista = new ArrayList<>();
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT id, aberto, dataCriacao FROM Atendimento";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						atendimento = new Atendimento();
						atendimento.setId(rs.getInt("id"));
						atendimento.setAberto(rs.getBoolean("aberto"));
						atendimento.setDataCriacao(rs.getTimestamp("dataCriacao"));
						lista.add(atendimento);
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
	public int relatarFalhasMesAnterior() throws IOException {
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		//dat.add(Calendar.MONTH,-1);
		dat.set(Calendar.DAY_OF_MONTH, 1);
		java.sql.Timestamp inicioMes = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.DAY_OF_MONTH, dat.getActualMaximum(Calendar.DAY_OF_MONTH));
		java.sql.Timestamp finalMes = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(finalMes);
		System.out.println(inicioMes);
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT ErrosBot FROM atendimento WHERE dataCriacao >= ? and dataCriacao < ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, inicioMes);
				stm.setTimestamp(2, finalMes);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						cont = cont + rs.getInt("ErrosBot");
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
		return cont;
	}
	public int relatarAcertosMesAnterior() throws IOException {
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		//dat.add(Calendar.MONTH,-1);
		dat.set(Calendar.DAY_OF_MONTH, 1);
		java.sql.Timestamp inicioMes = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.DAY_OF_MONTH, dat.getActualMaximum(Calendar.DAY_OF_MONTH));
		java.sql.Timestamp finalMes = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(finalMes);
		System.out.println(inicioMes);
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT AcertosBot FROM atendimento WHERE dataCriacao >= ? and dataCriacao < ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, inicioMes);
				stm.setTimestamp(2, finalMes);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						cont = cont + rs.getInt("AcertosBot");
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
		return cont;
	}
	public int totalAtendimentosMesAnterior() throws IOException {
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		//dat.add(Calendar.MONTH,-1);
		dat.set(Calendar.DAY_OF_MONTH, 1);
		java.sql.Timestamp inicioMes = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.DAY_OF_MONTH, dat.getActualMaximum(Calendar.DAY_OF_MONTH));
		java.sql.Timestamp finalMes = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(finalMes);
		System.out.println(inicioMes);
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT * FROM atendimento WHERE dataCriacao >= ? and dataCriacao < ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, inicioMes);
				stm.setTimestamp(2, finalMes);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						cont++;
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
		return cont;
	}
	public int atendimentosResolvidosFirstMesAnterior() throws IOException {
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		//dat.add(Calendar.MONTH,-1);
		dat.set(Calendar.DAY_OF_MONTH, 1);
		java.sql.Timestamp inicioMes = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.DAY_OF_MONTH, dat.getActualMaximum(Calendar.DAY_OF_MONTH));
		java.sql.Timestamp finalMes = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(finalMes);
		System.out.println(inicioMes);
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT * FROM atendimento WHERE dataCriacao >= ? and dataCriacao < ? and Aberto  =  false and ErrosBot = 0";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, inicioMes);
				stm.setTimestamp(2, finalMes);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						cont++;
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
		return cont;
	}
	public int atendimentosResolvidosSecondMesAnterior() throws IOException {
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		//dat.add(Calendar.MONTH,-1);
		dat.set(Calendar.DAY_OF_MONTH, 1);
		java.sql.Timestamp inicioMes = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.DAY_OF_MONTH, dat.getActualMaximum(Calendar.DAY_OF_MONTH));
		java.sql.Timestamp finalMes = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(finalMes);
		System.out.println(inicioMes);
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT * FROM atendimento WHERE dataCriacao >= ? and dataCriacao < ? and Aberto  =  false and ErrosBot = 1";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, inicioMes);
				stm.setTimestamp(2, finalMes);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						cont++;
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
		return cont;
	}
	public int atendimentosResolvidosThirdMesAnterior() throws IOException {
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		//dat.add(Calendar.MONTH,-1);
		dat.set(Calendar.DAY_OF_MONTH, 1);
		java.sql.Timestamp inicioMes = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.DAY_OF_MONTH, dat.getActualMaximum(Calendar.DAY_OF_MONTH));
		java.sql.Timestamp finalMes = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(finalMes);
		System.out.println(inicioMes);
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT * FROM atendimento WHERE dataCriacao >= ? and dataCriacao < ? and Aberto  =  false and ErrosBot = 2";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, inicioMes);
				stm.setTimestamp(2, finalMes);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						cont++;
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
		return cont;
	}
	public int atendimentosHumanosMesAnterior() throws IOException {
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		//dat.add(Calendar.MONTH,-1);
		dat.set(Calendar.DAY_OF_MONTH, 1);
		java.sql.Timestamp inicioMes = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.DAY_OF_MONTH, dat.getActualMaximum(Calendar.DAY_OF_MONTH));
		java.sql.Timestamp finalMes = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(finalMes);
		System.out.println(inicioMes);
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT * FROM atendimento WHERE dataCriacao >= ? and dataCriacao < ? and Aberto  =  false and ErrosBot > 2";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, inicioMes);
				stm.setTimestamp(2, finalMes);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						cont++;
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
		return cont;
	}
	public int totalInteracoesMesAnterior() throws IOException {
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		//dat.add(Calendar.MONTH,-1);
		dat.set(Calendar.DAY_OF_MONTH, 1);
		java.sql.Timestamp inicioMes = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.DAY_OF_MONTH, dat.getActualMaximum(Calendar.DAY_OF_MONTH));
		java.sql.Timestamp finalMes = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(finalMes);
		System.out.println(inicioMes);
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "Select * from historico inner join atendimento on atendimento.id = historico_atendimento_id and hora >= ? and hora < ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, inicioMes);
				stm.setTimestamp(2, finalMes);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						cont++;
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
		return cont;
	}
	public ArrayList<Atendimento> listarAtendimentosMensal() throws IOException {
		Atendimento atendimento = null;
		ArrayList<Atendimento> lista = new ArrayList<>();
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		//dat.add(Calendar.MONTH,-1);
		dat.set(Calendar.DAY_OF_MONTH, 1);
		java.sql.Timestamp inicioMes = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.DAY_OF_MONTH, dat.getActualMaximum(Calendar.DAY_OF_MONTH));
		java.sql.Timestamp finalMes = new java.sql.Timestamp(dat.getTimeInMillis());
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT id, aberto, dataCriacao FROM Atendimento WHERE dataCriacao >= ? and dataCriacao < ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, inicioMes);
				stm.setTimestamp(2, finalMes);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						atendimento = new Atendimento();
						atendimento.setId(rs.getInt("id"));
						atendimento.setAberto(rs.getBoolean("aberto"));
						atendimento.setDataCriacao(rs.getTimestamp("dataCriacao"));
						lista.add(atendimento);
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
	
	//--------SEMANAL-----------------SEMANAL-----------SEMANAL-----------------SEMANAL-------------------SEMANAL-------------//----------SEMANAL-------SEMANAL-------------------SEMANAL-----------SEMANAL-------------SEMANAL--------
	public int relatarFalhasSemanais() throws IOException {
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		dat.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		java.sql.Timestamp domingo = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		java.sql.Timestamp sabado = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(sabado);
		System.out.println(domingo);
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT ErrosBot FROM atendimento WHERE dataCriacao >= ? and dataCriacao < ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, domingo);
				stm.setTimestamp(2, sabado);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						cont = cont + rs.getInt("ErrosBot");
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
		return cont;
	}
	public int relatarAcertosSemanais() throws IOException {
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		dat.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		java.sql.Timestamp domingo = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		java.sql.Timestamp sabado = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(sabado);
		System.out.println(domingo);
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT AcertosBot FROM atendimento WHERE dataCriacao >= ? and dataCriacao < ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, domingo);
				stm.setTimestamp(2, sabado);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						cont = cont + rs.getInt("AcertosBot");
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
		return cont;
	}
	public int totalAtendimentosSemanais() throws IOException {
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		dat.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		java.sql.Timestamp domingo = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		java.sql.Timestamp sabado = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(sabado);
		System.out.println(domingo);
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT * FROM atendimento WHERE dataCriacao >= ? and dataCriacao < ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, domingo);
				stm.setTimestamp(2, sabado);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						cont++;
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
		return cont;
	}
	public int atendimentosResolvidosFirstSemanais() throws IOException {
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		dat.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		java.sql.Timestamp domingo = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		java.sql.Timestamp sabado = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(sabado);
		System.out.println(domingo);
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT * FROM atendimento WHERE dataCriacao >= ? and dataCriacao < ? and Aberto  =  false and ErrosBot = 0";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, domingo);
				stm.setTimestamp(2, sabado);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						cont++;
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
		return cont;
	}
	public int atendimentosResolvidosSecondSemanais() throws IOException {
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		dat.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		java.sql.Timestamp domingo = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		java.sql.Timestamp sabado = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(sabado);
		System.out.println(domingo);
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT * FROM atendimento WHERE dataCriacao >= ? and dataCriacao < ? and Aberto  =  false and ErrosBot = 1";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, domingo);
				stm.setTimestamp(2, sabado);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						cont++;
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
		return cont;
	}
	public int atendimentosResolvidosThirdSemanais() throws IOException {
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		dat.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		java.sql.Timestamp domingo = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		java.sql.Timestamp sabado = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(sabado);
		System.out.println(domingo);
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT * FROM atendimento WHERE dataCriacao >= ? and dataCriacao < ? and Aberto  =  false and ErrosBot = 2";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, domingo);
				stm.setTimestamp(2, sabado);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						cont++;
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
		return cont;
	}
	public int atendimentosHumanosSemanais() throws IOException {
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		dat.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		java.sql.Timestamp domingo = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		java.sql.Timestamp sabado = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(sabado);
		System.out.println(domingo);
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT * FROM atendimento WHERE dataCriacao >= ? and dataCriacao < ? and Aberto  =  false and ErrosBot > 2";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, domingo);
				stm.setTimestamp(2, sabado);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						cont++;
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
		return cont;
	}
	public int totalInteracoesSemanais() throws IOException {
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		dat.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		java.sql.Timestamp domingo = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		java.sql.Timestamp sabado = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(sabado);
		System.out.println(domingo);
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "Select * from historico inner join atendimento on atendimento.id = historico_atendimento_id and hora >= ? and hora < ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, domingo);
				stm.setTimestamp(2, sabado);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						cont++;
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
		return cont;
	}
	public ArrayList<Atendimento> listarAtendimentosSemanais() throws IOException {
		Atendimento atendimento = null;
		ArrayList<Atendimento> lista = new ArrayList<>();
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		dat.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		java.sql.Timestamp domingo = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		java.sql.Timestamp sabado = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(sabado);
		System.out.println(domingo);
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT id, aberto, dataCriacao FROM Atendimento WHERE dataCriacao >= ? and dataCriacao < ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, domingo);
				stm.setTimestamp(2, sabado);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						atendimento = new Atendimento();
						atendimento.setId(rs.getInt("id"));
						atendimento.setAberto(rs.getBoolean("aberto"));
						atendimento.setDataCriacao(rs.getTimestamp("dataCriacao"));
						lista.add(atendimento);
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
	//---DIARIO--DIARIO---DIARIO----DIARIO----DIARIO--DIARIO----DIARIO----DIARIO--DIARIO---DIARIO---
	public int relatarFalhasDiarios() throws IOException {
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		dat.set(Calendar.HOUR_OF_DAY, 00);
		dat.set(Calendar.MINUTE, 00);
		java.sql.Timestamp inicio = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.HOUR_OF_DAY, 23);
		dat.set(Calendar.MINUTE, 00);
		java.sql.Timestamp fim = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(fim);
		System.out.println(inicio);
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT ErrosBot FROM atendimento WHERE dataCriacao >= ? and dataCriacao < ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, inicio);
				stm.setTimestamp(2, fim);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						cont = cont + rs.getInt("ErrosBot");
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
		return cont;
	}
	public int relatarAcertosDiarios() throws IOException {
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		dat.set(Calendar.HOUR_OF_DAY, 00);
		dat.set(Calendar.MINUTE, 00);
		java.sql.Timestamp inicio = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.HOUR_OF_DAY, 23);
		dat.set(Calendar.MINUTE, 00);
		java.sql.Timestamp fim = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(fim);
		System.out.println(inicio);
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT AcertosBot FROM atendimento WHERE dataCriacao >= ? and dataCriacao < ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, inicio);
				stm.setTimestamp(2, fim);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						cont = cont + rs.getInt("AcertosBot");
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
		return cont;
	}
	public int totalAtendimentosDiarios() throws IOException {
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		dat.set(Calendar.HOUR_OF_DAY, 00);
		dat.set(Calendar.MINUTE, 00);
		java.sql.Timestamp inicio = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.HOUR_OF_DAY, 23);
		dat.set(Calendar.MINUTE, 00);
		java.sql.Timestamp fim = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(fim);
		System.out.println(inicio);
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT * FROM atendimento WHERE dataCriacao >= ? and dataCriacao < ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, inicio);
				stm.setTimestamp(2, fim);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						cont++;
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
		return cont;
	}
	public int atendimentosResolvidosFirstDiarios() throws IOException {
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		dat.set(Calendar.HOUR_OF_DAY, 00);
		dat.set(Calendar.MINUTE, 00);
		java.sql.Timestamp inicio = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.HOUR_OF_DAY, 23);
		dat.set(Calendar.MINUTE, 00);
		java.sql.Timestamp fim = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(fim);
		System.out.println(inicio);
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT * FROM atendimento WHERE dataCriacao >= ? and dataCriacao < ? and Aberto  =  false and ErrosBot = 0";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, inicio);
				stm.setTimestamp(2, fim);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						cont++;
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
		return cont;
	}
	public int atendimentosResolvidosSecondDiarios() throws IOException {
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		dat.set(Calendar.HOUR_OF_DAY, 00);
		dat.set(Calendar.MINUTE, 00);
		java.sql.Timestamp inicio = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.HOUR_OF_DAY, 23);
		dat.set(Calendar.MINUTE, 00);
		java.sql.Timestamp fim = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(fim);
		System.out.println(inicio);
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT * FROM atendimento WHERE dataCriacao >= ? and dataCriacao < ? and Aberto  =  false and ErrosBot = 1";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, inicio);
				stm.setTimestamp(2, fim);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						cont++;
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
		return cont;
	}
	public int atendimentosResolvidosThirdDiarios() throws IOException {
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		dat.set(Calendar.HOUR_OF_DAY, 00);
		dat.set(Calendar.MINUTE, 00);
		java.sql.Timestamp inicio = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.HOUR_OF_DAY, 23);
		dat.set(Calendar.MINUTE, 00);
		java.sql.Timestamp fim = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(fim);
		System.out.println(inicio);
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT * FROM atendimento WHERE dataCriacao >= ? and dataCriacao < ? and Aberto  =  false and ErrosBot = 2";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, inicio);
				stm.setTimestamp(2, fim);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						cont++;
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
		return cont;
	}
	public int atendimentosHumanosDiarios() throws IOException {
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		dat.set(Calendar.HOUR_OF_DAY, 00);
		dat.set(Calendar.MINUTE, 00);
		java.sql.Timestamp inicio = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.HOUR_OF_DAY, 23);
		dat.set(Calendar.MINUTE, 00);
		java.sql.Timestamp fim = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(fim);
		System.out.println(inicio);
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT * FROM atendimento WHERE dataCriacao >= ? and dataCriacao < ? and Aberto  =  false and ErrosBot > 2";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, inicio);
				stm.setTimestamp(2, fim);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						cont++;
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
		return cont;
	}
	public int totalInteracoesDiarios() throws IOException {
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		dat.set(Calendar.HOUR_OF_DAY, 00);
		dat.set(Calendar.MINUTE, 00);
		java.sql.Timestamp inicio = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.HOUR_OF_DAY, 23);
		dat.set(Calendar.MINUTE, 00);
		java.sql.Timestamp fim = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(fim);
		System.out.println(inicio);
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "Select * from historico inner join atendimento on atendimento.id = historico_atendimento_id and hora >= ? and hora < ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, inicio);
				stm.setTimestamp(2, fim);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						cont++;
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
		return cont;
	}
	public ArrayList<Atendimento> listarAtendimentosDiarios() throws IOException {
		Atendimento atendimento = null;
		ArrayList<Atendimento> lista = new ArrayList<>();
		int cont = 0;
		Calendar dat = Calendar.getInstance();
		java.sql.Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		dat.setTime(new Date(c.getTime()));
		dat.set(Calendar.HOUR_OF_DAY, 00);
		dat.set(Calendar.MINUTE, 00);
		java.sql.Timestamp inicio = new java.sql.Timestamp(dat.getTimeInMillis());
		dat.set(Calendar.HOUR_OF_DAY, 23);
		dat.set(Calendar.MINUTE, 00);
		java.sql.Timestamp fim = new java.sql.Timestamp(dat.getTimeInMillis());
		System.out.println(fim);
		System.out.println(inicio);
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			String sqlSelect = "SELECT id, aberto, dataCriacao FROM Atendimento WHERE dataCriacao >= ? and dataCriacao < ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setTimestamp(1, inicio);
				stm.setTimestamp(2, fim);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						// montando a data atrav�s do calendar
						atendimento = new Atendimento();
						atendimento.setId(rs.getInt("id"));
						atendimento.setAberto(rs.getBoolean("aberto"));
						atendimento.setDataCriacao(rs.getTimestamp("dataCriacao"));
						lista.add(atendimento);
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
	
}