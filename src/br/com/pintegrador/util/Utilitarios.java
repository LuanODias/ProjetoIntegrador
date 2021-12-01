package br.com.pintegrador.util;
import javax.swing.JFrame;

import br.com.pintegrador.interfaces.TelaCadastroChamado;
import br.com.pintegrador.interfaces.TelaCadastroColaborador;
import br.com.pintegrador.interfaces.TelaCadastroVeiculo;
import br.com.pintegrador.interfaces.TelaListagemChamado;
import br.com.pintegrador.interfaces.TelaListagemColaborador;
import br.com.pintegrador.interfaces.TelaListagemVeiculo;

public class Utilitarios {

	public void telas(String tela, JFrame menu) {
		switch(tela) {
		case "chamado":
				TelaListagemChamado telaChamado = new TelaListagemChamado();
				telaChamado.setVisible(true);
				menu.setVisible(false);
				break;
		case "veiculo":
				TelaListagemVeiculo telaVeiculo = new TelaListagemVeiculo();
				telaVeiculo.setVisible(true);
				menu.setVisible(false);
				break;
		case "colaborador":
				TelaListagemColaborador telaColaborador = new TelaListagemColaborador();
				telaColaborador.setVisible(true);
				menu.setVisible(false);
				break;
		case "criarVeiculo": 
				TelaCadastroVeiculo telaCriarVeiculo = new TelaCadastroVeiculo();
				telaCriarVeiculo.setVisible(true);
				menu.setVisible(false);
				break;
		case "criarChamado": 
				TelaCadastroChamado telaCriarChamado = new TelaCadastroChamado();
				telaCriarChamado.setVisible(true);
				menu.setVisible(false);
				break;
		case "criarColaborador":
				TelaCadastroColaborador telaCriarColaborador = new TelaCadastroColaborador();
				telaCriarColaborador.setVisible(true);
				menu.setVisible(false);
				break;
		}
		
		
	}
}
