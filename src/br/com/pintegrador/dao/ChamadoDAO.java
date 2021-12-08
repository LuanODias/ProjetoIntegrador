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
	
	public void save(String numeroChamado, int km_rodade, String co2, String data, double veiculochamado, int colaborador) {
		
		String sql = "INSERT INTO chamado(numero_chamado, km_rodado, co2, data_chamado, veiculo, colaborador) VALUES (?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//CRIAR UMA CONEXï¿½O COM O BANCO DE DADOS
			conn = ConnectionFactory.createConnectionToPostgresSQL();
			
			
			//CRIAMOS UMA PREPAREDSTATEMENT, PARA EXECUTAR UMA QUERY
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//ADICIONAMOS OS VALORES ESPERADOS PELA QUERY
			pstm.setString(1, numeroChamado);
			pstm.setInt(2, km_rodade);
			pstm.setString(3, co2);
			pstm.setString(4, data);
			pstm.setDouble(5, veiculochamado);
			pstm.setInt(6, colaborador);
			
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
		public void update(int id, String numeroChamado, int km_rodado, String data, int veiculo, int colaborador) {
			
			String sql = "UPDATE chamado SET numero_chamado = ?, km_rodado = ?, data_chamado = ?, veiculo = ?, colaborador = ? " + 
			"WHERE id_chamado = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				//CRIAR CONEXÃO COM O BANCO
				conn = ConnectionFactory.createConnectionToPostgresSQL();
				
				//CRIAR A CLASSE PARA EXECUTAR A QUERY
				pstm = conn.prepareStatement(sql);
				
				//ADICIONAR OS VALORES PARA ATUALIZAR
				pstm.setString(1, numeroChamado);
				pstm.setInt(2, km_rodado);
				pstm.setString(3, data);
				pstm.setInt(4, veiculo);
				pstm.setInt(5, colaborador);
				
				//QUAL O ID DO REGISTRO QUE DESEJA ATUALIZAR?
				pstm.setInt(6, id);
				
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
		
		
		public void delete(int id) {
			
			String sql = "DELETE FROM  chamado WHERE id_chamado = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				//CRIAR CONEXÃO COM O BANCO
				conn = ConnectionFactory.createConnectionToPostgresSQL();
				
				//CRIAR A CLASSE PARA EXECUTAR A QUERY
				pstm = conn.prepareStatement(sql);
				
				//ID DELETADO
				pstm.setInt(1, id);
				
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
		
		public double getAutonomia(Double id) throws Exception {
			
			Connection conn = null;
			conn = ConnectionFactory.createConnectionToPostgresSQL();
			Statement st = conn.createStatement();
			ResultSet rs2 = st.executeQuery("SELECT autonomia FROM veiculo WHERE id_veiculo = " + id);
			rs2.next();
			Double autonomia = rs2.getDouble(1);
			
			try {
				//CRIAR CONEXÃO COM O BANCO
				conn = ConnectionFactory.createConnectionToPostgresSQL();
				
		
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try{
					if(st!=null) {
						st.close();
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
		
		public ResultSet listar() {
			
			
			Connection conn = null;
			Statement st;
			ResultSet rs = null;
			
			try {
				//CRIAR CONEXÃO COM O BANCO
				conn = ConnectionFactory.createConnectionToPostgresSQL();
				
				st = conn.createStatement();
				rs = st.executeQuery("SELECT * FROM chamado ORDER BY id_chamado"); 
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return rs;
		}

}
