package service;

import java.io.IOException;
import java.util.ArrayList;

import dao.AtendimentoDao;
import model.Atendimento;

public class AtendimentoService {
	AtendimentoDao dao = new AtendimentoDao();
	
	public int criar(Atendimento atendimento, int cliente) throws IOException {
		return dao.criar(atendimento, cliente);
	}
	
	public void atualizar(Atendimento atendimento) throws IOException {
		dao.atualizar(atendimento);
	}
	
	public void excluir(int id) throws IOException {
		dao.excluir(id);
	}
	
	public Atendimento carregar(int id) throws IOException {
		return dao.carregar(id);
	}
			
	public ArrayList<Atendimento> listarAtendimentos() throws IOException {
		return dao.listarAtendimentos();
	}
	public void adicionarAcerto(Atendimento atendimento) throws IOException {
		dao.adicionarAcerto(atendimento);
	}
	public void adicionarErro(Atendimento atendimento) throws IOException {
		dao.adicionarErro(atendimento);
	}
	
	//------MENSAL---MENSAL------MENSAL---MENSAL----MENSAL----MENSAL-----MENSAL---MENSAL----MENSAL----
	public int totalAtendimentosMesAnterior() throws IOException {
		return dao.totalAtendimentosMesAnterior();
	}
	public int relatarFalhasMesAnterior() throws IOException {
		return dao.relatarFalhasMesAnterior();
	}
	public int relatarAcertosMesAnterior() throws IOException {
		return dao.relatarAcertosMesAnterior();
	}
	public int atendimentosResolvidosFirstMesAnterior() throws IOException {
		return dao.atendimentosResolvidosFirstMesAnterior();
	}
	public int atendimentosResolvidosSecondMesAnterior() throws IOException {
		return dao.atendimentosResolvidosSecondMesAnterior();
	}
	public int atendimentosResolvidosThirdMesAnterior() throws IOException {
		return dao.atendimentosResolvidosThirdMesAnterior();
	}
	public int atendimentosHumanosMesAnterior() throws IOException {
		return dao.atendimentosHumanosMesAnterior();
	}
	public int totalInteracoesMesAnterior() throws IOException {
		return dao.totalInteracoesMesAnterior();
	}
	public ArrayList<Atendimento> listarAtendimentosMensal() throws IOException {
		return dao.listarAtendimentosMensal();
	}
	//----SEMANAL------SEMANAL------SEMANAL------SEMANAL----------SEMANAL-----------SEMANAL---SEMANAL---
	public int relatarFalhasSemanais() throws IOException {
		return dao.relatarFalhasSemanais();
	}
	public int relatarAcertosSemanais() throws IOException {
		return dao.relatarAcertosSemanais();
	}
	public int totalAtendimentosSemanais() throws IOException {
		return dao.totalAtendimentosSemanais();
	}
	public int atendimentosResolvidosFirstSemanais() throws IOException {
		return dao.atendimentosResolvidosFirstSemanais();
	}
	public int atendimentosResolvidosSecondSemanais() throws IOException {
		return dao.atendimentosResolvidosSecondSemanais();
	}
	public int atendimentosResolvidosThirdSemanais() throws IOException {
		return dao.atendimentosResolvidosThirdSemanais();
	}
	public int atendimentosHumanosSemanais() throws IOException {
		return dao.atendimentosHumanosSemanais();
	}
	public int totalInteracoesSemanais() throws IOException {
		return dao.totalInteracoesSemanais();
	}
	public ArrayList<Atendimento> listarAtendimentosSemanais() throws IOException {
		return dao.listarAtendimentosSemanais();
	}
	
	//----DIARIO-------DIARIO-------DIARIO------DIARIO------DIARIO----DIARIO------DIARIO------DIARIO-----
	public int relatarFalhasDiarios() throws IOException {
		return dao.relatarFalhasDiarios();
	}
	public int relatarAcertosSDiarios() throws IOException {
		return dao.relatarAcertosDiarios();
	}
	public int totalAtendimentosDiarios() throws IOException {
		return dao.totalAtendimentosDiarios();
	}
	public int atendimentosResolvidosFirstDiarios() throws IOException {
		return dao.atendimentosResolvidosFirstDiarios();
	}
	public int atendimentosResolvidosSecondDiarios() throws IOException {
		return dao.atendimentosResolvidosSecondDiarios();
	}
	public int atendimentosResolvidosThirdDiarios() throws IOException {
		return dao.atendimentosResolvidosThirdDiarios();
	}
	public int atendimentosHumanosDiarios() throws IOException {
		return dao.atendimentosHumanosDiarios();
	}
	public int totalInteracoesDiarios() throws IOException {
		return dao.totalInteracoesDiarios();
	}
	public ArrayList<Atendimento> listarAtendimentosDiarios() throws IOException {
		return dao.listarAtendimentosDiarios();
	}
}