package br.com.pintegrador.main;

import br.com.pintegrador.dao.ChamadoDAO;
import br.com.pintegrador.dao.ColaboradorDAO;
import br.com.pintegrador.dao.VeiculoDAO;
import br.com.pintegrador.model.Chamado;

public class Main {

	public static void main(String[] args) {
		
		//DAOS CRIADOS
		ColaboradorDAO colaboradordao = new ColaboradorDAO();
		VeiculoDAO veiculodao = new VeiculoDAO();
		ChamadoDAO chamadodao = new ChamadoDAO();
		
		//CRIA��O DOS NOVOS OBJETOS
	//	Colaborador colaborador = new Colaborador("teste", "123456789");
 	//	Veiculo veiculo = new Veiculo("1970", "Chevette", 10.99);
		Chamado chamado = new Chamado("123123", 200, 300, "01012000", 3, 1);
		
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
		
		//NUMERO QUE EST� NO BD.

//		v1.setId(1);
//		ch1.setId(1);
		
		
		
		
		//CHAMADA DO UPDATE
//		colaboradordao.update(c1);
//		veiculodao.update(v1);
//		chamadodao.update(ch1);
		

//		veiculodao.delete(v1);
//		chamadodao.delete(ch1);
		
		
		
		String dataFormatada =  dataChamado.getText().substring(0, 2) + "/" +
								dataChamado.getText().substring(2, 4) + "/" +
								dataChamado.getText().substring(4, 8);
					
		Chamado chamado = new Chamado("1231123", 40,dataFormatada, veiculochamado, colaboradorchamado);
		double autonomia = DAO.getAutonomia(veiculochamado);
		chamado.calularPegadaCarbono(kmChamado, autonomia);
		DAO.save(chamado);
		
		
		
		
		
	}

}
