package br.com.pintegrador.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.pintegrador.factory.ConnectionFactory;

public class Veiculo {

	private int id_veiculo;
	private String ano;
	private String modelo;
	private double autonomia;
	
	public Veiculo(String ano, String modelo, double autonomia) {
		super();
		this.ano = ano;
		this.modelo = modelo;
		this.autonomia = autonomia;
	}

	public int getId() {
		return id_veiculo;
	}

	public void setId(int id) {
		this.id_veiculo = id;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getAutonomia() {
		return autonomia;
	}

	public void setAutonomia(double autonomia) {
		this.autonomia = autonomia;
	}
	public void save(Veiculo veiculo) {
			
			String sql = "INSERT INTO veiculo(ano, modelo, autonomia) VALUES (?, ?, ?)";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				//CRIAR UMA CONEXÃO COM O BANCO DE DADOS
				conn = ConnectionFactory.createConnectionToPostgresSQL();
				
				
				//CRIAMOS UMA PREPAREDSTATEMENT, PARA EXECUTAR UMA QUERY
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				//ADICIONAMOS OS VALORES ESPERADOS PELA QUERY
				pstm.setString(1, veiculo.getAno());
				pstm.setString(2, veiculo.getModelo());
				pstm.setDouble(3, veiculo.getAutonomia());
				
				//EXECUTAR A QUERY
				pstm.execute();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				//FECHAR AS CONEXÕES
				try {
					if(pstm!=null) {
						pstm.close();
					}
					
					if(conn!=null) {
						conn.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	
}
