package br.com.pintegrador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.pintegrador.factory.ConnectionFactory;
import br.com.pintegrador.model.Veiculo;

public class VeiculoDAO {
	
	/*CRUD
	 * C = CREATE
	 * R = READ
	 * U = UPDATE
	 * D = DELETE
	 * 
	 * */
	
	public void save(Veiculo veiculo) {
		
		String sql = "INSERT INTO veiculo(ano, modelo, autonomia) VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		
		try {
			//CRIAR UMA CONEX�O COM O BANCO DE DADOS
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
	
public void update(Veiculo veiculo) {
		
		String sql = "UPDATE veiculo SET ano = ?, modelo = ?, autonomia = ? " + 
		"WHERE id_veiculo = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//CRIAR CONEX�O COM O BANCO
			conn = ConnectionFactory.createConnectionToPostgresSQL();
			
			//CRIAR A CLASSE PARA EXECUTAR A QUERY
			pstm = conn.prepareStatement(sql);
			
			//ADICIONAR OS VALORES PARA ATUALIZAR
			pstm.setString(1, veiculo.getAno());
			pstm.setString(2, veiculo.getModelo());
			pstm.setDouble(3, veiculo.getAutonomia());
			
			//QUAL O ID DO REGISTRO QUE DESEJA ATUALIZAR?
			pstm.setInt(4, veiculo.getId());
			
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
public void delete(Veiculo veiculo) {
	
	String sql = "DELETE FROM  veiculo WHERE id_veiculo = ?";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		//CRIAR CONEX�O COM O BANCO
		conn = ConnectionFactory.createConnectionToPostgresSQL();
		
		//CRIAR A CLASSE PARA EXECUTAR A QUERY
		pstm = conn.prepareStatement(sql);
		
		//ID DELETADO
		pstm.setInt(1, veiculo.getId());
		
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
public static List<Veiculo> listar(Veiculo veiculo){
	List<Veiculo> veiculos = new ArrayList<>();
	String sql = "SELECT * FROM veiculo ORDER BY id_veiculo";
	
	Connection conn = null;
	Statement pstm = null;
	ResultSet resultSet = null;
	
	try {
		//CRIAR CONEX�O COM O BANCO
		conn = ConnectionFactory.createConnectionToPostgresSQL();
		
		//CRIAR A CLASSE PARA EXECUTAR A QUERY
		pstm = conn.createStatement();
		resultSet = pstm.executeQuery(sql);

		
		while (resultSet.next()) {
            veiculo.setId(resultSet.getInt("id"));
            veiculo.setAno(resultSet.getString("ano"));
            veiculo.setModelo(resultSet.getString("modelo"));
            veiculo.setAutonomia(resultSet.getDouble("autonomia"));

            veiculos.add(veiculo);
        }
		
		//EXECUTAR A QUERY
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
		return veiculos;
}


}
