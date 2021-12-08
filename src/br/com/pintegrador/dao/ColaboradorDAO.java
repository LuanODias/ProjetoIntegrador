package br.com.pintegrador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.pintegrador.factory.ConnectionFactory;
import br.com.pintegrador.model.Chamado;
import br.com.pintegrador.model.Colaborador;

public class ColaboradorDAO {
	
	/*CRUD
	 * C = CREATE
	 * R = READ
	 * U = UPDATE
	 * D = DELETE
	 * 
	 * */
	
	public void save(Colaborador colaborador) {
		
		String sql = "INSERT INTO colaborador(nome, matricula) VALUES (?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//CRIAR UMA CONEXÃO COM O BANCO DE DADOS
			conn = ConnectionFactory.createConnectionToPostgresSQL();
			
			
			//CRIAMOS UMA PREPAREDSTATEMENT, PARA EXECUTAR UMA QUERY
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//ADICIONAMOS OS VALORES ESPERADOS PELA QUERY
			pstm.setString(1, colaborador.getNome());
			pstm.setString(2, colaborador.getMatricula());
			
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
	
	public void update(int id, String nome, String matricula) {
		
		String sql = "UPDATE colaborador SET nome = ?, matricula = ? " + 
		"WHERE id_colaborador = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//CRIAR CONEXÃO COM O BANCO
			conn = ConnectionFactory.createConnectionToPostgresSQL();
			
			//CRIAR A CLASSE PARA EXECUTAR A QUERY
			pstm = conn.prepareStatement(sql);
			
			//ADICIONAR OS VALORES PARA ATUALIZAR
			pstm.setString(1, nome);
			pstm.setString(2, matricula);
			
			//QUAL O ID DO REGISTRO QUE DESEJA ATUALIZAR?
			pstm.setInt(3, id);
			
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
		
		String sql = "DELETE FROM  colaborador WHERE id_colaborador = ?";
		
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
	
	public ResultSet listar() {
		
		
		Connection conn = null;
		Statement st;
		ResultSet rs = null;
		
		try {
			//CRIAR CONEXÃO COM O BANCO
			conn = ConnectionFactory.createConnectionToPostgresSQL();
			
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM colaborador ORDER BY id_colaborador"); 
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}


}
