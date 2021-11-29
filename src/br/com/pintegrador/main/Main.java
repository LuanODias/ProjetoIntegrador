package br.com.pintegrador.main;

import java.sql.Date;

import br.com.pintegrador.dao.ChamadoDAO;
import br.com.pintegrador.dao.ColaboradorDAO;
import br.com.pintegrador.dao.VeiculoDAO;
import br.com.pintegrador.model.Chamado;
import br.com.pintegrador.model.Colaborador;
import br.com.pintegrador.model.Veiculo;

public class Main {

	public static void main(String[] args) {
		
		//DAOS CRIADOS
		ColaboradorDAO colaboradordao = new ColaboradorDAO();
		VeiculoDAO veiculodao = new VeiculoDAO();
		ChamadoDAO chamadodao = new ChamadoDAO();
		
		//CRIAÇÃO DOS NOVOS OBJETOS
	//	Colaborador colaborador = new Colaborador("teste", "123456789");
 	//	Veiculo veiculo = new Veiculo("1970", "Chevette", 10.99);
		Chamado chamado = new Chamado("123123", 200, 300, new Date(0), 3, 2);
		
		//SALVANDO NO BANCO DE DADOS
	//	colaboradordao.save(colaborador);
	//	veiculodao.save(veiculo);
		chamadodao.save(chamado);
		
		//ATUALIZAR O COLABORADOR
		//Colaborador c1 = new Colaborador("Luan de Oliveira Dias", "123456789");
		
		//ATUALIZAR O VEICULO
		//Veiculo v1 = new Veiculo("1998", "Corolla", 10.00);
		
		//ATUALIZAR O CHAMADO
//		Chamado ch1 = new Chamado("321321", 100, 100, new Date(1), 1 ,2);
		
		//NUMERO QUE ESTï¿½ NO BD.

//		v1.setId(1);
//		ch1.setId(1);
		
		
		
		
		//CHAMADA DO UPDATE
//		colaboradordao.update(c1);
//		veiculodao.update(v1);
//		chamadodao.update(ch1);
		

//		veiculodao.delete(v1);
//		chamadodao.delete(ch1);
		
		
		
		
		
	}

}
