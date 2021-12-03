package br.com.pintegrador.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import br.com.pintegrador.factory.ConnectionFactory;
import br.com.pintegrador.model.Chamado;
import br.com.pintegrador.model.Veiculo;

public class ChamadoDAO {
	
	/*CRUD
	 * C = CREATE
	 * R = READ
	 * U = UPDATE
	 * D = DELETE
	 * 
	 * */
	
	public void save(Chamado chamado) {
		
		String sql = "INSERT INTO chamado(numero_chamado, km_rodado, co2, data_chamado, veiculo, colaborador) VALUES (?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//CRIAR UMA CONEX�O COM O BANCO DE DADOS
			conn = ConnectionFactory.createConnectionToPostgresSQL();
			
			
			//CRIAMOS UMA PREPAREDSTATEMENT, PARA EXECUTAR UMA QUERY
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//ADICIONAMOS OS VALORES ESPERADOS PELA QUERY
			pstm.setString(1, chamado.getNumero_chamado());
			pstm.setInt(2, chamado.getKm_rodado());
			pstm.setDouble(3, chamado.getCO2());
			pstm.setString(4, chamado.getData());
			pstm.setInt(5, chamado.getVeiculo());
			pstm.setInt(6, chamado.getColaborador());
			
			//EXECUTAR A QUERY
			pstm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//FECHAR AS CONEX�ES
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
		public void update(Chamado chamado) {
			
			String sql = "UPDATE chamado SET numero_chamado = ?, km_rodado = ?, co2 = ?, data_chamado = ?, veiculo = ?, colaborador = ? " + 
			"WHERE id_chamado = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				//CRIAR CONEX�O COM O BANCO
				conn = ConnectionFactory.createConnectionToPostgresSQL();
				
				//CRIAR A CLASSE PARA EXECUTAR A QUERY
				pstm = conn.prepareStatement(sql);
				
				//ADICIONAR OS VALORES PARA ATUALIZAR
				pstm.setString(1, chamado.getNumero_chamado());
				pstm.setInt(2, chamado.getKm_rodado());
				pstm.setString(3, chamado.getData());
				pstm.setInt(4, chamado.getVeiculo());
				pstm.setInt(5, chamado.getColaborador());
				
				//QUAL O ID DO REGISTRO QUE DESEJA ATUALIZAR?
				pstm.setInt(7, chamado.getId());
				
				//EXECUTAR A QUERY
				pstm.execute();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try{
					if(pstm!=null) {
						pstm.close();
					}
					if(conn!= null) {
						conn.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
		
		
		public void delete(Chamado chamado) {
			
			String sql = "DELETE FROM  chamado WHERE id_chamado = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				//CRIAR CONEX�O COM O BANCO
				conn = ConnectionFactory.createConnectionToPostgresSQL();
				
				//CRIAR A CLASSE PARA EXECUTAR A QUERY
				pstm = conn.prepareStatement(sql);
				
				//ID DELETADO
				pstm.setInt(1, chamado.getId());
				
				//EXECUTAR A QUERY
				pstm.execute();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try{
					if(pstm!=null) {
						pstm.close();
					}
					if(conn!= null) {
						conn.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		public double getAutonomia(int id) {
			String sql = "SELECT autonomia FROM veiculo WHERE id_veiculo = ?";
			
			Connection conn = null;
			Statement pstm = null;
			ResultSet resultSet = null;
			double autonomia = -1;
			try {
				//CRIAR CONEX�O COM O BANCO
				conn = ConnectionFactory.createConnectionToPostgresSQL();
				
				//CRIAR A CLASSE PARA EXECUTAR A QUERY
				pstm = conn.prepareStatement(sql);
				
				//ID DELETADO
				resultSet = pstm.executeQuery(sql);
				while (resultSet.next()) {
					autonomia = resultSet.getDouble("autonomia");
				}
		
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try{
					if(pstm!=null) {
						pstm.close();
					}
					if(conn!= null) {
						conn.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			return autonomia;
		}
}
